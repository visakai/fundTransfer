package com.visa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.config.ConfigValues;

import Decoder.BASE64Decoder;

/**
 * Servlet Filter implementation class BasicAuthFilter
 */
@WebFilter("/BasicAuthFilter")
public class BasicAuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BasicAuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//System.out.println("in filter");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session= httpRequest.getSession();
        String user=(String)session.getAttribute("user");
        String pass;
        if(user==null){
            try{
               response.setCharacterEncoding("GBK");
               PrintWriter out=response.getWriter();
               String authorization=httpRequest.getHeader("authorization");
               if(authorization==null||authorization.equals("")){
            	   httpResponse.setStatus(401);
            	   httpResponse.setHeader("WWW-authenticate","Basic realm=\"Username and password required\"");
                   out.print("Sorry");
                   return;
               }
               String userAndPass=new String(new BASE64Decoder().decodeBuffer(authorization.split(" ")[1]));
            
               if(userAndPass.split(":").length<2){
            	   httpResponse.setStatus(401);
            	   httpResponse.setHeader("WWW-authenticate","Basic realm=\"Username and password required\"");
                   out.print("Sorry");
                   return;
               }
               user=userAndPass.split(":")[0];
               pass=userAndPass.split(":")[1];
               
               String username = (String)new ConfigValues().getPropValues().get("username");
               String password = (String)new ConfigValues().getPropValues().get("password");
               
               if(user.equals(username)&&pass.equals(password)){
                   session.setAttribute("user",user);
//                   RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
//                   dispatcher.forward(request,response);
                   //System.out.println("in filter, if");
               }else{
            	   httpResponse.setStatus(401);
            	   httpResponse.setHeader("WWW-authenticate","Basic realm=\"Username and password required\"");
                   out.print("Sorry");
                   return;
               }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }else{
//            RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
//            dispatcher.forward(request,response);
        	//System.out.println("in filter, last else");
      }

		
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
