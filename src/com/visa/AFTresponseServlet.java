package com.visa;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
import com.visa.vdp.api.cardvalidatiion.AccountLookupResponse;
import com.visa.vdp.api.common.Address;
import com.visa.vdp.api.common.CardAcceptor;
import com.visa.vdp.api.common.MagneticStripeData;
import com.visa.vdp.api.common.PinData;
import com.visa.vdp.api.common.PointOfServiceCapability;
import com.visa.vdp.api.common.PointOfServiceData;
import com.visa.vdp.api.common.SecurityRelatedControlInfo;
import com.visa.vdp.api.exception.VisaApiException;
import com.visa.vdp.api.payment.AccountFundingTransactionsRequest;
import com.visa.vdp.api.payment.AccountFundingTransactionsResponse;
import com.visa.vdp.api.payment.FundTransferClient;


/**
 * Servlet implementation class AFTresponseServlet
 */
@WebServlet("/AFTresponseServlet")
public class AFTresponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AFTresponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		
		String payload= (String)new ConfigValues().getPropValues().get("payloadAFT");
	    JSONObject jsonObject;
	    String senderPAN=null;
	    String res="";
	    String endpoint="";
	    String token="";
	    String newpayload="";
	    
	    
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
	  		
	    
	    
	    
		try
			
		{
		
			 jsonObject = new JSONObject(payload);		 
			 jsonObject.put("Amount", request.getParameter("amount"));
			 HttpSession session11 = request.getSession();
			 senderPAN=(String)session11.getAttribute("senderPAN");			
			 if(senderPAN != null){
				jsonObject.put("SenderPrimaryAccountNumber",senderPAN);
			}
			 NetClientPost client = new NetClientPost();
			 newpayload = jsonObject.toString();
			 endpoint = (String)new ConfigValues().getPropValues().get("urlAFT") + "?apikey=" + apiKey;
			 token = new Algorithm().generateXpaytoken(newpayload, (String)new ConfigValues().getPropValues().get("pathAFT"), apiKey, sharedSecret);
			 res = client.getResponse(newpayload, endpoint,token);
					 
			 
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
			 catch (Exception e)
			 {
				e.printStackTrace() ;
				 
			 }
		 }
		
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	

	
	}

}
