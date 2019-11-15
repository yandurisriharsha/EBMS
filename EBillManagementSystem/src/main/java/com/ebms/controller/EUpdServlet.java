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

import com.ebms.daoImpl.EmplDaoImpl;

/**
 * Servlet implementation class EUpdServlet
 */
public class EUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(EUpdServlet.class);

    public EUpdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EmplDaoImpl edao=new EmplDaoImpl();
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("eid");
		int eid=Integer.parseInt(id);
		String ename=request.getParameter("ename");
		String eadd=request.getParameter("eadd");
		String mobile=request.getParameter("emobile");
		Long emobile=Long.parseLong(mobile);
		String eprofile=request.getParameter("eprofile");
		int count=edao.updateEmpolyee(eid, ename, eadd, emobile, eprofile);
		if(count!=0)
		{
			//pw.println("Data deleted");
			logger.info("Data updated");
			pw.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("EmpViewServlet"); 
			rd.forward(request, response);
			pw.println("</div>");
			pw.println("<div>");
			pw.println("Data updated");
			pw.println("</div>");
			//pw.println("<a href=EmpViewServlet>viewRecords</a>");
		}
		else
		{
			//pw.println("Data not Deleted");
			logger.info("Data not updated");
			pw.println("<div>");
			RequestDispatcher rd=request.getRequestDispatcher("EmpViewServlet"); 
			rd.forward(request, response);
			pw.println("</div>");
			pw.println("<div>");
			pw.println("Data not updated");
			pw.println("</div>");
		}
	}

}
