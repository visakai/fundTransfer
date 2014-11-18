package com.visa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;

/**
 * Servlet implementation class AccountVerificationResponseServlet
 */
@WebServlet("/AccountVerificationResponseServlet")
public class AccountVerificationResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountVerificationResponseServlet() {
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
	
		
/*
			CreditCardValidator ccv = new CreditCardValidator();
			if (ccv.getCardID(request.getParameter("PAN")) == -1) {

				
			
				 response.getWriter().write("This card is invalid or unsupported!"); 
				  
				System.out.println("This card is invalid or unsupported!");
				return;

			} else {

				if (!ccv.validCC(request.getParameter("PAN"))) {
					response.getWriter().write("Invalid "+ ccv.getCardName(ccv.getCardID(request.getParameter("PAN")))+ " card.");
					
					return;
				} else {

					//response.getWriter().write("This is a valid "	+ ccv.getCardName(ccv.getCardID(request.getParameter("PAN")))+ " card.");
				}

			}

			if (!request.getParameter("PAN").startsWith("4")) {
				response.getWriter().write("We found that this is not a Visa card. You can still pay with this card, but currently we are unable to verify it.");
				return;
			}*/
		
			NetClientPost client = new NetClientPost();
			String newpayload = jsonObject.toString();
			//String url = "https://qa.api.visa.com/cva/cce/AccountVerification?apikey=YU61R615DKXQP195HVKY21qjHi4NqQivhwWurF7rOHJJQUl-0";
			String url = (String)new ConfigValues().getPropValues().get("urlACNV") + "?apikey=" + (String)new ConfigValues().getPropValues().get("apiKey");
			
			String res = client.getResponse(newpayload,
					(String)new ConfigValues().getPropValues().get("pathACNV"), url);
			if(res!=null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("senderPAN", request.getParameter("accNo"));
			}
			
			if(res.startsWith("{"))		
				
			{	res= VdpUtility.convertToPrettyJsonstring(res);
			
			
			}
			
			
				
				 response.getWriter().write(res); 	
			
			
		}
		catch(IOException e)		
		{
			 response.getWriter().write(e.getMessage()); 
		}		
		catch(Exception e)		
		{
			 response.getWriter().write(e.getMessage()); 
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
