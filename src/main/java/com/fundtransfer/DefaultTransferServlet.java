
package com.fundtransfer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fundtransfer.config.ConfigValues;

/**
 * Servlet implementation class DefaultTransferServlet
 * This class used to provide default values to transfer page with sender,
 * receiver account numbers and amount.
 */
@WebServlet("/DefaultTransferServlet")
public class DefaultTransferServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DefaultTransferServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		HttpSession session = request.getSession();
		String senderPAN = (String) session.getAttribute("senderPAN");
		String recipientPAN = (String) session
		        .getAttribute("recipientPAN");
		String amount = (String) session.getAttribute("amount");
		JSONObject outputJson = new JSONObject();
		PrintWriter out = response.getWriter();

		if (senderPAN == null || recipientPAN == null) {
			senderPAN = (String) new ConfigValues().getPropValues()
			        .get("senderPAN");
			recipientPAN = (String) new ConfigValues()
			        .getPropValues().get("recipientPAN");
			amount = (String) new ConfigValues().getPropValues().get(
			        "amount");
			session.setAttribute("senderPAN", senderPAN);
			session.setAttribute("recipientPAN", recipientPAN);
			session.setAttribute("amount", amount);
		}
		try {
			outputJson.put("senderPAN", senderPAN);
			outputJson.put("recipientPAN", recipientPAN);
			outputJson.put("amount", amount);
			response.setContentType("application/json");
			out.print(outputJson);
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