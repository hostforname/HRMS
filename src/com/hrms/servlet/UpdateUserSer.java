package com.hrms.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.UserDao;

public class UpdateUserSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String error=null;
		try {
			String name=request.getParameter("txtName").trim();
			String opwd=request.getParameter("txtOld").trim();
			String npwd=request.getParameter("txtNew").trim();
			String rnpwd=request.getParameter("txtReNew").trim();
			UserDao udao=new UserDao();		
			if(udao.isLogin(name,opwd)) {
				if(npwd.equals(rnpwd)) {
					udao.updatePwd(name,opwd,npwd);
					response.sendRedirect("home.jsp");
				}else {
					error="两次输出的密码不一致";
					request.setAttribute("error", error);
					request.setAttribute("name", name);
					request.getRequestDispatcher("updatePwdError.jsp").forward(request, response);
				}
			}else {
				error="你输入的旧密码错误";
				request.setAttribute("error", error);
				request.setAttribute("name", name);
				request.getRequestDispatcher("updatePwdError.jsp").forward(request, response);
			}
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}
	}
}
