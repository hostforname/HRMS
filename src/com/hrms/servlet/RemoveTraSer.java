package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.TraDao;

public class RemoveTraSer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer traid=Integer.parseInt(request.getParameter("traid"));
		
		TraDao tdao=new TraDao();
		tdao.removeTraById(traid);
		
		response.sendRedirect("train.jsp");
	}
}
