package com.visa;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SignatureException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;



import com.vdp.Algorithm;
import com.vdp.util.RequestUtil;
import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;
import com.visa.vdp.api.Environment;
import com.visa.vdp.api.cardvalidatiion.AccountLookupRequest;
import com.visa.vdp.api.cardvalidatiion.AccountLookupResponse;
import com.visa.vdp.api.cardvalidatiion.CardValidationClient;

/**
 * Servlet implementation class AccountlookuprequestServlet
 */
@WebServlet("/AccountlookuprequestServlet")
public class AccountlookuprequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountlookuprequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String recipientCardNumber = request.getParameter("recipientCardNumber");
		String payload = (String)new ConfigValues().getPropValues().get("payloadACNL");
		String token="";
		String jsonRequest="";
		JSONObject jsonObject;
		
		try {
			jsonObject = new JSONObject(payload);			
			jsonObject.put("PrimaryAccountNumber", request.getParameter("recipientCardNumber"));
			jsonRequest= VdpUtility.convertToPrettyJsonstring(jsonObject.toString());    
		
		}
	
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.getWriter().write(jsonRequest);
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
	
}
