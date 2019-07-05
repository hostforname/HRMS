package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.UserDao;

public class AddUserSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String usena=request.getParameter("txtUseNa").trim();
			String usepwd=request.getParameter("txtUsePwd").trim();
			if(usena==""||usepwd=="") {
				response.sendRedirect("addUser.jsp?error=nonull");
			}else {

				UserDao udao=new UserDao();
				udao.addUser(usena,usepwd);
				
				response.sendRedirect("user.jsp");
			
			}
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
	}
}