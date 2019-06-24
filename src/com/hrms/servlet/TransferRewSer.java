package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TransferRewSer extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer rewid=Integer.parseInt(request.getParameter("rewid").trim());
		String rewtl=request.getParameter("rewtl").trim();
		Integer rewty=Integer.parseInt(request.getParameter("rewty").trim());
		Integer rewmo=Integer.parseInt(request.getParameter("rewmo").trim());
		String rewtm=request.getParameter("rewtm").trim();
		String rewdi=request.getParameter("rewdi").trim();
		
		//System.out.println(depre);
		request.setAttribute("rewid", rewid);
		request.setAttribute("rewtl", rewtl);
		request.setAttribute("rewty", rewty);
		request.setAttribute("rewmo", rewmo);
		request.setAttribute("rewtm", rewtm);
		request.setAttribute("rewdi", rewdi);
		
		//System.out.println(request.getAttribute("recst"));

		request.getRequestDispatcher("rewInfo.jsp").forward(request, response);		
	}
}
