package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TransferRecSer extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer recid=Integer.parseInt(request.getParameter("recid"));
		String recna=request.getParameter("recna");
		String recse=request.getParameter("recse");
		String recty=request.getParameter("recty");
		String reced=request.getParameter("reced");
		String recwe=request.getParameter("recwe");
		
		//System.out.println(depre);
		request.setAttribute("recid", recid);
		request.setAttribute("recna", recna);
		request.setAttribute("recse", recse);
		request.setAttribute("recty", recty);
		request.setAttribute("reced", reced);
		request.setAttribute("recwe", recwe);

		request.getRequestDispatcher("recInfo.jsp").forward(request, response);		
	}
}
