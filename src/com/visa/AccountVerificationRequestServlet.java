package com.visa;

import java.io.IOException;
import java.security.SignatureException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.vdp.Algorithm;
import com.vdp.util.RequestUtil;
import com.vdp.util.VdpUtility;
import com.visa.config.ConfigValues;

/**
 * Servlet implementation class AccountVerifactionRequestServlet
 */

@WebServlet("/AccountVerificationRequestServlet")
public class AccountVerificationRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountVerificationRequestServlet() {
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
		String jsonRequest="";
	
		try {

			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber", request.getParameter("accNo"));		   
			jsonRequest= VdpUtility.convertToPrettyJsonstring(jsonObject.toString());    
	       
		} catch (JSONException e) {
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
