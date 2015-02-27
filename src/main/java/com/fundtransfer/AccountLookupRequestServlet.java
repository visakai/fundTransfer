
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
 * Servlet implementation class AccountlookuprequestServlet
 * This class generates requestPayload in JSON format for The AccountLookup API
 * call.
 * The AccountLookup API is used to verify sender account details.
 * The AccountLookup API returns account data based on a users account number
 */
@WebServlet("/AccountlookuprequestServlet")
public class AccountLookupRequestServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountLookupRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("AccountLookupRequestServlet Start>>>");
		String recipientCardNumber = request
		        .getParameter("recipientCardNumber");
		String payload = (String) new ConfigValues().getPropValues()
		        .get("payloadACNL");
		String token = "";
		String jsonRequest = "";
		JSONObject jsonObject;

		try {
			jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber",
			        request.getParameter("recipientCardNumber"));
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
