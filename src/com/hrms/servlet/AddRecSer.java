package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.RecDao;

public class AddRecSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String recna=request.getParameter("txtRecNa").trim();
		String recse=request.getParameter("txtRecSe").trim();
		String recty=request.getParameter("txtRecTy").trim();
		String reced=request.getParameter("txtRecEd").trim();
		String recwe=request.getParameter("txtRecWe").trim();
		String recdi=request.getParameter("txtRecDi").trim();		
		if(recna==""||recse==""||recty==""||reced=="") {
			response.sendRedirect("addRecInfo.jsp?error=nonull");
		}else {
			RecDao rdao=new RecDao();
			rdao.addRec(recna,recse,recty,reced,recwe,recdi);
			
			response.sendRedirect("recruit.jsp");		
		}
	}
}