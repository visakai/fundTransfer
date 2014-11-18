package com.vdp;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import com.visa.config.ConfigValues;

public class Algorithm {
	public static String sourceString;
	public static String sha256Digest (String data) throws SignatureException {
		return getDigest("SHA-256", data, true);
	}

	private static String getDigest(String algorithm, String data, boolean toLower)
			throws SignatureException {
		try {
			MessageDigest mac = MessageDigest.getInstance(algorithm);
			mac.update(data.getBytes("UTF-8"));
			return toLower ? 
					new String(toHex(mac.digest())).toLowerCase() : new String(toHex(mac.digest()));
		} catch (Exception e) {
			throw new SignatureException(e);
		}
	}

	private static String toHex(byte[] bytes) {
		BigInteger bi = new BigInteger(1, bytes);
		return String.format("%0" + (bytes.length << 1) + "X", bi);
	}
	
	 public static String timeStamp() {
	             
//	           String UNIX_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";  
//	           Date now = new Date();  
//	           SimpleDateFormat formatter = new SimpleDateFormat(UNIX_DATE_FORMAT);  
//	           System.out.println(formatter.format(now));
	             
	             //formatting Date with time information
	        Date today = new Date();
	        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
	        String date = DATE_FORMAT.format(today);
	        //System.out.println("Today in dd-MM-yy:HH:mm:SS : " + date);
	             
	             
	        long unix_timestamp=strDateToUnixTimestamp(date);
	        String unixTs = String.valueOf(unix_timestamp);
	        //System.out.println("unix_timestamp:::::"+unixTs);
	        return unixTs;

	    }

	    private static long strDateToUnixTimestamp(String dt) {
	        DateFormat formatter;
	        Date date = null;
	        long unixtime;
	        formatter = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
	        try {
	            date = formatter.parse(dt);
	        } catch (ParseException ex) {

	            ex.printStackTrace();
	        }
	        
	       
	        unixtime = date.getTime() / 1000L;
	        return unixtime;
	    }

	
		 public static void main(String[] args){
			try {
				String payload = "{\"SystemsTraceAuditNumber\":350420,\"RetrievalReferenceNumber\":\"401010350420\",\"DateAndTimeLocalTransaction\":\"2021-10-26T21:32:52\",\"AcquiringBin\":409999,\"AcquirerCountryCode\":\"101\",\"SenderReference\":\"\",\"SenderAccountNumber\": \"4957030420210454\",\"SenderCountryCode\":\"USA\",\"TransactionCurrency\":\"840\",\"SenderName\":\"John Smith\",\"SenderAddress\":\"44 Market St.\",\"SenderCity\":\"San Francisco\",\"SenderStateCode\":\"CA\",\"RecipientCardPrimaryAccountNumber\":\"4957030005709912\",\"Amount\":\"200.00\",\"BusinessApplicationID\":\"AA\",\"MerchantCategoryCode\":6012,\"TransactionIdentifier\":234234322342343,\"SourceOfFunds\":\"03\",\"CardAcceptor\":{\"Name\":\"John Smith\",\"TerminalId\":\"13655392\",\"IdCode\":\"VMT200911026070\",\"Address\":{\"State\":\"CA\",\"County\":\"081\",\"Country\":\"USA\",\"ZipCode\":\"94105\" }},\"FeeProgramIndicator\":\"123\"}";
				
				System.out.println (new Algorithm().generateXpaytoken(payload, "ft/OriginalCreditTransactions"));
				// oct
			} catch (SignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 
	public String generateXpaytoken(String payloadfromclient, String apiPathfromClient) throws SignatureException{
	
		String timestamp = timeStamp();
		String payload = payloadfromclient;
		String apiPath = apiPathfromClient;
		String sharedSecret = null;
		try {
			 sharedSecret = (String)new ConfigValues().getPropValues().get("sharedSecret");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String beforeHash=null;
		try {
			beforeHash = sharedSecret
			+ timestamp
			//+ "ft/OriginalCreditTransactions" 
			+ apiPath
			+ "apikey=" + (String)new ConfigValues().getPropValues().get("apiKey")
			+ payload;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hash = sha256Digest(beforeHash);
		//String timestamp2= timeStamp();
		String token = "x:" + timestamp + ":" + hash;
		//System.out.println("The generated Xpay_Token is: " +token+ " \nThe length of the xpay token is: " +hash.length() );
		return token;
	}
}

