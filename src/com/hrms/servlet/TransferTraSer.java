package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TransferTraSer extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
			Integer traid=Integer.parseInt(request.getParameter("traid").trim());
			String traer=request.getParameter("traer").trim();
			String tratl=request.getParameter("tratl").trim();
			String tratm=request.getParameter("tratm").trim();
			String traad=request.getParameter("traad").trim();
			String tradi=request.getParameter("tradi").trim();
			
			request.setAttribute("traid", traid);
			request.setAttribute("traer", traer);
			request.setAttribute("tratl", tratl);
			request.setAttribute("tratm", tratm);
			request.setAttribute("traad", traad);
			request.setAttribute("tradi", tradi);
			
			request.getRequestDispatcher("traInfo.jsp").forward(request, response);	
			
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
			
	}
}
