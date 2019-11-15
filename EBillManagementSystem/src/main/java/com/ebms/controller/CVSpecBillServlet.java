package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.Bill;
import com.ebms.daoImpl.BillDaoImpl;

/**
 * Servlet implementation class CVSpecBillServlet
 */
public class CVSpecBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CVSpecBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		BillDaoImpl bdao=new BillDaoImpl();
		String id=request.getParameter("csid");
		int csid=Integer.parseInt(id);
		Bill b=bdao.viewSpecBill(csid);
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE.html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>EBMS</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("link.html").include(request, response);
		out.println("</div>");
		
		out.println("<div>");
		out.println("<table class='table table-bordered  table-hover'>");
		out.println("<tr><th>Bid</th><th>date</th><th>Cid</th><th>Cname</th><th>Cadd</th><th>Csid</th><th>Ctype</th><th>Cmobile</th><th>Units</th><th>Total Bill</th><th>Bill Status</th><th></th><th></th></tr>");
		if(b!=null)
		{
			out.println("<tr><td>");
			out.println(b.getBid()+"</td><td>"+b.getDate()+"</td><td>"+b.getCid()+"</td><td>"+b.getCname()+"</td><td>"+b.getCadd()+"</td><td>"+b.getCsid()+"</td><td>"+b.getCtype()+"</td><td>"+b.getCmobile()+"</td><td>"+b.getUnits()+"</td><td>"+b.getTotbill()+"</td><td>"+b.getStatus()+"</td><td>"+"<a href=BDeleteServlet?bid="+b.getBid()+">Delete</a>"+"</td><td>"+"<a href=PrintBillServlet?bid="+b.getBid()+">Print</a>");
			out.println("</td></tr>");	
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
