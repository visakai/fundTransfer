package com.vdp.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class VdpUtility {

	
	public static String convertToPrettyJsonstring(Object request)
	{
		String payload="";

		ObjectMapper mapper = new ObjectMapper();
		try {
			payload=VdpUtility.toJSON( request);
			Object json =  mapper.readValue(payload, Object.class);
			payload = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return payload;
	
	
}
	
	
	
	 public static  String toJSON(Object request) throws JsonGenerationException, JsonMappingException, IOException{
			
		 ObjectMapper mapper = new ObjectMapper();
		 mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
	                .withFieldVisibility(Visibility.ANY)
	                .withGetterVisibility(Visibility.NONE)
	                .withSetterVisibility(Visibility.NONE)
	                .withCreatorVisibility(Visibility.NONE));	
		 mapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		 
		 String body =  mapper.writeValueAsString(request);
		 return body;
	}
	 
	 
	 public static String convertToPrettyJsonstring(String payload)
		{
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				
				Object json =  mapper.readValue(payload, Object.class);
				payload = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
				
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return payload;
		
		
	}	
	
}
