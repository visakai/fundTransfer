package com.visa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.vdp.Algorithm;
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
		
	
		String payload = (String)new ConfigValues().getPropValues().get("payloadACNV");
		String newpayload="";
		String endpoint="";
		String res="";
		String pathACNV="";
		String token="";
		
		
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
		
		System.out.println("apiKey: "+apiKey+"  sharedSecret: "+sharedSecret);
		try {
			
			JSONObject jsonObject = new JSONObject(payload);			
			jsonObject.put("PrimaryAccountNumber", request.getParameter("accNo"));	
		
			NetClientPost client = new NetClientPost();
		    newpayload = jsonObject.toString();
		    endpoint = (String)new ConfigValues().getPropValues().get("urlACNV") + "?apikey=" + (String)new ConfigValues().getPropValues().get("apiKey");
		    pathACNV = (String)new ConfigValues().getPropValues().get("pathACNV");
		    token = new Algorithm().generateXpaytoken(newpayload, pathACNV, apiKey, sharedSecret);
		    res = client.getResponse(newpayload,
					endpoint,token);
			
		    
		    if(res!=null && res.contains("TransactionIdentifier"))
			{
				HttpSession session11 = request.getSession();
				session11.setAttribute("senderPAN", request.getParameter("accNo"));
			}
			
			if(res.startsWith("{"))		
				
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
			e.printStackTrace();
		}		
		catch(Exception e)		
		{
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
