<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Inquiry Wallet</name>
   <tag></tag>
   <elementGuidId>ad229741-f411-40d2-a840-5d6b13e672c4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;client\&quot; : \&quot;${client}\&quot;,\n    \&quot;request_refnum\&quot; : \&quot;${refnum}\&quot;,\n    \&quot;username\&quot; : \&quot;${username}\&quot;,\n    \&quot;purchase_number\&quot; : \&quot;${purchase_number}\&quot;,\n    \&quot;purchase_id\&quot; : \&quot;${purchase_id}\&quot;,\n    \&quot;additional_data\&quot; : \&quot;${add_data}\&quot;,\n    \&quot;timestamp\&quot; : \&quot;${timestamp}\&quot;,\n    \&quot;channel_id\&quot; : \&quot;${channel_id}\&quot;\n}&quot;,
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
   <restUrl>http://172.18.136.92:4017/api/v1/wallet/inquiry</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.reqClient</defaultValue>
      <description></description>
      <id>fcdf508f-2736-43f3-85b3-0ac5c30be9d5</id>
      <masked>false</masked>
      <name>client</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqRefnum</defaultValue>
      <description></description>
      <id>562759e7-a243-468e-8ced-38819528040e</id>
      <masked>false</masked>
      <name>refnum</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqUsername</defaultValue>
      <description></description>
      <id>ece9156a-2e32-443c-b726-4f24c3b88211</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqPurchase_number</defaultValue>
      <description></description>
      <id>fb63fe8f-8002-4e41-ada8-2457fa28c0e9</id>
      <masked>false</masked>
      <name>purchase_number</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqPurchase_id</defaultValue>
      <description></description>
      <id>e91bf998-bdf8-486d-add7-059ec891ffe2</id>
      <masked>false</masked>
      <name>purchase_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqAdd_data</defaultValue>
      <description></description>
      <id>b9546f1e-2dc5-4d24-a459-b1c31133b33e</id>
      <masked>false</masked>
      <name>add_data</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqTimestamp</defaultValue>
      <description></description>
      <id>359ae2d5-a2a8-4761-9384-f7a9529c40e4</id>
      <masked>false</masked>
      <name>timestamp</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.reqChannel_id</defaultValue>
      <description></description>
      <id>0f590381-daf4-4ad8-900d-5ddd4f8ceb6d</id>
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
