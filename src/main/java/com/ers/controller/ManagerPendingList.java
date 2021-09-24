package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ers.service.ReimbursementService;
import com.ers.service.ReimbursementServiceImpl;

public class ManagerPendingList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie c[]=request.getCookies();
		String userName=c[0].getValue();
		
		ReimbursementService reimbursementService=new ReimbursementServiceImpl();
		List<String> requestIdList=reimbursementService.getRequestIds();
		
		out.println(" <!DOCTYPE html>");
		out.println("<html lang=\"en\"> ");
		out.println(" <head>");
		out.println("<title>CSS Template</title> ");
		out.println(" <meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> ");
		out.println("<link href=\"css/homepageStyle.css\" rel=\"stylesheet\"> ");
		out.println("</head> ");
		out.println("<body> ");
		out.println("<header> ");
		out.println(" <h2>Welcome to ERS</h2>");
		out.println(" </header>");
		out.println("<section> ");
		out.println("<nav> ");
		out.println("<ul> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/ManagerProfile'>Profile</a></li> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/EmployeeList'>All Employees</a></li> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/ManagerPendingList'>Pending Applications</a></li> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/ManagerApprovedList'>Completed Applications</a></li> ");
		out.println("<li><a href=\"logout.jsp\">Logout</a></li> ");
		out.println("</ul> ");
		out.println("</nav> ");
		out.println("<article> ");
		
		for(String idList:requestIdList)
		{
			System.out.println(idList);
		}
		out.println("<center>");
		out.println("<h6>Approve or Deny Request</h6>");
		out.println("<form action='http://localhost:8080/ERS_Application/ManagerPendingView' method='GET'>");
		out.println("Reimbursement Request IDs:<select name='reqId'>");
		for(String idList:requestIdList)
		{
			out.println("<option name='id'>"+idList+"");
		}
		out.println("<select><br>");
		out.println("<input type='submit' value='Select the Request ID'>");
		out.println("</form>");
		out.println("</center>");
		
		out.println("</article> ");
		out.println("</section> ");
		out.println("<footer> ");
		out.println("<p>Footer</p> ");
		out.println("</footer> ");
		out.println("</body> ");
		out.println("</html> ");
		
	}
}
