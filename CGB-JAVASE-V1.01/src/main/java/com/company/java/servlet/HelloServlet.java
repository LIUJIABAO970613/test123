package com.company.java.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID 
	= -8409196011103524039L;
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("doGet");
	   resp.getWriter().print("hello servlet");
	}
}
