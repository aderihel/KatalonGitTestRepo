import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.lang.Integer as Integer
import java.sql.*
import java.util.Date as Date
import java.sql.Timestamp as Timestamp

CustomKeywords.'database.methods.connectDB'('10.35.65.18', 'ibank', '3306', 'briopr', 'Tanyapakkholis')

Timestamp tempUnixTime = new Timestamp(System.currentTimeMillis())

String unixTime = tempUnixTime.getTime().toString()

GlobalVariable.reqClient = 'BRIMON'

GlobalVariable.reqRefnum = CustomKeywords.'database.methods.updateRefNum'()

GlobalVariable.reqUsername = 'bribri0001'

GlobalVariable.reqPurchase_number = '087705361213'

GlobalVariable.reqPurchase_id = '15'

GlobalVariable.reqAdd_data = '301341'

GlobalVariable.reqTimestamp = unixTime

GlobalVariable.reqChannel_id = 'NBMB'

ResultSet info_db = CustomKeywords.'database.methods.executeQuery'(('SELECT * FROM tbl_purchase_type WHERE id = "' + GlobalVariable.reqPurchaseId) +
	'"')

info_db.next()

GlobalVariable.reqToEsb = info_db.getString('url_service_inquiry')

CustomKeywords.'database.methods.executeUpdate'('UPDATE tbl_purchase_type SET url_service_inquiry = "timeout" WHERE id = "'+ GlobalVariable.reqPurchaseId +'"')

response = WS.sendRequest(findTestObject('Ferrypier Wallet/Inquiry/Inquiry Ferrypier', [('client') : GlobalVariable.reqClient
            , ('request_refnum') : GlobalVariable.reqRefnum, ('username') : GlobalVariable.reqUsername, ('purchase_number') : GlobalVariable.reqPurchaseNumber
            , ('purchase_id') : GlobalVariable.reqPurchaseId, ('timestamp') : GlobalVariable.reqTimestamp, ('additional_data') : GlobalVariable.reqAdditionalData
            , ('channel_id') : GlobalVariable.reqChannelId]))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

WS.comment(result.toString())

String response_code = result.response_code

String code_length = response_code.length()

String response_id = result.response_id

String response_refnum = result.response_refnum

String refnum_length = response_refnum.length()

String response_desc = result.response_desc

String response_data = result.response_data

CustomKeywords.'database.methods.executeUpdate'('UPDATE tbl_purchase_type SET url_service_inquiry = "'+ GlobalVariable.reqToEsb +'" WHERE id = "'+ GlobalVariable.reqPurchaseId +'"')

WS.comment('#29 Verify Verify if Response Code is not null')

WS.verifyNotMatch(response_code, null, false)

WS.comment('#31 Verify Verify if Response Id is not null')

WS.verifyNotMatch(response_id, null, false)

WS.comment('#33 Verify Verify if Response Refnum is not null')

WS.verifyNotMatch(response_refnum, null, false)

WS.comment('#35 Verify Verify if Response Desc is not null')

WS.verifyNotMatch(response_desc, null, false)

WS.comment('#37 Verify Verify if Response Data is not null')

WS.verifyNotMatch(response_data, null, false)

WS.comment('#39 Verify Verify if Response Code Length is 2')

WS.verifyMatch(code_length, '2', false)

WS.comment('#41 Verify Verify if Response Refnum Length is 12')

WS.verifyMatch(refnum_length, '12', false)

WS.comment('#43 Verify Verify if Response Code is TE')

WS.verifyMatch(response_code, 'TE', false)

ResultSet trx_log_afterHit = CustomKeywords.'database.methods.executeQuery'(('SELECT * FROM tbl_trx_log WHERE username = "' + 
    GlobalVariable.reqUsername) + '" ORDER BY id DESC LIMIT 1')

trx_log_afterHit.next()

String trx_refnum = trx_log_afterHit.getString('reference_num')

String trx_type = trx_log_afterHit.getString('trx_type')

String trx_status = trx_log_afterHit.getString('trx_status')

String trx_object = trx_log_afterHit.getString('trx_object')

String trx_date = trx_log_afterHit.getString('trx_date')

String trx_ip = trx_log_afterHit.getString('ip_address_source')

String trx_agent = trx_log_afterHit.getString('agent')

WS.comment(((((((((((((('refnum = ' + trx_refnum) + ', trx type = ') + trx_type) + ', trx status = ') + trx_status) + ', trx object = ') + 
    trx_object) + ', trx date = ') + trx_date) + ', ip address = ') + trx_ip) + ' & ') + 'agent = ') + trx_agent)

WS.comment('#55 Verify if Trx Refnum value and Request Refnum is matched')

WS.verifyMatch(trx_refnum, GlobalVariable.reqRefnum, false)

WS.comment('#57 Verify if Trx Type value is InquiryPurchaseGopay')

WS.verifyMatch(trx_type, 'InquiryPurchaseGoPay', false)

WS.comment('#59 Verify if Trx Status value is Gagal')

WS.verifyMatch(trx_status, 'Gagal', false)

WS.comment('#61 Verify if Trx Object value is BRIMON - TE')

WS.verifyMatch(trx_object, 'BRIMON - TE', false)

CustomKeywords.'database.methods.closeDatabaseConnection'()
