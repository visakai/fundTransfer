package com.visa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.visa.config.ConfigValues;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =  request.getParameter("username");
		String password =  request.getParameter("password1");

		String originalUsername = (String)new ConfigValues().getPropValues().get("username");
		String originalPwd = (String)new ConfigValues().getPropValues().get("password");
		JSONObject outputJson=new JSONObject();
		PrintWriter out = response.getWriter();
		try{
			response.setContentType("application/json");
			if((username!=null && username.equals(originalUsername)) && (password!=null && password.equals(originalPwd))){
				System.out.println("Login Successful!");
				outputJson.put("msg","LoginSuccess");	
			}else{
				System.out.println("Login Failed!");
				outputJson.put("msg","LoginFailed");				
			}
			out.print(outputJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
