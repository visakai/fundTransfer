package com.visa;

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

import com.visa.config.ConfigValues;

/**
 * Servlet implementation class DefaultTransferServlet
 */
@WebServlet("/DefaultTransferServlet")
public class DefaultTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DefaultTransferServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String senderPAN= (String)session.getAttribute("senderPAN");
		String recipientPAN = (String)session.getAttribute("recipientPAN");

		if(senderPAN==null ||recipientPAN==null ){
			senderPAN = (String)new ConfigValues().getPropValues().get("senderPAN");
			recipientPAN = (String)new ConfigValues().getPropValues().get("recipientPAN");

			session.setAttribute("senderPAN", senderPAN);
			session.setAttribute("recipientPAN", recipientPAN);
		}
		
		JSONObject outputJson=new JSONObject();
		PrintWriter out = response.getWriter();
		try {
			outputJson.put("senderPAN",senderPAN);
			outputJson.put("recipientPAN",recipientPAN);
			response.setContentType("application/json");
			out.print(outputJson);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}