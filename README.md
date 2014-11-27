fundTransfer
============
This sample web application allows customers to transfer money from a Credit/Debit card to a Visa Credit/Debit card by making Visa Direct API calls in the Sandbox environment.
You are welcome to download it from GitHub and run it locally on your computer. In order to do so, please refer to the following steps:
<1>. Download the project. 
Go to (https://github.com/visakai/fundTransfer) and click "Download ZIP" button on the lower right corner of the page.
<2>. Unzip the downloaded file.
<3>. Import the project to your IDE.
In your IDE, for example Eclipse, Click "File" -> "Import" -> "General" -> "Existing Projects into Workspace". Browser to the unzipped folder and choose "visaFT" as the project to import.
<4>. Run the project.
Right click on the project, and then choose "Run As"-> "Run on Server". 
If you already have your server configured in Eclipse, just select "Choose an existing server" and choose your server and click "Finish".
If you don't have a server set up yet, select "Manually define a new server". Choose your server (for example, Tomcat v8.0 server) and click "Next". Click "Browser" and navigate to your server installation directory (for example, C:\Program Files (x86)\apache-tomcat-8\apache-tomcat-8.0.14). Then click "Finish".
After the server started up. You should be able to see the login page of the project in the browser at (http://localhost:8080/visaFT/). Log in using "visaguest" as username and "possibilities" as password (without the double quotes).
In case of "java.net.UnknownHostException", please toggle your internet proxy setting.
<5>. Configration file. 
You can replace the default apiKey, sharedSecret values with your own developer credentials in the "config.properties" file, which locates in the resources folder. To get your own developer credentials, please sign up at (https://vdp.visa.com)
One can also easily change or reset those two values at runtime in the application. Just click "Update Credentials" at the upper right corner on any page of the application.

<6>. Certificate issue.
Certificate jks file is already provided in the project. Perform this procedure only if the following exception message appeared: javax.net.ssl.SSLException: untrusted server cert chain
 (a).Go to the (https://vdp.api.visa.com/) and download the certificate file.
 (b).Type the following (without the line breaks):
   keytool -import -alias entrust_ssl_ca -keystore <JAVA_HOME>/jre/lib/security/cacerts -file entrust_ssl_ca.cer
  (<JAVA_HOME> is the path to your Java installation. keytool is a utility included in the Java SDK.)
 (c).Enter the keystore password when prompted for it. The default password is usually "changeit".

