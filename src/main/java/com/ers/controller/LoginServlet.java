package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.entity.LoginEntity;
import com.ers.service.LoginService;
import com.ers.service.LoginServiceImpl;
import com.ers.service.RegistrationService;
import com.ers.service.RegistrationServiceImpl;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean status = false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("pwd");
		
//		out.println(userName + " " + passWord);
		
		Cookie cookie = new Cookie("cusername", userName);
		response.addCookie(cookie);
		
		RegistrationService regService = new RegistrationServiceImpl();
		String employeeType = regService.getEmployeeType(userName);
		
		LoginService loginServiceImpl = (LoginService) new LoginServiceImpl();
		List<LoginEntity> loginList = loginServiceImpl.validateUser();
		
		for (LoginEntity e : loginList) {
			if (e.getUserName().equals(userName) && e.getPassWord().equals(passWord)
					&& employeeType.equals("employee")) {
				status = true;
				request.setAttribute("attributeName", userName);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeHome.html");
				requestDispatcher.forward(request, response);
			}
			if (e.getUserName().equals(userName) && e.getPassWord().equals(passWord)
					&& employeeType.equals("Manager")) {
				status = true;
				request.setAttribute("attributeName", userName);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ManagerHome.html");
				requestDispatcher.forward(request, response);
			}
		}
		if (!status) {
			response.sendRedirect("http://localhost:8080/ERS_Application/LoginFailed.html");
		}
		
	}

}
