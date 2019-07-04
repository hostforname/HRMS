package com.hrms.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.StaDao;

public class UpdateStaSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			Integer staid=Integer.parseInt(request.getParameter("txtStaId").trim());
			String stana=request.getParameter("txtStaNa").trim();
			String stase=request.getParameter("txtStaSe").trim();
			String stade=request.getParameter("txtStaDe").trim();
			String stawty=request.getParameter("txtStaWTy").trim();
			String staed=request.getParameter("txtStaEd").trim();
			String stawtm=request.getParameter("txtStaWTm").trim();
			
			StaDao sdao=new StaDao();		
			sdao.updateStaById(staid,stana,stase,stade,stawty,staed,stawtm);
			
			response.sendRedirect("staff.jsp");
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
		
		
	}
}
