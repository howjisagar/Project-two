package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ers.model.ReimbursementModel;
import com.ers.service.ReimbursementService;
import com.ers.service.ReimbursementServiceImpl;

public class ReimbursementRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String reqId = request.getParameter("reImbursementId");
		String reqType =request.getParameter("reImbursementType");
		Double reqAmount = Double.parseDouble(request.getParameter("reImbursementAmount"));
		String reqDate = request.getParameter("reImbursementSubDate");
		String reqStatus = request.getParameter("reImbursementStatus");
		String reqActionDate=request.getParameter("reImbursementActionDate");
		String reqRemarks=request.getParameter("reImbursementRemarks");
		String reqDescription = request.getParameter("reImbursementDescription");
		System.out.println(
				reqId + " " + reqType + " " + reqAmount + " " + reqDate + " " + reqStatus + " " + reqDescription+" "+reqActionDate+" "+reqRemarks);
		ReimbursementModel reimbursementModel = new ReimbursementModel();
		reimbursementModel.setReqId(reqId);
		reimbursementModel.setReqType(reqType);
		reimbursementModel.setReqAmount(reqAmount);
		reimbursementModel.setReqDate(reqDate);
		reimbursementModel.setReqStatus(reqStatus);
		reimbursementModel.setReqDescription(reqDescription);
		reimbursementModel.setActionRemarks(reqRemarks);
		reimbursementModel.setReqActionDate(reqActionDate);
//		System.out.println(reimbursementRequest);
		Cookie c[]=request.getCookies();
		
		for(int i=0;i<c.length;i++)
		{
			System.out.println(c[i].getName()+" "+c[i].getValue());
		}
		String email=c[0].getValue();
		ReimbursementService reimbursementService = (ReimbursementService) new ReimbursementServiceImpl();
		boolean getStatus = reimbursementService.addReimbursementRequestDetails(reimbursementModel,email);
		System.out.println(getStatus);
		if(getStatus)
		{
			response.sendRedirect("http://localhost:8080/ERS_Application/ReimbursementSuccess.html");
		}
		
	}

}
