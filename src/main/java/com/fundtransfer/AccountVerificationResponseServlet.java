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
 * Servlet implementation class AccountVerificationResponseServlet This class
 * makes the AccountVerification API call sends reponse to client in JSON pretty
 * print format
 */
@WebServlet("/AccountVerificationResponseServlet")
public class AccountVerificationResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountVerificationResponseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AccountVerificationResponseServlet Start>>>");
		String payload = (String) new ConfigValues().getPropValues().get(
				"payloadACNV");
		String newpayload = "";
		String endpoint = "";
		String res = "";
		String pathACNV = "";
		String token = "";
		// get apiKey
		String apiKey = null;
		HttpSession session = request.getSession();
		// get sharedSecret
		String sharedSecret = null;
		apiKey = (String) session.getAttribute("apiKey");
		System.out.println("session apiKey:"+apiKey);
		if (apiKey == null) {
			apiKey = (String) new ConfigValues().getPropValues().get("apiKey");
		}
		sharedSecret = (String) session.getAttribute("sharedSecret");
		if (sharedSecret == null) {
			sharedSecret = (String) new ConfigValues().getPropValues().get(
					"sharedSecret");
		}
		try {
			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber",
					request.getParameter("accNo"));
			RestWebServiceClient client = new RestWebServiceClient();
			newpayload = jsonObject.toString();
			endpoint = (String) new ConfigValues().getPropValues().get(
					"urlACNV")
					+ "?apikey=" + apiKey;
			pathACNV = (String) new ConfigValues().getPropValues().get(
					"pathACNV");
			token = new XpayTokenGenerator().generateXpaytoken(newpayload,
					pathACNV, apiKey, sharedSecret);
			res = client.getResponse(newpayload, endpoint, token);

			if (res != null && res.contains("TransactionIdentifier")) {
				session.setAttribute("senderPAN", request.getParameter("accNo"));
			}
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
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
