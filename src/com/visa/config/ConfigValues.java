package com.visa.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigValues {

	
	public static void main(String[] args){
		ConfigValues cv = new ConfigValues();
		try {
			System.out.println(cv.getPropValues().get("apiKey"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public Map getPropValues() throws IOException {
		 
		Map result = new HashMap();
		Properties prop = new Properties();
		String propFileName = "config.properties";
 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
 
		
 
		// get the property value and print it out
		result.put("apiKey", prop.getProperty("apiKey"));
		result.put("sharedSecret", prop.getProperty("sharedSecret"));
		
		result.put("payloadACNV", prop.getProperty("payloadACNV"));
		result.put("payloadACNL", prop.getProperty("payloadACNL"));
		result.put("payloadAFT", prop.getProperty("payloadAFT"));
		result.put("payloadOCT", prop.getProperty("payloadOCT"));
		
		result.put("urlACNV", prop.getProperty("urlACNV"));
		result.put("urlACNL", prop.getProperty("urlACNL"));
		result.put("urlAFT", prop.getProperty("urlAFT"));
		result.put("urlOCT", prop.getProperty("urlOCT"));
		
		result.put("pathACNV", prop.getProperty("pathACNV"));
		result.put("pathACNL", prop.getProperty("pathACNL"));
		result.put("pathAFT", prop.getProperty("pathAFT"));
		result.put("pathOCT", prop.getProperty("pathOCT"));
		
		
		return result;
	}
	
	
}
