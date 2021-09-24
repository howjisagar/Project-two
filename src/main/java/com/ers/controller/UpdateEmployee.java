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


public class UpdateEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		
		RegistrationService regService=new RegistrationServiceImpl();
		List<RegistrationEntity> employeeList=regService.getEmployeeDetails(userName);
		boolean genderFlag=false;
		
		for(RegistrationEntity elist : employeeList)
		{
			System.out.println(elist.getuName());
			System.out.println(elist.getEmail());
			System.out.println(elist.getContactNo());
			System.out.println(elist.getAge());
			
			if(elist.getGender().equals("Male"))
			{
				genderFlag=true;
			}
			
			System.out.println(userName);
			System.out.println(elist.getAddress());
			System.out.println(elist.getEmployeeType());
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
		out.println("<li><a href='http://localhost:8080/ERS_Application/ReimbursementForm'>Apply for Reimbursement</a></li> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/PendingList'>Pending Applications</a></li> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/ApprovedList'>Completed Applications</a></li> ");
		out.println("<li><a href='http://localhost:8080/ERS_Application/UpdateEmployee'>Update Profile</a></li> ");
		out.println("<li><a href=\"logout.jsp\">Logout</a></li> ");
		out.println("</ul> ");
		out.println("</nav> ");
		out.println("<article> ");
		
		out.println("<h6>Edit Profile</h6>");
		out.println("<form action='http://localhost:8080/ERS_Application/UpdateEmployeeInfo' method='GET'>");
		out.println("<table border='1'>");
		for(RegistrationEntity elist : employeeList)
		{
			out.println("<tr>");
			out.println("<th>First name</th>");
			out.println("<td><input type='text' name='username' value="+elist.getuName());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Email</th>");
			out.println("<td><input type='email' name='email' value="+elist.getEmail());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Contact Number</th>");
			out.println("<td><input type='text' name='contactno' value="+elist.getContactNo());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Age</th>");
			out.println("<td><input type='number' name='age' value="+elist.getAge());
			out.println("</td>");
			out.println("</tr");
			if(genderFlag)
			{
				out.println("<tr>");
				out.println("<th rowspan='2'> Gender</th>");
				out.println("<td><input type='radio' name='gender' checked value="+elist.getGender());
				out.println("<label for='male'>Male</label>");
				out.println("</td>");
				out.println("</tr");
				out.println("<tr>");
				out.println("<td><input type='radio' name='gender'value="+elist.getGender());
				out.println("<label for='female'>Female</label>");
				out.println("</td>");
				out.println("</tr");
			}
			else
			{
				out.println("<tr>");
				out.println("<th rowspan='2'> Gender</th>");
				out.println("<td><input type='radio' name='gender' value="+elist.getGender());
				out.println("<label for='male'>Male</label>");
				out.println("</td>");
				out.println("</tr");
				out.println("<tr>");
				out.println("<td><input type='radio' name='gender' checked value="+elist.getGender());
				out.println("<label for='female'>Female</label>");
				out.println("</td>");
				out.println("</tr");
			}
			
			
			out.println("<tr>");
			out.println("<th>Address</th>");
			out.println("<td><input type='text' name='address' value="+elist.getAddress());
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Employee Type</th>");
			out.println("<td><select name='type' >");
			out.println("<option value='Manager'>Manager");
			out.println("<option value='Employee'>Employee");
			out.println("</select>");
			out.println("</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<center>");
			out.println("<td colspan='2'><center><input id='submitButton' type='submit' value='Update'></center>");
			out.println("</td>");
			out.println("</center>");
			out.println("</tr>");
		}
		out.println("</table>");
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
