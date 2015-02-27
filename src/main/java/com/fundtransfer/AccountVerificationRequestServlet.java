
package com.fundtransfer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fundtransfer.config.ConfigValues;
import com.fundtransfer.util.FundTransferUtility;

/**
 * Servlet implementation class AccountVerifactionRequestServlet
 * This class generates requestPayload in JSON format for account verification
 * API call.
 * The AccountVerification API performs Address Verification Service (AVS) and
 * Card Verification Value (CVV2) on an account number
 */

@WebServlet("/AccountVerificationRequestServlet")
public class AccountVerificationRequestServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountVerificationRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("AccountVerificationRequestServlet Start>>>");
		String payload = (String) new ConfigValues().getPropValues()
		        .get("payloadACNV");
		String jsonRequest = "";
		JSONObject jsonObject;

		try {
			jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber",
			        request.getParameter("accNo"));
			jsonRequest = FundTransferUtility
			        .convertToPrettyJsonstring(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		response.getWriter().write(jsonRequest);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {

	}

}
