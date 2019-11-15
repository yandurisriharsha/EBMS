package com.ebms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.daoImpl.CustDaoImpl;

public class CsidRetriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CsidRetriveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		CustDaoImpl cdao=new CustDaoImpl();
		List<Integer> viewrecords=cdao.retrive();
		for(Integer id : viewrecords)
		{
			System.out.println(id);
		}
		ServletContext context=getServletContext();
		context.setAttribute("sid", viewrecords);
		RequestDispatcher rd=request.getRequestDispatcher("bill.jsp");
		rd.forward(request, response);
		
	}

}
