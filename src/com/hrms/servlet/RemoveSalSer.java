package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.SalDao;

public class RemoveSalSer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			Integer staid=Integer.parseInt(request.getParameter("staid"));
			String salcu=request.getParameter("salcu");
			
			SalDao sdao=new SalDao();
			sdao.removeSal(staid,salcu);
			
			response.sendRedirect("salary.jsp");
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
		
	}
}
