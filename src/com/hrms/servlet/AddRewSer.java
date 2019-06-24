package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.RewDao;

public class AddRewSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String rewtl=request.getParameter("txtRewTl").trim();
		Integer rewty;
		if(request.getParameter("txtRewTy").trim().equals("½±Àø")) {
			rewty=1;
		} else {
			rewty=0;
		}
		Integer rewmo=Integer.parseInt(request.getParameter("txtRewMo").trim());
		String rewdi=request.getParameter("txtRewDi").trim();	
		
		
		
		RewDao rdao=new RewDao();
		rdao.addRew(rewtl,rewty,rewmo,rewdi);
		
		response.sendRedirect("rewpun.jsp");
	}
}