
package com.fundtransfer.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class FundTransferUtility {
	
	/*
	 * This method converts String Payload to prettyjson string
	 */
	public static String convertToPrettyJsonstring(String payload) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Object json = mapper.readValue(payload, Object.class);
			payload = mapper.defaultPrettyPrintingWriter()
			        .writeValueAsString(json);
		} catch (JsonParseException e) {
			e.printStackTrace();

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return payload;
	}
}
