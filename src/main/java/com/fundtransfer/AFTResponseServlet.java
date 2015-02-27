
package com.fundtransfer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.fundtransfer.config.ConfigValues;
import com.fundtransfer.util.XpayTokenGenerator;
import com.fundtransfer.util.FundTransferUtility;

/**
 * Servlet implementation class AFTresponseServlet
 * This class makes the AccountFundingTransaction API call sends reponse to
 * client in JSON pretty print format
 */
@WebServlet("/AFTresponseServlet")
public class AFTResponseServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AFTResponseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("AFTResponseServlet Start>>>");

		String payload = (String) new ConfigValues().getPropValues()
		        .get("payloadAFT");
		JSONObject jsonObject;
		String senderPAN = null;
		String res = "";
		String endpoint = "";
		String token = "";
		String newpayload = "";
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
			jsonObject = new JSONObject(payload);
			jsonObject.put("Amount", request.getParameter("amount"));
			senderPAN = (String) session.getAttribute("senderPAN");
			if (senderPAN != null) {
				jsonObject.put("SenderPrimaryAccountNumber",
				        senderPAN);
			}
			RestWebServiceClient client = new RestWebServiceClient();
			newpayload = jsonObject.toString();
			endpoint = (String) new ConfigValues().getPropValues()
			        .get("urlAFT") + "?apikey=" + apiKey;
			token = new XpayTokenGenerator().generateXpaytoken(
			        newpayload, (String) new ConfigValues()
			                .getPropValues().get("pathAFT"), apiKey,
			        sharedSecret);
			res = client.getResponse(newpayload, endpoint, token);
			if (res.startsWith("{")) {
				res = FundTransferUtility.convertToPrettyJsonstring(res);
			}
			JSONObject outputJson = new JSONObject();
			PrintWriter out = response.getWriter();
			outputJson.put("response", res);
			outputJson.put("token", token);
			outputJson.put("apiKey", apiKey);
			outputJson.put("sharedSecret", sharedSecret);
			response.setContentType("application/json");
			out.print(outputJson);
		} catch (Exception e) {
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
