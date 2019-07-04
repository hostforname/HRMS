package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.DepartDao;

public class AddDepSer extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
			if(request.getParameter("txtDep")=="") {
				response.sendRedirect("addDepInfo.jsp?error=nonull");
			}else {
				String dep=request.getParameter("txtDep").trim();
				String depre=request.getParameter("txtDepRe").trim();
							
				DepartDao ddao=new DepartDao();
				ddao.addDep(dep, depre);
				
				response.sendRedirect("department.jsp");
			}	
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
	}
}