package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.Empolyee1;
import com.ebms.daoImpl.EmplDaoImpl;

/**
 * Servlet implementation class EUpdateServlet
 */
public class EUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EUpdateServlet() {
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
		Empolyee1 emp=new Empolyee1();
		//pw.println("<a href=student.html>update</a>");
		
		String no=request.getParameter("eid");
		int eid=Integer.parseInt(no);
		emp=edao.viewEmpolyee(eid);
		response.setContentType("text/html");
		pw.println("<!DOCTYPE.html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>EBMS</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("elink.html").include(request, response);
		pw.println("</div>");
		pw.println("<div>");
		pw.println("<table border='3'>");
		if(emp!=null)
		{
		pw.println("<table align=center cellspacing=10px cellpadding=5px>");
		pw.println("<form action=EUpdServlet>");
		pw.println("<tr><td>Empolyee id:</td><td><input type='text' readonly name=eid value="+emp.getEid()+"></td></tr><br>");
		pw.println("<tr><td>Empolyee Name:</td><td><input type='text' name=ename value="+emp.getEname()+"></td></tr><br>");
		pw.println("<tr><td>Empolyee Address:</td><td><input type='text' name=eadd value="+emp.getEadd()+"></td></tr><br>");
		pw.println("<tr><td>Empolyee Mobile:</td><td><input type='text' name=emobile value="+emp.getEmobile()+"></td></tr><br>");
		pw.println("<tr><td>Empolyee Profile:</td><td><input type='text' name=eprofile value="+emp.getEprofile()+"></td></tr><br>");
		pw.println("<tr><td></td><td><input type='submit' name=submit value=update></td></tr><br>");
		pw.println("</form>");
		pw.println("</table>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");

		}
	}

}
