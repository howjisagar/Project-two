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


public class ManagerPendingView extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie c[]=request.getCookies();
		String userName=c[0].getValue();
		String requestId=request.getParameter("reqId");
		System.out.println(requestId);
		ReimbursementService reimbursementService=new ReimbursementServiceImpl();
		List<ReimbursementEntity> requestDetailsList=reimbursementService.getDetailsById(requestId);
//		for (ReimbursementEntity re : requestDetailsList) {
//			System.out.println(re.getReqId());
//			System.out.println(re.getUserEmail().getEmail());
//			System.out.println(re.getUserEmail().getFirstName());
//			System.out.println(re.getReqType());
//			System.out.println(re.getReqDate());
//			System.out.println(re.getReqAmount());
//			System.out.println(re.getReqStatus());
//			System.out.println(re.getReqDescription());
//		}
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
		
		out.println("<form action='http://localhost:8080/ERS_Application/ManagerPendingUpdate' method='GET'>");
		out.println("<table border='1'>");
		out.println("<caption><h6>Reimbursement Action Form</h6></caption>");
		for(ReimbursementEntity re : requestDetailsList)
		{
			out.println("<tr>");
			out.println("<th>Request ID</th>");
			out.println("<td><input type='text' name='reqId' value="+re.getReqId());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>User Name</th>");
			out.println("<td><input type='text' name='userName' value="+re.getUserEmail().getEmail());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Employee Name</th>");
			out.println("<td><input type='text' name='empName' value="+re.getUserEmail().getuName());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Request Type</th>");
			out.println("<td><input type='text' name='reqType' value="+re.getReqType());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Request Date</th>");
			out.println("<td><input type='text' name='reqDate' value="+re.getReqDate());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Request Amount</th>");
			out.println("<td><input type='text' name='reqAmount' value="+re.getReqAmount());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Request Status</th>");
			out.println("<td><input type='text' name='reqStatus' value="+re.getReqStatus());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Request Description</th>");
			out.println("<td><input type='text' name='reqDescription' value="+re.getReqDescription());
			out.println("</td>");
			out.println("</tr");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>Request Action Date</th>");
			out.println("<td><input type='text' name='reqActionDate' ");
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Request Action Remarks</th>");
			out.println("<td><input type='text' name='reqActionRemarks'");
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Manager Action</th>");
			out.println("<td><select name='managerAction' >");
			out.println("<option value='Approve'>Approve");
			out.println("<option value='Deny'>Deny");
			out.println("</select>");
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<td colspan='2'><center><input id='submitButton' type='submit' value='Submit'></center>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		//out.println("<input id='submitButton' type='submit' value='Submit'>");
		out.println("</center>");
		out.println("</form>");
		
		out.println("</article> ");
		out.println("</section> ");
		out.println("<footer> ");
		out.println("<p>Footer</p> ");
		out.println("</footer> ");
		out.println("</body> ");
		out.println("</html> ");
		
	}
}
