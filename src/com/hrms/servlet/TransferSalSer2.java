package com.hrms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.SalDao;



public class TransferSalSer2 extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idname=request.getParameter("IdName").trim();
		String[] array =idname.toString().split("->");
		//System.out.println(yearmo);
		Integer id=Integer.parseInt(array[0]);
		String name=array[1];
		SalDao sdao= new SalDao();
		sdao.selectIdName(id,name);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.getRequestDispatcher("salary.jsp").forward(request, response);		
	}
}
