package com.visa;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
 




import java.io.IOException;
import java.security.SignatureException;

import javax.servlet.ServletException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

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


	 try{
		 
	// String payload ="{\"SystemsTraceAuditNumber\":350420,\"RetrievalReferenceNumber\":\"401010350420\",\"DateAndTimeLocalTransaction\":\"2021-10-26T21:32:52\",\"AcquiringBin\":409999,\"AcquirerCountryCode\":\"101\",\"SenderReference\":\"\",\"SenderAccountNumber\": \"4957030420210454\",\"SenderCountryCode\":\"USA\",\"TransactionCurrency\":\"840\",\"SenderName\":\"John Smith\",\"SenderAddress\":\"44 Market St.\",\"SenderCity\":\"San Francisco\",\"SenderStateCode\":\"CA\",\"RecipientCardPrimaryAccountNumber\":\"4957030005709912\",\"Amount\":\"200.00\",\"BusinessApplicationID\":\"AA\",\"MerchantCategoryCode\":6012,\"TransactionIdentifier\":234234322342343,\"SourceOfFunds\":\"03\",\"CardAcceptor\":{\"Name\":\"John Smith\",\"TerminalId\":\"13655392\",\"IdCode\":\"VMT200911026070\",\"Address\":{\"State\":\"CA\",\"County\":\"081\",\"Country\":\"USA\",\"ZipCode\":\"94105\" }},\"FeeProgramIndicator\":\"123\"}";
		 String payload = (String)new ConfigValues().getPropValues().get("payloadOCT");
		 
		 JSONObject jsonObject = new JSONObject(payload);		 
	 jsonObject.put("Amount", request.getParameter("amount"));	
	 
	 HttpSession session = request.getSession();
		String senderPAN=(String)session.getAttribute("senderPAN");
		String recipientPAN=(String)session.getAttribute("recipientPAN");
		if(senderPAN != null){
			jsonObject.put("SenderAccountNumber",senderPAN);
		}
		if(recipientPAN != null){
			jsonObject.put("RecipientCardPrimaryAccountNumber",recipientPAN);
		}
		
	 
	 NetClientPost client = new NetClientPost();
	 String newpayload = jsonObject.toString();
	 //String url="https://qa.api.visa.com/pm/ft/OriginalCreditTransactions?apikey=YU61R615DKXQP195HVKY21qjHi4NqQivhwWurF7rOHJJQUl-0";
	 String url = (String)new ConfigValues().getPropValues().get("urlOCT") + "?apikey=" + (String)new ConfigValues().getPropValues().get("apiKey");
		
	 
	 String res = client.getResponse(newpayload,(String)new ConfigValues().getPropValues().get("pathOCT"),url);
		if(res.startsWith("{"))		
			
		{	res= VdpUtility.convertToPrettyJsonstring(res);
		
		
		}
		
		 response.getWriter().write(res); 	
	
	 
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
 


