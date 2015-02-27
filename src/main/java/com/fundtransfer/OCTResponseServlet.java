
package com.fundtransfer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.fundtransfer.config.ConfigValues;
import com.fundtransfer.util.XpayTokenGenerator;
import com.fundtransfer.util.FundTransferUtility;

/**
 * Servlet implementation class ActionServlet
 * This class makes the AccountFundingTransaction API call sends reponse to
 * client in JSON pretty print format
 */

public class OCTResponseServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	public OCTResponseServlet() {
	}

	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("OCTResponseServlet Start>>>");

		String payload = "";
		String senderPAN = null;
		String recipientPAN = null;
		String newpayload = "";
		String endpoint = "";
		String token = "";
		String res = "";
		// get apiKey
		String apiKey = null;
		HttpSession session = request.getSession();
		// get sharedSecret
		String sharedSecret = null;
		apiKey = (String) session.getAttribute("apiKey");

		if (apiKey == null) {
			apiKey = (String) new ConfigValues().getPropValues().get(
			        "apiKey");
		}
		sharedSecret = (String) session.getAttribute("sharedSecret");
		if (sharedSecret == null) {
			sharedSecret = (String) new ConfigValues()
			        .getPropValues().get("sharedSecret");
		}
		try {
			payload = (String) new ConfigValues().getPropValues()
			        .get("payloadOCT");
			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("Amount", request.getParameter("amount"));
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
			RestWebServiceClient client = new RestWebServiceClient();
			newpayload = jsonObject.toString();
			endpoint = (String) new ConfigValues().getPropValues()
			        .get("urlOCT") + "?apikey=" + apiKey;
			token = new XpayTokenGenerator().generateXpaytoken(
			        newpayload, (String) new ConfigValues()
			                .getPropValues().get("pathOCT"), apiKey,
			        sharedSecret);
			res = client.getResponse(newpayload, endpoint, token);
			if (res.startsWith("{")) {
				res = FundTransferUtility.convertToPrettyJsonstring(res);
			}
			JSONObject outputJson = new JSONObject();
			PrintWriter out = response.getWriter();
			outputJson.put("response", res);
			outputJson.put("token", token);
			response.setContentType("application/json");
			out.print(outputJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
	}

}
