package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ebms.bean.UnitPrice;
import com.ebms.daoImpl.UnitPriceDaoImpl;

/**
 * Servlet implementation class UnitInsertServlet
 */
public class UnitInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(UnitInsertServlet.class);
    public UnitInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		UnitPriceDaoImpl updi=new UnitPriceDaoImpl();
		String ctype=request.getParameter("ctype");
		String price=request.getParameter("unitprice");
		int unitprice=Integer.parseInt(price);
		UnitPrice up=new UnitPrice(ctype,unitprice);
		int count=updi.add(up);
		if(count!=0)
		{
			out.println("Inserted");
			logger.info("Inserted");
		}
		else
		{
		out.println("Data not Inserted");
		logger.info("Data not Inserted");
		}
	}

}
