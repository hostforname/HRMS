package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.RecDao;


public class UpdateRecSer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer recid=Integer.parseInt(request.getParameter("recid"));
		Integer recst=Integer.parseInt(request.getParameter("recst"));
		
		RecDao rdao=new RecDao();
		rdao.updateRecById(recid,recst);
		
		response.sendRedirect("recruit.jsp");
	}
}
