package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.TraDao;

public class AddTraSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String traer=request.getParameter("txtTraEr").trim();
		String tratl=request.getParameter("txtTraTl").trim();
		String tratm=request.getParameter("txtTraTm").trim();
		String traad=request.getParameter("txtTraAd").trim();
		String tradi=request.getParameter("txtTraDi").trim();		
		
		TraDao tdao=new TraDao();
		tdao.addTra(traer,tratl,tratm,traad,tradi);
		
		response.sendRedirect("train.jsp");
	}
}