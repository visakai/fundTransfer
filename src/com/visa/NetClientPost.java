package com.visa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;


import com.vdp.Algorithm;

public class NetClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
	public String getResponse(String payloadfromjsp, String apiPathJsp, String urljsp) throws SignatureException, IOException {
		HttpsURLConnection conn= null;
		
			String payload = payloadfromjsp;
			
			String apiPathfromClient = apiPathJsp;
			ObjectMapper mapper1 = new ObjectMapper();
			Object json1 =  mapper1.readValue(payload, Object.class);
			//and then write it out with indentation:

			String indented1 = mapper1.defaultPrettyPrintingWriter().writeValueAsString(json1);
			
			System.out.println("Request payload sent out:");
			System.out.println(indented1);
			System.out.println("");		
		    String token = new Algorithm().generateXpaytoken(payload,apiPathfromClient);
			//System.out.println("x-pay-token: "+ token);
			
			URL url = new URL(urljsp);
			
			 conn = (HttpsURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
		//	conn.setRequestProperty("Accept", "application/cva.cce.vl+json");
			conn.setRequestProperty("Accept", "application/json");
		//	conn.setRequestProperty("Accept", "text/plain");
			conn.setRequestProperty("x-pay-token", token);
			System.out.println("new json");

			//String input = "{\"SystemsTraceAuditNumber\":350420,\"RetrievalReferenceNumber\":\"401010350420\",\"DateAndTimeLocalTransaction\":\"2021-10-26T21:32:52\",\"AcquiringBin\":409999,\"AcquirerCountryCode\":\"101\",\"SenderReference\":\"\",\"SenderAccountNumber\": \"4957030420210454\",\"SenderCountryCode\":\"USA\",\"TransactionCurrency\":\"840\",\"SenderName\":\"John Smith\",\"SenderAddress\":\"44 Market St.\",\"SenderCity\":\"San Francisco\",\"SenderStateCode\":\"CA\",\"RecipientCardPrimaryAccountNumber\":\"4957030005709912\",\"Amount\":\"200.00\",\"BusinessApplicationID\":\"AA\",\"MerchantCategoryCode\":6012,\"TransactionIdentifier\":234234322342343,\"SourceOfFunds\":\"03\",\"CardAcceptor\":{\"Name\":\"John Smith\",\"TerminalId\":\"13655392\",\"IdCode\":\"VMT200911026070\",\"Address\":{\"State\":\"CA\",\"County\":\"081\",\"Country\":\"USA\",\"ZipCode\":\"94105\" }},\"FeeProgramIndicator\":\"123\"}";

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();
			BufferedReader br=null;			
			InputStream is;
			if (conn.getResponseCode() >= 400) {
			    is = conn.getErrorStream();
			    
			    System.out.println("get response code"+conn.getResponseCode());
			} else {
			    is = conn.getInputStream();
			}
			
			
			 br = new BufferedReader(new InputStreamReader(
					is));
			
		
			String output;
			String op="";
	//		System.out.println("Response from Server ....");
			while ((output = br.readLine()) != null) {
				op += output;
				//System.out.println(output);

			}
	
			conn.disconnect();
			return op;

	}

}	

