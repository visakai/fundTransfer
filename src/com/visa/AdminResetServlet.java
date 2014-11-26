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
 * Servlet implementation class AdminResetServlet
 */
@WebServlet("/AdminResetServlet")
public class AdminResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String apiKey= (String)session.getAttribute("apiKey");
		String sharedSecret = (String)session.getAttribute("sharedSecret");
		
		if(apiKey==null ||sharedSecret==null ){
			apiKey = (String)new ConfigValues().getPropValues().get("apiKey");
			sharedSecret = (String)new ConfigValues().getPropValues().get("sharedSecret");

			session.setAttribute("apiKey", apiKey);
			session.setAttribute("sharedSecret", sharedSecret);
		}
		
		if(apiKey!=null ||sharedSecret!=null ){
			
						
			 apiKey = (String)new ConfigValues().getPropValues().get("apiKey");
			 sharedSecret = (String)new ConfigValues().getPropValues().get("sharedSecret");
			
			session.setAttribute("apiKey", apiKey);
			session.setAttribute("sharedSecret", sharedSecret);
			
		
		}
		JSONObject outputJson=new JSONObject();
		PrintWriter out = response.getWriter();
		try {
			outputJson.put("apiKey",apiKey);
			outputJson.put("sharedSecret",sharedSecret);
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