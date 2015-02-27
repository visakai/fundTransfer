
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
 * Servlet implementation class AccountlookupresponseServlet
 * This class makes the AccountLookup API call sends reponse to client in JSON
 * pretty printformat
 */
@WebServlet("/AccountlookupresponseServlet")
public class AccountLookupResponseServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountLookupResponseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("AccountLookupResponseServlet Start>>>");

		String token = "";
		String payload = "";
		String newpayload = "";
		String endpoint = "";
		String res = "";
		// get apiKey
		String apiKey = null;
		HttpSession session = request.getSession();
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
			        .get("payloadACNL");
			JSONObject jsonObject = new JSONObject(payload);
			jsonObject.put("PrimaryAccountNumber",
			        request.getParameter("recipientCardNumber"));

			RestWebServiceClient client = new RestWebServiceClient();
			newpayload = jsonObject.toString(); // pay load After user input
			endpoint = (String) new ConfigValues().getPropValues()
			        .get("urlACNL") + "?apikey=" + apiKey;
			token = new XpayTokenGenerator().generateXpaytoken(
			        newpayload, (String) new ConfigValues()
			                .getPropValues().get("pathACNL"), apiKey,
			        sharedSecret);
			res = client.getResponse(newpayload, endpoint, token);
			if (res != null && res.contains("CardProductTypeCode")) {				
				session.setAttribute("recipientPAN",
				        request.getParameter("recipientCardNumber"));
			}
			if (res.startsWith("{"))	// To check if response is JSON
			{
				res = FundTransferUtility
				        .convertToPrettyJsonstring(res);
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
	        HttpServletResponse response) throws ServletException,
	        IOException {
	}

}
