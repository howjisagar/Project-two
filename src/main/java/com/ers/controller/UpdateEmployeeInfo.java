package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.RegistrationModel;
import com.ers.service.RegistrationService;
import com.ers.service.RegistrationServiceImpl;

public class UpdateEmployeeInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactno");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String employeeType = request.getParameter("type");

		RegistrationModel regModel = new RegistrationModel();
		
		regModel.setuName(userName);
		regModel.setEmail(email);
		regModel.setContactNo(contactNo);
		regModel.setAge(Integer.parseInt(age));
		regModel.setGender(gender);
		regModel.setAddress(address);
		regModel.setEmployeeType(employeeType);
		
		RegistrationService regService = new RegistrationServiceImpl();
		boolean getStatus = regService.updateEmployeeDetails(regModel);
		if (getStatus) {
//			logger.info("In login credential -> add method");
			response.sendRedirect("http://localhost:8080/ERS_Application/UpdateSuccess.html");

		}	
	}
}
