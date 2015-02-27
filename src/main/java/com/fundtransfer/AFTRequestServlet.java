
package com.fundtransfer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fundtransfer.config.ConfigValues;
import com.fundtransfer.util.FundTransferUtility;

/**
 * Servlet implementation class AFTrequestServlet
 * This class generates requestPayload in JSON format for
 * AccountFundingTransactions API call.
 * The AccountFundingTransaction method pulls funds from a sender's account, in
 * preparation for pushing funds to a recipient's account.
 */
@WebServlet("/AFTrequestServlet")
public class AFTRequestServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AFTRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("AFTRequestServlet Start>>>");

		String payload = (String) new ConfigValues().getPropValues()
		        .get("payloadAFT");
		JSONObject jsonObject;
		String senderPAN = null;
		String jsonRequest = "";
		HttpSession session;

		try {
			jsonObject = new JSONObject(payload);
			jsonObject.put("Amount", request.getParameter("amount"));
			session = request.getSession();
			senderPAN = (String) session.getAttribute("senderPAN");
			if (senderPAN != null) {
				jsonObject.put("SenderPrimaryAccountNumber",
				        senderPAN);
			}
			jsonRequest = FundTransferUtility
			        .convertToPrettyJsonstring(jsonObject.toString());
			response.getWriter().write(jsonRequest);
		} catch (JSONException e) {
			e.printStackTrace();
		}

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
