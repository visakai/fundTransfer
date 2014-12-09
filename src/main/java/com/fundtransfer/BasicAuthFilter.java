
package com.fundtransfer;

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

import com.fundtransfer.config.ConfigValues;

/**
 * Servlet Filter implementation class BasicAuthFilter
 * This class used to check the basic authentication with provided username and
 * password
 */
@WebFilter("/BasicAuthFilter")
public class BasicAuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public BasicAuthFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request,
	        ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String user = (String) session.getAttribute("user");
		String pass;
		String userAndPass;
		String authorization;
		PrintWriter out;
		String username;
		String password;

		if (user == null) {
			try {
				response.setCharacterEncoding("GBK");
				out = response.getWriter();
				authorization = httpRequest
				        .getHeader("authorization");
				if (authorization == null || authorization.equals("")) {
					httpResponse.setStatus(401);
					httpResponse
					        .setHeader("WWW-authenticate",
					                "Basic realm=\"Username and password required\"");
					out.print("Username and password required");
					return;
				}
				userAndPass = new String(
				        new sun.misc.BASE64Decoder()
				                .decodeBuffer(authorization
				                        .split(" ")[1]));

				if (userAndPass.split(":").length < 2) {
					httpResponse.setStatus(401);
					httpResponse
					        .setHeader("WWW-authenticate",
					                "Basic realm=\"Username and password required\"");
					out.print("Username and password required");
					return;
				}
				user = userAndPass.split(":")[0];
				pass = userAndPass.split(":")[1];
				username = (String) new ConfigValues()
				        .getPropValues().get("username");
				password = (String) new ConfigValues()
				        .getPropValues().get("password");
				if (user.equals(username) && pass.equals(password)) {
					session.setAttribute("user", user);
				} else {
					httpResponse.setStatus(401);
					httpResponse
					        .setHeader("WWW-authenticate",
					                "Basic realm=\"Username and password required\"");
					out.print("401 Error");
					return;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
