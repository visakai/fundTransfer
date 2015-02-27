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
 * Servlet implementation class AdminResetServlet This class used to reset the
 * admin console window to default Credentials(X-APIKey and SharedSecret)
 */
@WebServlet("/AdminResetServlet")
public class AdminResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminResetServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminResetServlet Start>>>");
		HttpSession session = request.getSession();
		String apiKey = (String) session.getAttribute("apiKey");
		String sharedSecret = (String) session.getAttribute("sharedSecret");
		JSONObject outputJson = new JSONObject();
		PrintWriter out = response.getWriter();
		apiKey = (String) new ConfigValues().getPropValues().get("apiKey");
		sharedSecret = (String) new ConfigValues().getPropValues().get(
				"sharedSecret");
		session.setAttribute("apiKey", apiKey);
		session.setAttribute("sharedSecret", sharedSecret);
		try {
			outputJson.put("apiKey", apiKey);
			outputJson.put("sharedSecret", sharedSecret);
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