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

import com.ebms.bean.Empolyee;
import com.ebms.daoImpl.EmplDaoImpl;

/**
 * Servlet implementation class EmpolyeeServlet
 */
public class EmpolyeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(EmpolyeeServlet.class);
    public EmpolyeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		EmplDaoImpl eimpl=new EmplDaoImpl();
		PrintWriter pw=response.getWriter();
		
		String ename=request.getParameter("ename");
		String eadd=request.getParameter("eadd");
		String emobile1=request.getParameter("emobile");
		Long emobile=Long.parseLong(emobile1);
		String eprofile=request.getParameter("eprofile");
		
		Empolyee e=new Empolyee(ename,eadd,emobile,eprofile);
		int count=eimpl.addEmpolyee(e);
		if(count!=0)
		{
			pw.println("Employee successfully registered");
			logger.info("Employee successfully registered");
			RequestDispatcher rd=request.getRequestDispatcher("lemp.html"); 
			rd.forward(request, response);
		}
			else
			{
			pw.println("not registered");
			logger.info("not registered");
			RequestDispatcher rd=request.getRequestDispatcher("eregister.html"); 
			rd.forward(request, response);
			}
	}

}
