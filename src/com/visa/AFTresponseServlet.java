package com.visa;

import java.io.IOException;
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
			
		 try{
			 
			 //String payload=	"{\"SystemsTraceAuditNumber\": 300259,  \"RetrievalReferenceNumber\": \"407509300259\",  \"DateAndTimeLocalTransaction\": \"2021-10-26T21:32:52\",  \"AcquiringBin\": 409999,  \"AcquirerCountryCode\": \"101\",  \"SenderPrimaryAccountNumber\": \"4005520000011126\",  \"SenderCardExpiryDate\": \"2013-03\",  \"SenderCurrencyCode\": \"USD\",  \"Amount\": \"112.00\",  \"Surcharge\": \"2.00\",  \"Cavv\": \"0000010926000071934977253000000000000000\",  \"ForeignExchangeFeeTransaction\": \"10.00\",  \"BusinessApplicationID\": \"AA\",  \"MerchantCategoryCode\": 6012,  \"CardAcceptor\": {    \"Name\": \"Acceptor 1\",    \"TerminalId\": \"365539\",    \"IdCode\": \"VMT200911026070\",    \"Address\": {      \"State\": \"CA\",      \"County\": \"081\",      \"Country\": \"USA\",      \"ZipCode\": \"94404\"    }  },  \"MagneticStripeData\": {    \"track1Data\": \"1010101010101010101010101010\"  },  \"PointOfServiceData\": {    \"PanEntryMode\": \"90\",    \"PosConditionCode\": \"0\",    \"MotoECIIndicator\": \"0\"  },  \"PointOfServiceCapability\": {    \"PosTerminalType\": \"4\",    \"PosTerminalEntryCapability\": \"2\"},  \"FeeProgramIndicator\": \"123\"}";
			 String payload= (String)new ConfigValues().getPropValues().get("payloadAFT");
			 JSONObject jsonObject = new JSONObject(payload);		 
			 jsonObject.put("Amount", request.getParameter("amount"));	 
			 
			 HttpSession session = request.getSession();
				String senderPAN=(String)session.getAttribute("senderPAN");
				
				if(senderPAN != null){
					jsonObject.put("SenderPrimaryAccountNumber",senderPAN);
				}
				
			 NetClientPost client = new NetClientPost();
			 String newpayload = jsonObject.toString();
			 //String url="https://qa.api.visa.com/pm/ft/AccountFundingTransactions?apikey=YU61R615DKXQP195HVKY21qjHi4NqQivhwWurF7rOHJJQUl-0";
			 String url = (String)new ConfigValues().getPropValues().get("urlAFT") + "?apikey=" + (String)new ConfigValues().getPropValues().get("apiKey");
				
			 
			 String res = client.getResponse(newpayload,(String)new ConfigValues().getPropValues().get("pathAFT"),url);
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
		
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	

	
	}

}
