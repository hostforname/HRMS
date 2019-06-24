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
		Integer recid=Integer.parseInt(request.getParameter("recid").trim());
		String recna=request.getParameter("recna").trim();
		String recse=request.getParameter("recse").trim();
		String recty=request.getParameter("recty").trim();
		String reced=request.getParameter("reced").trim();
		String recwe=request.getParameter("recwe").trim();
		String recdi=request.getParameter("recdi").trim();
		Integer recst=Integer.parseInt(request.getParameter("recst").trim());
		
		//System.out.println(depre);
		request.setAttribute("recid", recid);
		request.setAttribute("recna", recna);
		request.setAttribute("recse", recse);
		request.setAttribute("recty", recty);
		request.setAttribute("reced", reced);
		request.setAttribute("recwe", recwe);
		request.setAttribute("recdi", recdi);
		request.setAttribute("recst", recst);
		
		//System.out.println(request.getAttribute("recst"));

		request.getRequestDispatcher("recInfo.jsp").forward(request, response);		
	}
}
