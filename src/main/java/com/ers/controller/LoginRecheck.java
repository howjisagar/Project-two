package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ers.model.LoginModel;
import com.ers.service.LoginRecheckService;
import com.ers.service.LoginRecheckServiceImpl;

public class LoginRecheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("pwd");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean status=false;
		System.out.println(userName + " " + passWord + " " + confirmPassword);
		if (passWord.equals(confirmPassword)) {
			LoginModel loginModel = new LoginModel();
			loginModel.setUserName(userName);
			loginModel.setPassWord(passWord);
			LoginRecheckService loginService = new LoginRecheckServiceImpl();
			status=loginService.addLoginDetails(loginModel);
			if(status)
			{
				response.sendRedirect("http://localhost:8080/ERS_Application/RegistrationSuccess.html");
			}
		}
		else
		{
			out.println("<center>");
			out.println("<h1>Password and Confirm password not Matched></h1>");
			out.println("<a href='http://localhost:8080/ERS_Application/loginCredinitial.html'><input type='submit' value='Go Back'></a>");
			out.println("</center>");
		}
		
	}
}
