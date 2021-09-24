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


public class EmployeeList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] c = request.getCookies();
		String userName = c[0].getValue();
		
		RegistrationService regService = new RegistrationServiceImpl();
		List<RegistrationEntity> allEmployeesList = regService.getAllEmployees();
//		for (RegistrationEntity re : allEmployeesList) {
//			System.out.println(re.getFirstName());
//			System.out.println(re.getLastName());
//			System.out.println(re.getDateOfBirth());
//			System.out.println(re.getAge());
//			System.out.println(re.getGender());
//			System.out.println(re.getEmail());
//			System.out.println(re.getAddress());
//			System.out.println(re.getEmployeeType());
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
		out.println("<caption><h6>All Employee Details</h6></caption>");
		out.println("<tr>");
		out.println("<th>User Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Contact No</th>");
		out.println("<th>Age</th>");
		out.println("<th>Gender</th>");
		out.println("<th>Address</th>");
		out.println("<th>Employee Type</th>");
		out.println("</tr>");
		for (RegistrationEntity re : allEmployeesList) {
			out.println("<tr>");
			out.println("<td>" + re.getuName() + "</td>");
			out.println("<td>" + re.getEmail() + "</td>");
			out.println("<td>" + re.getContactNo() + "</td>");
			out.println("<td>" + re.getAge() + "</td>");
			out.println("<td>" + re.getGender() + "</td>");
			out.println("<td>" + re.getAddress() + "</td>");
			out.println("<td>" + re.getEmployeeType() + "</td>");
			out.println("</tr");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href='ManagerHome.html'><input type='submit' value='Go To Home Page'></a>");
		
		out.println("</article> ");
		out.println("</section> ");
		out.println("<footer> ");
		out.println("<p>Footer</p> ");
		out.println("</footer> ");
		out.println("</body> ");
		out.println("</html> ");
		
	}
}
