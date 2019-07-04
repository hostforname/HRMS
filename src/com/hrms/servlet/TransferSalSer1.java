package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.DepartDao;
import com.hrms.dao.SalDao;



public class TransferSalSer1 extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try{
			String yearmo=request.getParameter("txtYearMo").trim();
			SalDao sdao= new SalDao();
			sdao.selectYearMo(yearmo);
			request.setAttribute("yearmo", yearmo);
			request.getRequestDispatcher("salary.jsp").forward(request, response);	
			
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
			
	}
}
