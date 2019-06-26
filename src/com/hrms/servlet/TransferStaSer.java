package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TransferStaSer extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer staid=Integer.parseInt(request.getParameter("staid"));
		String stana=request.getParameter("stana");
		String stase=request.getParameter("stase");
		String stade=request.getParameter("stade");
		String stawty=request.getParameter("stawty");
		String staed=request.getParameter("staed");
		String stawtm=request.getParameter("stawtm");
		
		//System.out.println(stade);
		request.setAttribute("staid", staid);
		request.setAttribute("stana", stana);
		request.setAttribute("stase", stase);
		request.setAttribute("stade", stade);
		request.setAttribute("stawty", stawty);
		request.setAttribute("staed", staed);
		request.setAttribute("stawtm", stawtm);

		request.getRequestDispatcher("updateSta.jsp").forward(request, response);		
	}
}
