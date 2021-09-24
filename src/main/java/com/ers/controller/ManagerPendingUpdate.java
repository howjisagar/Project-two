package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.ReimbursementService;
import com.ers.service.ReimbursementServiceImpl;


public class ManagerPendingUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean getStatus = false;
		String managerAction = "";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie c[] = request.getCookies();
		String userName = c[0].getValue();
		
		String requestId = request.getParameter("reqId");
		String action = request.getParameter("managerAction");
		String reqActionDate=request.getParameter("reqActionDate");
		String reqActionRemarks=request.getParameter("reqActionRemarks");
		if (action.equals("Approve")) {
			managerAction = "Accepted";
		} else {
			managerAction = "Denied";
		}
		System.out.println(requestId + " " + managerAction+" "+reqActionDate+" "+reqActionRemarks);
		ReimbursementService reimbursementService = new ReimbursementServiceImpl();
		getStatus = reimbursementService.updateRequestStatus(requestId, managerAction,reqActionDate,reqActionRemarks);
		System.out.println(getStatus);
		if(getStatus)
		{
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
			
			out.println("<center>");
			out.println("<h6>Updated the status of the Reimbursement Request</h6>");
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
}
