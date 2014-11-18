package com.visa;

import java.io.IOException;
import java.security.SignatureException;

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
import com.vdp.util.RequestUtil;
import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;
import com.visa.vdp.api.exception.VisaApiException;

/**
 * Servlet implementation class AFTrequestServlet
 */
@WebServlet("/AFTrequestServlet")
public class AFTrequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AFTrequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	//String payload=	"{\"SystemsTraceAuditNumber\": 300259,  \"RetrievalReferenceNumber\": \"407509300259\",  \"DateAndTimeLocalTransaction\": \"2021-10-26T21:32:52\",  \"AcquiringBin\": 409999,  \"AcquirerCountryCode\": \"101\",  \"SenderPrimaryAccountNumber\": \"4005520000011126\",  \"SenderCardExpiryDate\": \"2013-03\",  \"SenderCurrencyCode\": \"USD\",  \"Amount\": \"112.00\",  \"Surcharge\": \"2.00\",  \"Cavv\": \"0000010926000071934977253000000000000000\",  \"ForeignExchangeFeeTransaction\": \"10.00\",  \"BusinessApplicationID\": \"AA\",  \"MerchantCategoryCode\": 6012,  \"CardAcceptor\": {    \"Name\": \"Acceptor 1\",    \"TerminalId\": \"365539\",    \"IdCode\": \"VMT200911026070\",    \"Address\": {      \"State\": \"CA\",      \"County\": \"081\",      \"Country\": \"USA\",      \"ZipCode\": \"94404\"    }  },  \"MagneticStripeData\": {    \"track1Data\": \"1010101010101010101010101010\"  },  \"PointOfServiceData\": {    \"PanEntryMode\": \"90\",    \"PosConditionCode\": \"0\",    \"MotoECIIndicator\": \"0\"  },  \"PointOfServiceCapability\": {    \"PosTerminalType\": \"4\",    \"PosTerminalEntryCapability\": \"2\"},  \"FeeProgramIndicator\": \"123\"}";
		String payload= (String)new ConfigValues().getPropValues().get("payloadAFT");
	 JSONObject jsonObject;
		try {
			 jsonObject = new JSONObject(payload);		
			 jsonObject.put("Amount", request.getParameter("amount"));
			 
			 HttpSession session = request.getSession();
				String senderPAN=(String)session.getAttribute("senderPAN");
				
				if(senderPAN != null){
					jsonObject.put("SenderPrimaryAccountNumber",senderPAN);
				}
				
			 
			  String jsonRequest= VdpUtility.convertToPrettyJsonstring(jsonObject.toString());		  
			  response.getWriter().write(jsonRequest);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
	  }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		String jsonRequest= VdpUtility.convertToPrettyJsonstring(RequestUtil.createrequestforAFT(request));		
		String token="";
		try {
			 token = new Algorithm().generateXpaytoken(jsonRequest, (String)new ConfigValues().getPropValues().get("pathAFT"));
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().write(token);
	}
	
	}


