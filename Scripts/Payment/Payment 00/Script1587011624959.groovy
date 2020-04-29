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

GlobalVariable.reqSrcAccount = '020601000064301'

GlobalVariable.reqPurchaseNumber = '085264274455'

GlobalVariable.reqPurchaseAmount = '15000'

GlobalVariable.reqPurchaseId = '15'

GlobalVariable.reqAdditionalData = '301341'

GlobalVariable.reqResponseData = '{"cust_no": "085264274455", "bill_amount": "", "bill_name": "", "bill_reference": "", "bill_info1": "", "bill_info2": "", "bill_info3": "", "bill_info4": "", "corp_code": "12", "corp_name": "", "corp_fee": "", "cust_fee": "", "credit_account": "", "curr_code": "", "flag_open": "", "fee": null, "cust_name": "Bakti Pratama", "max_balance": "", "balance": "", "transaction_date": "23/03/2020 02:38:10", "request_id": "NBMB123456789624", "comp_code": "301341"}' 

GlobalVariable.reqTimestamp = unixTime

GlobalVariable.reqChannel_id = 'NBMB'

response = WS.sendRequest(findTestObject('Payment/Payment Wallet', [('client') : GlobalVariable.reqClient, ('refnum') : GlobalVariable.reqRefnum
            , ('username') : GlobalVariable.reqUsername, ('source_account') : GlobalVariable.reqSrcAccount, ('purchase_number') : GlobalVariable.reqPurchaseNumber
            , ('purchase_amount') : GlobalVariable.reqPurchaseAmount, ('purchase_id') : GlobalVariable.reqPurchaseId, ('add_data') : GlobalVariable.reqAdditionalData
            , ('inquiry_response_data') : GlobalVariable.reqResponseData, ('timestamp') : GlobalVariable.reqTimestamp, ('channel_id') : GlobalVariable.reqChannel_id]))

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

WS.comment(response_refnum)

WS.comment('#27 Verify Verify if Response Code is not null')

WS.verifyNotMatch(response_code, null, false)

WS.comment('#29 Verify Verify if Response Id is not null')

WS.verifyNotMatch(response_id, null, false)

WS.comment('#31 Verify Verify if Response Refnum is not null')

WS.verifyNotMatch(response_refnum, null, false)

WS.comment('#33 Verify Verify if Response Desc is not null')

WS.verifyNotMatch(response_desc, null, false)

WS.comment('#35 Verify Verify if Response Data is not null')

WS.verifyNotMatch(response_data, null, false)

WS.comment('#37 Verify Verify if Response Code Length is 2')

WS.verifyMatch(code_length, '2', false)

WS.comment('#39 Verify Verify if Response Refnum Length is 12')

WS.verifyMatch(refnum_length, '12', false)

WS.comment('#41 Verify Verify if Response Code is 00')

WS.verifyMatch(response_code, '00', false)

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

WS.comment('#53 Verify if Trx Refnum value and Request Refnum is matched')

WS.verifyMatch(trx_refnum, GlobalVariable.reqRefnum, false)

WS.comment('#55 Verify if Trx Type value is PurchaseGoPay')

WS.verifyMatch(trx_type, 'PurchaseGoPay', false)

WS.comment('#57 Verify if Trx Status value is Sukses')

WS.verifyMatch(trx_status, 'Sukses', false)

WS.comment('#59 Verify if Trx Object value is BRIMON - 00')

WS.verifyMatch(trx_object, 'BRIMON - 00', false)

CustomKeywords.'database.methods.closeDatabaseConnection'()

