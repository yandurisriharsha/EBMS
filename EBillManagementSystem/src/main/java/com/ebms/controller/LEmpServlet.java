package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.LEmpolyee;
import com.ebms.daoImpl.EmplDaoImpl;

/**
 * Servlet implementation class LEmpServlet
 */
public class LEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(LEmpServlet.class);
    public LEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		EmplDaoImpl eimpl=new EmplDaoImpl();
		PrintWriter pw=response.getWriter();
		String euserid=request.getParameter("euserid");
		String epwd=request.getParameter("epwd");
		LEmpolyee le=new LEmpolyee(euserid,epwd);
		int count=eimpl.addEmpolyeeLogin(le);
		if(count!=0)
		{
			pw.println("Employee Login successfully registered");
			logger.info("Employee Login successfully registered");
			RequestDispatcher rd=request.getRequestDispatcher("admin.html"); 
			rd.forward(request, response);
		}
			else
			{
			pw.println("Employee Login not registered");
			logger.info("Employee Login not registered");
			RequestDispatcher rd=request.getRequestDispatcher("lemp.html"); 
			rd.forward(request, response);
			}
	}

}
