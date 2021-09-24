package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ers.entity.RegistrationEntity;
import com.ers.service.RegistrationService;
import com.ers.service.RegistrationServiceImpl;

public class ManagerProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		
		RegistrationService signupServiceImpl=new RegistrationServiceImpl();
		List<RegistrationEntity> employeeList=signupServiceImpl.getEmployeeDetails(userName);
//		for(RegistrationEntity elist : employeeList)
//		{
//			System.out.println(elist.getFirstName());
//			System.out.println(elist.getLastName());
//			System.out.println(elist.getDateOfBirth());
//			System.out.println(elist.getAge());
//			System.out.println(elist.getGender());
//			System.out.println(userName);
//			System.out.println(elist.getContactNo());
//			System.out.println(elist.getAddress());
//			System.out.println(elist.getEmployeeType());
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
		
		out.println("<table border='1'>");
		out.println("<caption><h6>Personal Information</h6></caption>");
		for(RegistrationEntity elist : employeeList)
		{
			out.println("<tr>");
			out.println("<th>User name</th>");
			out.println("<td>"+elist.getuName()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Email</th>");
			out.println("<td>"+userName+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Contact Number</th>");
			out.println("<td>"+elist.getContactNo()+"</td>");
			out.println("</tr");
			
			out.println("<tr>");
			out.println("<th>Age</th>");
			out.println("<td>"+elist.getAge()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Gender</th>");
			out.println("<td>"+elist.getGender()+"</td>");
			out.println("</tr");
			
			
			out.println("<tr>");
			out.println("<th>Address</th>");
			out.println("<td>"+elist.getAddress()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Employee Type</th>");
			out.println("<td>"+elist.getEmployeeType()+"</td>");
			out.println("</tr");
			if(elist.getEmployeeType().equals("employee"))
			{
				out.println("<tr>");
				out.println("<center>");
				out.println("<td><center><a href='EmployeeHome.html'><input id='submitButton' type='submit' value='Go Back to Home'></center></a>");
				out.println("</td>");
				out.println("</center>");
				out.println("</tr>");
			}
			if(elist.getEmployeeType().equals("manager"))
			{
				out.println("<tr>");
				out.println("<center>");
				out.println("<td><center><a href='ManagerHome.html'><input id='submitButton' type='submit' value='Go Back to Home'></center></a>");
				out.println("</td>");
				out.println("</center>");
				out.println("</tr>");
			}
		}
		out.println("</tr>");
		out.println("</table>");
		
		out.println("</article> ");
		out.println("</section> ");
		out.println("<footer> ");
		out.println("<p>Footer</p> ");
		out.println("</footer> ");
		out.println("</body> ");
		out.println("</html> ");
	}
}
