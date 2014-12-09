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
 * Servlet implementation class TransferResetServlet This class used to provide
 * default values when we select Reset option in transfer page
 */
@WebServlet("/TransferResetServlet")
public class TransferResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferResetServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String senderPAN = (String) session.getAttribute("senderPAN");
		String recipientPAN = (String) session.getAttribute("recipientPAN");
		String amount = (String) session.getAttribute("amount");
		JSONObject outputJson = new JSONObject();
		PrintWriter out = response.getWriter();
		senderPAN = (String) new ConfigValues().getPropValues()
				.get("senderPAN");
		recipientPAN = (String) new ConfigValues().getPropValues().get(
				"recipientPAN");
		amount = (String) new ConfigValues().getPropValues().get("amount");
		session.setAttribute("senderPAN", senderPAN);
		session.setAttribute("recipientPAN", recipientPAN);
		session.setAttribute("amount", amount);
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
			HttpServletResponse response) throws ServletException, IOException {
	}

}