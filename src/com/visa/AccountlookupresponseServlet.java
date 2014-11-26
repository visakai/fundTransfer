package com.visa;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SignatureException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;






import com.vdp.Algorithm;
import com.vdp.service.PaymentService;
import com.vdp.util.RequestUtil;
import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;
import com.visa.vdp.api.Environment;
import com.visa.vdp.api.cardvalidatiion.AccountLookupRequest;
import com.visa.vdp.api.cardvalidatiion.AccountLookupResponse;
import com.visa.vdp.api.cardvalidatiion.CardValidationClient;
import com.visa.vdp.api.exception.VisaApiException;
import com.visa.vdp.api.services.VisaService;

/**
 * Servlet implementation class AccountlookupresponseServlet
 */
@WebServlet("/AccountlookupresponseServlet")
public class AccountlookupresponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountlookupresponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String token="";
		String payload="";
		String newpayload="";
		String endpoint="";
		String res="";
		
		
		//get apiKey
				String apiKey = null;
						
				HttpSession session = request.getSession();
				
				apiKey = (String)session.getAttribute("apiKey");
				
				if(apiKey == null){
					apiKey = (String)new ConfigValues().getPropValues().get("apiKey");
				}
				
				//get sharedSecret
				String sharedSecret = null;
				
				HttpSession session1 = request.getSession();
				
				sharedSecret = (String)session1.getAttribute("sharedSecret");
				
				if(sharedSecret == null){
					sharedSecret = (String)new ConfigValues().getPropValues().get("sharedSecret");
				}
				
		
		
		try {
						
			payload = (String)new ConfigValues().getPropValues().get("payloadACNL");
			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber", request.getParameter("recipientCardNumber"));
		
			NetClientPost client = new NetClientPost();
		    newpayload = jsonObject.toString(); //pay load After user input			
			
			endpoint = (String)new ConfigValues().getPropValues().get("urlACNL") + "?apikey=" + apiKey;
			token = new Algorithm().generateXpaytoken(newpayload, (String)new ConfigValues().getPropValues().get("pathACNL"), apiKey, sharedSecret );
			
			res = client.getResponse(newpayload, endpoint,token);
					
			if(res!=null  && res.contains("CardProductTypeCode"))
			{
				HttpSession session11 = request.getSession();
				session11.setAttribute("recipientPAN", request.getParameter("recipientCardNumber"));
			}
			
			if(res.startsWith("{"))		//To check if response is JSON
			
			{	res= VdpUtility.convertToPrettyJsonstring(res); 
			
			
			}			
			
			JSONObject outputJson=new JSONObject();
			PrintWriter out = response.getWriter();
			outputJson.put("response",res);
			outputJson.put("token",token);
			outputJson.put("apiKey",apiKey);
			outputJson.put("sharedSecret",sharedSecret);
			response.setContentType("application/json");
			out.print(outputJson);
		
			
		}
		catch(IOException e)		
		{
		e.printStackTrace()	;		 
			
		}		
		catch(Exception e)		
		{
			
			e.printStackTrace()	;
			 
		}
		

	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
