package com.ebms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebms.bean.Payment1;
import com.ebms.daoImpl.PaymentDaoImpl;


public class CPaymentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CPaymentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		PaymentDaoImpl pdao=new PaymentDaoImpl();
		List<Payment1> viewPayments=pdao.viewPayments();
		response.setContentType("text/html");
		pw.println("<!DOCTYPE.html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>EBMS</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div width='100%' height='100px'>");
		request.getRequestDispatcher("clink.html").include(request, response);
		pw.println("</div>");
		
		pw.println("<div>");
		pw.println("<table class='table table-bordered  table-hover'>");
		pw.println("<tr><th>PaymentId</th><th>Bill Id</th><th>Total Amount</th><th>Amount paid</th><th>Payment Method</th><th>Payment Status</th></tr>");
		
		for(Payment1 p:viewPayments)
		{
			pw.println("<tr><td>");
			pw.println(+p.getPid()+"</td><td>"+p.getBid()+"</td><td>"+p.getTotbill()+"</td><td>"+p.getPaying()+"</td><td>"+p.getPmethod()+"</td><td>"+p.getStatus()+"</td>");
			pw.println("</td></tr>");
		}
		pw.println("</table>");
		pw.println("</div>");
		pw.println("<div>");
		request.getRequestDispatcher("footer.html").include(request, response);
	    pw.println("</div>");
		
		
		pw.println("</body>");
		pw.println("</html>");
	}

}
