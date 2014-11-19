package com.visa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class AdminConsoleServlet
 */
@WebServlet("/AdminConsoleServlet")
public class AdminConsoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConsoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String apiKey = request.getParameter("apiKey");
		String sharedSecret = request.getParameter("sharedSecret");
		
		System.out.println("apiKey: "+ apiKey + "  sharedSecret: "+ sharedSecret );
		
		if(apiKey != null && sharedSecret != null) {
			
			HttpSession session = request.getSession();
		session.setAttribute("apiKey", apiKey);
		session.setAttribute("sharedSecret", sharedSecret);
		}
		
		
	}
			
						 
		
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
