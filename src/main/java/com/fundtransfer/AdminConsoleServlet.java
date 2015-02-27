
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

/**
 * Servlet implementation class AdminConsoleServlet
 * This class used to read the Credentials(X-APIKey and SharedSecret) from Admin
 * Console page
 */
@WebServlet("/AdminConsoleServlet")
public class AdminConsoleServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminConsoleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException,
	        IOException {
		System.out.println("AdminConsoleServlet Start>>>");
		String apiKey = request.getParameter("apiKey");
		String sharedSecret = request.getParameter("sharedSecret");
		JSONObject outputJson = new JSONObject();
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		if (apiKey != null && sharedSecret != null) {
			session = request.getSession();
			System.out.println("Putting new apikey, ss in session>>"+apiKey);
			session.setAttribute("apiKey", apiKey);
			session.setAttribute("sharedSecret", sharedSecret);
		}
		try {
			outputJson.put("apiKey", session.getAttribute("apiKey"));
			outputJson.put("sharedSecret", session.getAttribute("sharedSecret"));
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
