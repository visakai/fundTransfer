
package com.fundtransfer;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SignatureException;

import javax.net.ssl.HttpsURLConnection;

/*
 * This class used to make API calls and get response from servlet
 */

public class RestWebServiceClient {

	public String getResponse(String payload, String endpoint,
	        String xpaytoken) throws SignatureException, IOException {
		HttpsURLConnection conn = null;
		OutputStream os;
		BufferedReader br = null;
		InputStream is;
		String output;
		String op = "";
		URL url = new URL(endpoint);

		System.setProperty("javax.net.ssl.trustStore", getClass()
		        .getClassLoader().getResource("sandbox.jks")
		        .getFile());
		System.setProperty("javax.net.ssl.trustStorePassword",
		        "changeit");
		// Enter host, username, password if you are using proxy
		/*
		 * System.setProperty("https.proxyHost", (String)new
		 * ConfigValues().getPropValues().get("hostname"));
		 * System.setProperty("https.proxyPort", (String)new
		 * ConfigValues().getPropValues().get("hostport"));
		 * System.setProperty("https.proxyUser",(String)new
		 * ConfigValues().getPropValues().get("proxyusername"));
		 * System.setProperty("https.proxyPassword", (String)new
		 * ConfigValues().getPropValues().get("proxypassword"));
		 */

		conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        if(url.toString().contains("cce")){
        conn.setRequestProperty("Accept", "application/vnd.visa.CardCheck.v1+json");}
        else if (url.toString().contains("cf")){
               conn.setRequestProperty("Accept", "application/vnd.visa.CardFeatures.v1+json");
        }
        else{
               conn.setRequestProperty("Accept", "application/vnd.visa.FundsTransfer.v1+json");
        }
		conn.setRequestProperty("x-pay-token", xpaytoken);
		os = conn.getOutputStream();
		os.write(payload.getBytes());
		os.flush();
		if (conn.getResponseCode() >= 400) {
			is = conn.getErrorStream();			
		} else {
			is = conn.getInputStream();
		}
		br = new BufferedReader(new InputStreamReader(is));
		while ((output = br.readLine()) != null) {
			op += output;
		}
		conn.disconnect();
		return op;
	}
}
