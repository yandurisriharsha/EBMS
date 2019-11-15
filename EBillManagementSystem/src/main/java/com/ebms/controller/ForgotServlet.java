package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebms.daoImpl.CSRegisterDaoImpl;

/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("cemail");
		CSRegisterDaoImpl crdao=new CSRegisterDaoImpl(); 
		boolean flag=crdao.forgotPassword(email);
		if(flag)
		{
			out.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("custfp.html"); 
			rd.include(request, response);
			out.println("</div>");
			out.println("<div>");
			out.println("<h2>Your mail will recieve password reset link soon........</h2>");
			out.println("</div>");
		}
		else
		{
			out.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("custfp.html"); 
			rd.include(request, response);
			out.println("</div>");
			out.println("<div margin-left='100px' font-color='red'>");
			out.println("<h2>This email is not registered mail</h2>");
			
			out.println("</div>");
		}
	}

}
