
package com.fundtransfer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String apiKey = request.getParameter("apiKey");
		String sharedSecret = request.getParameter("sharedSecret");
		HttpSession session;
		if (apiKey != null && sharedSecret != null) {
			session = request.getSession();
			session.setAttribute("apiKey", apiKey);
			session.setAttribute("sharedSecret", sharedSecret);
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
