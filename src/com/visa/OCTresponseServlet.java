package com.visa;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
 






import java.io.IOException;
import java.io.PrintWriter;
import java.security.SignatureException;

import javax.servlet.ServletException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.vdp.Algorithm;
import com.vdp.service.PaymentService;
import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;
import com.visa.vdp.api.exception.VisaApiException;
 
/**
  * Servlet implementation class ActionServlet
  */
 
public class OCTresponseServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
    
     public OCTresponseServlet() {
         // TODO Auto-generated constructor stub
     }
 

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 
	 String payload="";
	 String senderPAN=null;
	 String recipientPAN=null;
	 String newpayload="";
	 String endpoint="";
	 String token="";
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
		
	 
	 
	 try{
		 
	
		 payload = (String)new ConfigValues().getPropValues().get("payloadOCT");
		 
		 JSONObject jsonObject = new JSONObject(payload);		 
	 jsonObject.put("Amount", request.getParameter("amount"));	
	 
	 HttpSession session11 = request.getSession();
	   senderPAN=(String)session11.getAttribute("senderPAN");
		 recipientPAN=(String)session11.getAttribute("recipientPAN");
		if(senderPAN != null){
			jsonObject.put("SenderAccountNumber",senderPAN);
		}
		if(recipientPAN != null){
			jsonObject.put("RecipientCardPrimaryAccountNumber",recipientPAN);
		}
		
	 
	 NetClientPost client = new NetClientPost();
	 newpayload = jsonObject.toString();	
	 endpoint = (String)new ConfigValues().getPropValues().get("urlOCT") + "?apikey=" + (String)new ConfigValues().getPropValues().get("apiKey");
	 token = new Algorithm().generateXpaytoken(newpayload, (String)new ConfigValues().getPropValues().get("pathOCT"), apiKey, sharedSecret);	
	 
	 res = client.getResponse(newpayload,endpoint, token);
		if(res.startsWith("{"))		
			
		{	res= VdpUtility.convertToPrettyJsonstring(res);
		
		
		}
		
		   JSONObject outputJson=new JSONObject();
			PrintWriter out = response.getWriter();
			outputJson.put("response",res);
			outputJson.put("token",token);
			response.setContentType("application/json");
			out.print(outputJson);
			
	
	 
  }
	 catch (Exception e)
	 {
		e.printStackTrace() ;
		 
	 }
 }
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // TODO Auto-generated method stub
   
 }
 
}
 


