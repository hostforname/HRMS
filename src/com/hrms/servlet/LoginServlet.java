package com.hrms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.UserDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException { }
	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			
			String name=request.getParameter("txtName").trim();
			String password=request.getParameter("txtPwd").trim();
			UserDao udao=new UserDao();
			if(udao.isLogin(name, password)){
				request.setAttribute("name", name);
				request.getRequestDispatcher("hrmshome.jsp").forward(request, response);
			}else{
				response.sendRedirect("loginerror.html");
			}
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
		
	}
}
