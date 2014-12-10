# Domestic Funds Transfer Demo App  

***
<br/>
This funds transfer web application serves as a demo app in order to help developers better understand how to use Visa Direct web services API. This web app allows customers to transfer money from a credit/debit card to a Visa credit/debit card by making API calls to Visa Direct sandbox environment behind the scene.


##Requirements
Java 1.6 and later.


##Download and Installation

Please follow these steps to download and run it on your local computer. This instruction assumes that you use Eclipse as your IDE and already have Maven installed.

#####(1). Download the project.   
Go to https://github.com/visakai/fundTransfer and click <button>**_Download ZIP_**</button> button on the lower right corner of the page.
#####(2). Unzip the downloaded file.  
Extract all files from the .zip file to a destination folder on your computer.
#####(3). Import the project to your IDE.  
In Eclipse, Click **_File_** -> **_Import_** -> **_Maven_** -> **_Existing Maven Projects_**. Browse to the unzipped folder and choose the project to import.
#####(4). Run the project.
Right click on the project, and then choose **_Run As_** -> **_Run Configurations..._**, then double-click **_Maven Build_**. For **_Base directory_**, click on **_Browse Workspace..._** button, navigate and select the workspace project. For **_Goals_**, put `jetty:run`. Then click on **_Run_** button. This should start jetty server.    

Once the server has started up, you should be able to see the login page of the project in a browser at <a>http://localhost:8080/fund-transfer/</a> (assuming that 8080 is your local server's port number). Enter the username and password you obtained from Visa Developer Platform team to log in.
If you encounter a `java.net.UnknownHostException`, please disable your internet proxy and retry or else to bypass the proxy, change the proxy credentials in config.properties under *resources* folder of the app and change hostname, hostport, proxyusername and proxypassword and uncomment the code related to proxy setup in RestWebServiceClient.java file under com.fundtransfer package.



##Testing
#####(1). Obtain developer credentials and test data.
In order to get your own test data and developer credentials, please sign up at https://vdp.visa.com (You need credentials from Visa Developer Platform team to be able to access it). After registration, you are expected to create an app. Be sure to select **_PAYMENT METHODS_**, **_CARD VALIDATION/ATTRIBUTES_** and **_DATA AND ANALYTICS_** APIs while creating your app. You can then find your _**API KEY**_, **_Share Secret_** and test data in your console.

#####(2). Test your credentials and data.   
The UI and workflow of this app are very intuitive. One can change the amount of money, update sender and recipient account information. To see the API calls behind the scenes, just select the **_Under the hood_**. You can replace the default *apiKey* and *sharedSecret* values with your own developer credentials in the *config.properties* file in *resources* folder. One can also easily change or reset those two values at runtime in the application. Just click <button>**_Update Credentials_**</button> at the upper right corner on any page of the application.   
When you test your own data, please keep in mind that for *OCT (OriginalCredi tTransactions)* API call, only certain sender+recipient account **pairs** are considered valid in sandbox environment. So it's not uncommon that certain card numbers can pass individual *ACNV (AccountVerification)* or *ACNL (AccountLookup)* call but fail on *OCT (OriginalCreditTransactions)* calls when combined.  This funds transfer app currently works in a sandbox environment and serves only as a demo app, which means it is not connecting with the real financial payment system and therefore no actual money will be added to/charged from the cards you test.


## Others
#####  Certificate issue.  

Certificate shouldn't be an issue for this demo app, because certificate jks file is already provided in the project in *resources* folder. Perform this procedure only if the following exception message appeared: `javax.net.ssl.SSLException: untrusted server cert chain`.  
> (a). Go to https://vdp.api.visa.com/ and download the certificate file.  
 (b). Type the following (without the line breaks) in a command prompt:
 ```sh
keytool -import -alias entrust_ssl_ca -keystore <JAVA_HOME>/jre/lib/security/cacerts -file entrust_ssl_ca.cer
```
(&lt;JAVA_HOME&gt; is the path to your Java installation. keytool is a utility included in the Java SDK.)  
> (c). Enter the keystore password when prompted for it. The default password is usually **changeit**.

#####  Change Application Credentials

In this app HTTP Basic Authentication is used. One can configure login credentials in config.properties under *resources* folder of the app by changing    username and password.

