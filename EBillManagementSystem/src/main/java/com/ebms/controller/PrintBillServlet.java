package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.Bill;
import com.ebms.daoImpl.BillDaoImpl;

/**
 * Servlet implementation class PrintBillServlet
 */
public class PrintBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("link.html").include(request, response);
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		BillDaoImpl bdao=new BillDaoImpl();
		
		pw.println("<!DOCTYPE.html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>EBMS</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div width='100%' height='100px'>");
		//request.getRequestDispatcher("link.html").include(request, response);
		pw.println("</div>");
		
		pw.println("<div>");
		/*pw.println("<table class='table table-bordered  table-hover'>");*/
		String id1=request.getParameter("bid");
		int bid=Integer.parseInt(id1);
		Bill b=bdao.generateBill(bid);
		//response.setContentType("application/pdf");
		if(b!=null)
		{
			pw.println("<table class='table table-bordered  table-hover'>");
			//pw.println("----------------------------------------");
			pw.println("<tr><th>Electricity Bill</th></tr>");
			//pw.println("----------------------------------------");
			pw.println("<tr><td>Bill No</td><td>"+b.getBid()+"</td></tr>");
			pw.println("<tr><td>Bill Date</td><td>"+b.getDate()+"</td></tr>");
			pw.println("<tr><td>Customer id</td><td>"+b.getCid()+"</td></tr>");
			pw.println("<tr><td>Customer Name</td><td>"+b.getCname()+"</td></tr>");
			pw.println("<tr><td>Customer Address</td><td>"+b.getCadd()+"</td></tr>");
			pw.println("<tr><td>Customer URSC Id</td><td>"+b.getCsid()+"</td></tr>");
			pw.println("<tr><td>Customer Mobile</td><td>"+b.getCmobile()+"</td></tr>");
			pw.println("<tr><td>Customer Connection type</td><td>"+b.getCtype()+"</td></tr>");
			pw.println("<tr><td>Units used</td><td>"+b.getUnits()+"</td></tr>");
			pw.println("<tr><td>Total Bill</td><td>"+b.getTotbill()+"</td></tr>");
			//pw.println("----------------------------------------");
			pw.println("</table>");
			pw.println("</div>");
			
			pw.println("<div>");
			request.getRequestDispatcher("footer.html").include(request, response);
			pw.println("</div>");
			
			pw.println("</body>");
			pw.println("</html>");
		}
		
		else
		{
			response.sendRedirect("BillServlet");
		}
	}

}
