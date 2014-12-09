
package com.fundtransfer.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This class generates Xpay token based on Apikey, shared secret and payload
 */
public class XpayTokenGenerator {
	public static String	sourceString;

	public static String sha256Digest(String data)
	        throws SignatureException {
		return getDigest("SHA-256", data, true);
	}

	private static String getDigest(String algorithm, String data,
	        boolean toLower) throws SignatureException {
		try {
			MessageDigest mac = MessageDigest.getInstance(algorithm);
			mac.update(data.getBytes("UTF-8"));
			return toLower ? new String(toHex(mac.digest()))
			        .toLowerCase() : new String(toHex(mac.digest()));
		} catch (Exception e) {
			throw new SignatureException(e);
		}
	}

	private static String toHex(byte[] bytes) {
		BigInteger bi = new BigInteger(1, bytes);
		return String.format("%0" + (bytes.length << 1) + "X", bi);
	}

	public static String timeStamp() {
		// formatting Date with time information
		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
		        "dd-MM-yy:HH:mm:SS");
		String date = DATE_FORMAT.format(today);
		long unix_timestamp = strDateToUnixTimestamp(date);
		String unixTs = String.valueOf(unix_timestamp);
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

	public String generateXpaytoken(String payloadfromclient,
	        String apiPathfromClient, String apiKeyfromClient,
	        String sharedSecretfromClient) throws SignatureException {
		String timestamp = timeStamp();
		String payload = payloadfromclient;
		String apiPath = apiPathfromClient;
		String apiKey = apiKeyfromClient;
		String sharedSecret = sharedSecretfromClient;
		String beforeHash = null;
		beforeHash = sharedSecret + timestamp + apiPath + "apikey="
		        + apiKey + payload;
		String hash = sha256Digest(beforeHash);
		String token = "x:" + timestamp + ":" + hash;
		return token;
	}
}
