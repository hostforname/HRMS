package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TransferDepSer extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String depid=request.getParameter("depid");
			String dep=request.getParameter("dep");
			String depct=request.getParameter("depct");
			String depre=request.getParameter("depre");
			
			request.setAttribute("depid", depid);
			request.setAttribute("dep", dep);
			request.setAttribute("depct", depct);
			request.setAttribute("depre", depre);

			request.getRequestDispatcher("updateDep.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
				
	}
}
