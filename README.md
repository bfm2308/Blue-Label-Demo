# Blue-Label-Demo

This is my response to the app as requested in the assigment.

I wrote an Android Native implementation of the solution. I know it is not the prettiest code I have written to date, and given the chance i would probably refactor the architecture a bit. 

I used the following third party libraries to create the XML for the request: 
 com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.7.4
 com.fasterxml.jackson.core:jackson-core:2.7.4
 com.fasterxml.jackson.core:jackson-annotations:2.7.4
 com.fasterxml.jackson.core:jackson-databind:2.7.4
 org.codehaus.woodstox:woodstox-core-asl:4.4.1
 javax.xml.stream:stax-api:1.0-2
 
 The solution basically creates a socket connection to the server and port, send the request through and gets the response from the server.
 
 The android app does this and displays both the request and the response on the string.
 
 The response displayed is as follows: 
 
 <response>
   <SessionId />
   <EventType>Authentication</EventType>
   <event>
      <EventCode>1</EventCode>
   </event>
   <data>
      <ErrorCode>3</ErrorCode>
      <ErrorText>Invalid user</ErrorText>
      <AeonErrorCode>103</AeonErrorCode>
      <AeonErrorText>Invalid User</AeonErrorText>
   </data>
</response>

