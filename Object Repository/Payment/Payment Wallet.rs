<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Payment Wallet</name>
   <tag></tag>
   <elementGuidId>d7f8848f-b17c-4149-b730-9d2ea0f3dc45</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;client\&quot;: \&quot;${client}\&quot;,\n    \&quot;request_refnum\&quot;: \&quot;${refnum}\&quot;,\n    \&quot;username\&quot;: \&quot;${username}\&quot;,\n    \&quot;source_account\&quot;: \&quot;${source_account}\&quot;,\n    \&quot;purchase_number\&quot;: \&quot;${purchase_number}\&quot;,\n    \&quot;purchase_amount\&quot;: \&quot;${purchase_amount}\&quot;,\n    \&quot;purchase_id\&quot;: \&quot;${purchase_id}\&quot;,\n    \&quot;additional_data\&quot;: \&quot;${add_data}\&quot;,\n    \&quot;inquiry_response_data\&quot;:${inquiry_response_data},\n    \&quot;timestamp\&quot;: \&quot;${timestamp}\&quot;,\n    \&quot;channel_id\&quot;: \&quot;${channel_id}\&quot;\n}&quot;,
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
   <variables>
      <defaultValue>GlobalVariable.reqClient</defaultValue>
      <description></description>
      <id>89bbabe1-779b-4cfe-802f-da6bb10f7aad</id>
      <masked>false</masked>
      <name>client</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqRefnum</defaultValue>
      <description></description>
      <id>127c6018-9d17-4dcd-8a39-8615385aa00d</id>
      <masked>false</masked>
      <name>refnum</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqUsername</defaultValue>
      <description></description>
      <id>8684296e-e365-41df-99e4-7b2f3016016c</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqSrcAccount</defaultValue>
      <description></description>
      <id>3f3424f4-9177-40c2-91e1-b1fea9a455d2</id>
      <masked>false</masked>
      <name>source_account</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqPurchaseNumber</defaultValue>
      <description></description>
      <id>a03fa27d-4411-42b4-a0cc-601fb0af1077</id>
      <masked>false</masked>
      <name>purchase_number</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqPurchaseAmount</defaultValue>
      <description></description>
      <id>206968ec-7b98-496d-9776-3c3d62263d99</id>
      <masked>false</masked>
      <name>purchase_amount</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqPurchaseId</defaultValue>
      <description></description>
      <id>27b500a8-907b-459b-aba9-0b832ad8607e</id>
      <masked>false</masked>
      <name>purchase_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqAdditionalData</defaultValue>
      <description></description>
      <id>c8d785e5-6d68-418c-a787-f8221d24d8cc</id>
      <masked>false</masked>
      <name>add_data</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqResponseData</defaultValue>
      <description></description>
      <id>54a848a8-4e43-4119-863b-d7e965f17ef5</id>
      <masked>false</masked>
      <name>inquiry_response_data</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqTimestamp</defaultValue>
      <description></description>
      <id>dc57dcf1-3714-474f-beaf-3ca6b8813c0e</id>
      <masked>false</masked>
      <name>timestamp</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqChannel_id</defaultValue>
      <description></description>
      <id>b0ad5f26-8adb-45e6-b639-1ee3d38540f5</id>
      <masked>false</masked>
      <name>channel_id</name>
   </variables>
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
