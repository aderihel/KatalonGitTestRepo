<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Payment Wallet Asli</name>
   <tag></tag>
   <elementGuidId>1c6d68d4-b9ca-4bd8-9015-acd936e5b484</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;client\&quot;: \&quot;BRIMON\&quot;,\n    \&quot;request_refnum\&quot;: \&quot;123456789020\&quot;,\n    \&quot;username\&quot;: \&quot;ratric0802\&quot;,\n    \&quot;source_account\&quot;: \&quot;001901001390306\&quot;,\n    \&quot;purchase_number\&quot;: \&quot;085264274455\&quot;,\n    \&quot;purchase_amount\&quot;: \&quot;1000\&quot;,\n    \&quot;purchase_id\&quot;: \&quot;15\&quot;,\n    \&quot;additional_data\&quot;: \&quot;301341\&quot;,\n    \&quot;inquiry_response_data\&quot;: {\n        \&quot;cust_no\&quot;: \&quot;085264274455\&quot;,\n        \&quot;bill_amount\&quot;: \&quot;\&quot;,\n        \&quot;bill_name\&quot;: \&quot;\&quot;,\n        \&quot;bill_reference\&quot;: \&quot;\&quot;,\n        \&quot;bill_info1\&quot;: \&quot;\&quot;,\n        \&quot;bill_info2\&quot;: \&quot;\&quot;,\n        \&quot;bill_info3\&quot;: \&quot;\&quot;,\n        \&quot;bill_info4\&quot;: \&quot;\&quot;,\n        \&quot;corp_code\&quot;: \&quot;12\&quot;,\n        \&quot;corp_name\&quot;: \&quot;\&quot;,\n        \&quot;corp_fee\&quot;: \&quot;\&quot;,\n        \&quot;cust_fee\&quot;: \&quot;\&quot;,\n        \&quot;credit_account\&quot;: \&quot;\&quot;,\n        \&quot;curr_code\&quot;: \&quot;\&quot;,\n        \&quot;flag_open\&quot;: \&quot;\&quot;,\n        \&quot;fee\&quot;: null,\n        \&quot;cust_name\&quot;: \&quot;Bakti Pratama\&quot;,\n        \&quot;max_balance\&quot;: \&quot;\&quot;,\n        \&quot;balance\&quot;: \&quot;\&quot;,\n        \&quot;transaction_date\&quot;: \&quot;23/03/2020 02:38:10\&quot;,\n        \&quot;request_id\&quot;: \&quot;NBMB123456789624\&quot;,\n        \&quot;comp_code\&quot;: \&quot;301341\&quot;\n    },\n    \&quot;timestamp\&quot;: \&quot;1234567890123\&quot;,\n    \&quot;channel_id\&quot;: \&quot;NBMB\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://172.18.136.92:4017/api/v1/wallet/payment</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
