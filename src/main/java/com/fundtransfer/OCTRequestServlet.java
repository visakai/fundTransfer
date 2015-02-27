
package com.fundtransfer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fundtransfer.config.ConfigValues;
import com.fundtransfer.util.FundTransferUtility;

/**
 * Servlet implementation class ActionServlet
 * This class generates requestPayload in JSON format for
 * AccountFundingTransactions API call.
 * The OriginalCreditTransaction resource credits (pushes) funds to a
 * recipient's Visa account
 */

public class OCTRequestServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	public OCTRequestServlet() {
	}

	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("OCTRequestServlet Start>>>");

		String payload = (String) new ConfigValues().getPropValues()
		        .get("payloadOCT");
		String senderPAN = null;
		String recipientPAN = null;
		JSONObject jsonObject;
		String jsonRequest = "";

		try {
			jsonObject = new JSONObject(payload);
			jsonObject.put("Amount", request.getParameter("amount"));
			HttpSession session = request.getSession();
			senderPAN = (String) session.getAttribute("senderPAN");
			recipientPAN = (String) session
			        .getAttribute("recipientPAN");
			if (senderPAN != null) {
				jsonObject.put("SenderAccountNumber", senderPAN);
			}
			if (recipientPAN != null) {
				jsonObject.put("RecipientCardPrimaryAccountNumber",
				        recipientPAN);
			}
			jsonRequest = FundTransferUtility
			        .convertToPrettyJsonstring(jsonObject.toString());
			response.getWriter().write(jsonRequest);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
	}

}
