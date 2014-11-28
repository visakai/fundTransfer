#<font color=blue> Domestic Funds Transfer Demo App </font> 
 <br/>
***
<br/>
This funds transfer web application serves as a demo app in order to help developers better understand how to use Visa Direct web services API. This web app allows customers to transfer money from a credit/debit card to a Visa credit/debit card by making API calls to Visa Direct sandbox environment behind the scene.

Please follow these steps to download and run it on your local computer:

####(1). Download the project.   
Go to https://github.com/visakai/fundTransfer and click <button>**_Download ZIP_**</button> button on the lower right corner of the page.

####(2). Unzip the downloaded file.

####(3). Import the project to your IDE.  
In your IDE, for example Eclipse, Click **_File_** -> **_Import_** -> **_General_** -> **_Existing Projects into Workspace_**. Browser to the unzipped folder and choose **_visaFT_** as the project to import.

####(4). Run the project.
Right click on the project, and then choose **_Run As_** -> **_Run on Server_**.   
If you already have your server configured in Eclipse, just select 
**_Choose an existing server_** and choose your server and click **_Finish_**.  
If you don't have a server set up yet, select **_Manually define a new server_**. Choose your server (_for example_, Tomcat v8.0 server) and click **_Next_**. Click **_Browser_** and navigate to your server installation directory (_for example_, <u>_C:\Program Files(x86)\apache-tomcat-8\apache-tomcat-8.0.14</u>). Then click on <i>**Finish**</i>.  
Once the server has started up, you should be able to see the login page of the project in a browser at <a>http://localhost:8080/visaFT/</a>.  Use *visaguest* as username and *possibilities* as password to log in.
If you encounter a `java.net.UnknownHostException`, please disable your internet proxy and retry.

####(5). Obtain developer credentials and test data.
In order to get your own test data and developer credentials, please sign up at https://vdp.visa.com. After registeration, you are expected to create an app. Be sure to select **_fund transfer_** module while creating your app. You can then find your _**API KEY**_, **_Share Secret_** and test data in your console.

####(6). Test your credentials and data.   
The UI and workflow of this app are very intuitive. One can change the amount of money, update sender and recipient account information. To see the API calls behind the scenes, just select the **_Under the hood_**. You can replace the default *apiKey* and *sharedSecret* values with your own developer credentials in the *config.properties* file, which locates in the 
*resources* folder. One can also easily change or reset those two values at runtime in the application. Just click <button>**_Update Credentials_**</button> at the upper right corner on any page of the application. When you test your own data, please keep in mind that for *OCT* API call, only certain sender+recipient account **pairs** are considered valid in sandbox environment. So it's not uncommon that certain card numbers can pass individual *ANCV* or *ANCL* call but fail on *OCT* calls when combined.  This funds transfer app currently works in a sandbox environment and serves only as a demo app, which means it is not connecting with the real financial payment system and therefore no actual money will be added to/charged from the cards you test.

####(7). Certificate issue.  
Certificate shouldn't be an issue for this demo app, because certificate jks file is already provided in the project in *resources* folder. Perform this procedure only if the following exception message appeared: `javax.net.ssl.SSLException: untrusted server cert chain`.  
> (a). Go to https://vdp.api.visa.com/ and download the certificate file.  
 (b). Type the following (without the line breaks) in a command prompt:
 ```sh
keytool -import -alias entrust_ssl_ca -keystore <JAVA_HOME>/jre/lib/security/cacerts -file entrust_ssl_ca.cer
```
(&lt;JAVA_HOME&gt; is the path to your Java installation. keytool is a utility included in the Java SDK.)  
> (c). Enter the keystore password when prompted for it. The default password is usually **changeit**.
