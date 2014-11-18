package com.visa;

import java.io.IOException;
import java.security.SignatureException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.vdp.Algorithm;
import com.vdp.util.RequestUtil;
import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;

/**
 * Servlet implementation class AccountVerifactionRequestServlet
 */
@WebServlet("/AccountVerificationRequestServlet")
public class AccountVerificationRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountVerificationRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String payload = "{    \"SystemsTraceAuditNumber\": 701050,    \"RetrievalReferenceNumber\": \"405012701050\",    \"AcquiringBin\": 409999,    \"AcquirerCountryCode\": \"101\",    \"PrimaryAccountNumber\": \"4957030420210462\",    \"CardExpiryDate\": \"2015-10\",    \"CardCvv2Value\": \"022\",    \"Avs\": {        \"Street\": \"900 Metro Center Blv\",        \"PostalCode\": \"94404\"    },    \"CardAcceptor\": {        \"Name\": \"ABC\",        \"TerminalId\": \"123\",        \"IdCode\": \"45678\",        \"Address\": {            \"City\": \"San Francisco\",            \"State\": \"CA\",            \"County\": \"075\",            \"Country\": \"USA\",            \"ZipCode\": \"94404\"        }    }}";

		String payload = (String)new ConfigValues().getPropValues().get("payloadACNV");
		
		

		try {

			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber", request.getParameter("accNo"));
		/*	jsonObject
			.put("CardExpiryDate", request.getParameter("cardExpiryDate"));
	       
	         jsonObject.put("Name", request.getParameter("name"));*/	        
	     	 
		
	       
	        
	        String newpayload = jsonObject.toString();		   
			  
			  ObjectMapper mapper = new ObjectMapper();
			  Object json =  mapper.readValue(newpayload, Object.class);
				//and then write it out with indentation:

			 String indented = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
			   
			   response.setContentType("text/Json");  
			   response.setCharacterEncoding("UTF-8"); 
			   response.getWriter().write(indented); 
			   System.out.println("Request of AV" +indented);
			   
	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String token="";
		try {

			//String payload = "{    \"SystemsTraceAuditNumber\": 701050,    \"RetrievalReferenceNumber\": \"405012701050\",    \"AcquiringBin\": 409999,    \"AcquirerCountryCode\": \"101\",    \"PrimaryAccountNumber\": \"4957030420210462\",    \"CardExpiryDate\": \"2015-10\",    \"CardCvv2Value\": \"022\",    \"Avs\": {        \"Street\": \"900 Metro Center Blv\",        \"PostalCode\": \"94404\"    },    \"CardAcceptor\": {        \"Name\": \"ABC\",        \"TerminalId\": \"123\",        \"IdCode\": \"45678\",        \"Address\": {            \"City\": \"San Francisco\",            \"State\": \"CA\",            \"County\": \"075\",            \"Country\": \"USA\",            \"ZipCode\": \"94404\"        }    }}";
			String payload = (String)new ConfigValues().getPropValues().get("payloadACNV");
			
			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber", request.getParameter("accNo"));
				        
	        String newpayload = jsonObject.toString();
	        
	        String pathACNV = (String)new ConfigValues().getPropValues().get("pathACNV");
	      
			try {
				 token = new Algorithm().generateXpaytoken(newpayload, pathACNV);
			} catch (SignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
		
			   
	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		

		
		response.getWriter().write(token);
	}

}
