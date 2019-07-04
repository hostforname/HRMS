package com.hrms.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.DepartDao;

public class UpdateDepSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			Integer depid=Integer.parseInt(request.getParameter("txtDepId").trim());
			String dep=request.getParameter("txtDep").trim();
			String depre=request.getParameter("txtDepRe").trim();
			
			DepartDao ddao=new DepartDao();		
			ddao.updateDepById(depid,dep,depre);
			response.sendRedirect("department.jsp");
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
		
		
	}
}
