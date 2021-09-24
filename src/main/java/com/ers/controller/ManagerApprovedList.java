package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.entity.ReimbursementEntity;
import com.ers.service.ReimbursementService;
import com.ers.service.ReimbursementServiceImpl;


public class ManagerApprovedList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		
		ReimbursementService reimbursementService = (ReimbursementService) new ReimbursementServiceImpl();
		List<ReimbursementEntity> allApprovedRequestsList =reimbursementService.getAllApprovedRequests();
		for(ReimbursementEntity re : allApprovedRequestsList)
		{
			System.out.println(re.getReqId());
			System.out.println(re.getUserEmail().getEmail());
			System.out.println(re.getUserEmail().getuName());
			System.out.println(re.getReqType());
			System.out.println(re.getReqDate());
			System.out.println(re.getReqAmount());
			System.out.println(re.getReqStatus());
			System.out.println(re.getReqDescription());
			System.out.println(re.getReqActionDate());
			System.out.println(re.getReqActionRemarks());
		}
		
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
		
		out.println("<table border='1'>");
		out.println("<caption><h6>Approved Requests</h6></caption>");
		out.println("<tr>");
		out.println("<th>Request Id</th>");
		out.println("<th>User Name</th>");
		out.println("<th>Employee Name</th>");
		out.println("<th>Request Type</th>");
		out.println("<th>Request Date</th>");
		out.println("<th>Request Amount</th>");
		out.println("<th>Request Status</th>");
		out.println("<th>Request Description</th>");
		out.println("<th>Request Action Date</th>");
		out.println("<th>Request Action remarks</th>");
		out.println("</tr>");
		for(ReimbursementEntity re : allApprovedRequestsList)
		{
			out.println("<tr>");
			out.println("<td>"+re.getReqId()+"</td>");
			out.println("<td>"+re.getUserEmail().getEmail()+"</td>");
			out.println("<td>"+re.getUserEmail().getuName()+"</td>");
			out.println("<td>"+re.getReqType()+"</td>");
			out.println("<td>"+re.getReqDate()+"</td>");
			out.println("<td>"+re.getReqAmount()+"</td>");
			out.println("<td>"+re.getReqStatus()+"</td>");
			out.println("<td>"+re.getReqDescription()+"</td>");
			out.println("<td>"+re.getReqActionDate()+"</td>");
			out.println("<td>"+re.getReqActionRemarks()+"</td>");
			out.println("</tr");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href='ManagerHome.html'><input type='submit' value='Go To Home Page'></a>");
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
