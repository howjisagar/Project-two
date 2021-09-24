package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.model.RegistrationModel;
import com.ers.service.RegistrationService;
import com.ers.service.RegistrationServiceImpl;


public class EmployeeRegistration extends HttpServlet {
	
	static Logger logger=Logger.getLogger("EmployeeRegistration.class");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("In sign up -> add method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("mobile");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String employeeType = request.getParameter("type");

		RegistrationModel rModel = new RegistrationModel();
		
		rModel.setuName(userName);
		rModel.setEmail(email);
		rModel.setContactNo(contactNo);
		rModel.setAge(Integer.parseInt(age));
		rModel.setGender(gender);
		rModel.setAddress(address);
		rModel.setEmployeeType(employeeType);
		
		RegistrationService regService = new RegistrationServiceImpl();
		boolean getStatus = regService.addEmployeeDetails(rModel);
		if (getStatus) {
			logger.info("In login credential -> add method");
			response.sendRedirect("http://localhost:8080/ERS_Application/LoginRecheckForm.html");

		}
		
	}

}
