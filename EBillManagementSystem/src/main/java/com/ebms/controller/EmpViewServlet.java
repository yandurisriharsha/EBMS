package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.Empolyee;
import com.ebms.bean.Empolyee1;
import com.ebms.daoImpl.EmplDaoImpl;

/**
 * Servlet implementation class EmpViewServlet
 */
public class EmpViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		EmplDaoImpl eimpl=new EmplDaoImpl();
		List<Empolyee1> viewEmployee=eimpl.viewAllEmpolyees();
		response.setContentType("text/html");
		pw.println("<!DOCTYPE.html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>EBMS</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("link.html").include(request, response);
		pw.println("</div>");
		
		pw.println("<div>");
		pw.println("<table class='table table-bordered  table-hover'>");
		pw.println("<tr><th>EmployeeId</th><th>EmployeeName</th><th>EmpAdddress</th><th>EmplMobile</th><th>EmpProfile</th><th></th><th></th></tr>");
		
		for(Empolyee1 e:viewEmployee)
		{
			pw.println("<tr><td>");
			pw.println(+e.getEid()+"</td><td>"+e.getEname()+"</td><td>"+e.getEadd()+"</td><td>"+e.getEmobile()+"</td><td>"+e.getEprofile()+"</td><td>"+"<a href=EDeleteServlet?eid="+e.getEid()+">Delete</a>"+"</td><td>"+"<a href=EUpdateServlet?eid="+e.getEid()+">Update</a></td>");
			pw.println("</td></tr>");
		}
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
