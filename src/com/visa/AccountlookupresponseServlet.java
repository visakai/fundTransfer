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
import org.json.JSONObject;





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
	

		
		try {
			//String payload =	"{\"SystemsTraceAuditNumber\":455690,\"RetrievalReferenceNumber\": \"405012455690\",\"AcquiringBin\": 409999,\"AcquirerCountryCode\": \"101\",\"PrimaryAccountNumber\":\"4895070000008881\"}";
			String payload = (String)new ConfigValues().getPropValues().get("payloadACNL");
			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber", request.getParameter("recipientCardNumber"));
		
			NetClientPost client = new NetClientPost();
			String newpayload = jsonObject.toString();
			
			//String url="https://qa.api.visa.com/cva/cf/AccountLookup?apikey=YU61R615DKXQP195HVKY21qjHi4NqQivhwWurF7rOHJJQUl-0";
			String url = (String)new ConfigValues().getPropValues().get("urlACNL") + "?apikey=" + (String)new ConfigValues().getPropValues().get("apiKey");
			
			String res = client.getResponse(newpayload, (String)new ConfigValues().getPropValues().get("pathACNL"),url);
			System.out.println("response" +res);
			
			if(res!=null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("recipientPAN", request.getParameter("recipientCardNumber"));
			}
			
			if(res.startsWith("{"))		
			
			{	res= VdpUtility.convertToPrettyJsonstring(res);
			
			
			}
			
			System.out.println(res);
			
			 response.getWriter().write(res); 	
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
