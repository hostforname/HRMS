package com.hrms.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.dao.SalDao;

public class AddSalSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			if(request.getParameter("txtStaId")==""||request.getParameter("txtStaNa")==""||request.getParameter("txtSalBa")=="") {
	        	response.sendRedirect("addSalInfo.jsp?error=nonull");
			}else {
				Integer staid=Integer.parseInt(request.getParameter("txtStaId").trim());
				String stana=request.getParameter("txtStaNa").trim();
				//获取当前时间的年月
				Calendar cal = Calendar.getInstance();       
		        int month = cal.get(Calendar.MONTH) + 1;
		        int year = cal.get(Calendar.YEAR);
		        String salcu=year+"-"+month;
		        
				Integer salba=Integer.parseInt(request.getParameter("txtSalBa").trim());
				Integer salov=Integer.parseInt(request.getParameter("txtSalOv").trim());
				Integer saldu=Integer.parseInt(request.getParameter("txtSalDu").trim());
				Integer salat=Integer.parseInt(request.getParameter("txtSalAt").trim());
				Integer salab=Integer.parseInt(request.getParameter("txtSalAb").trim());
				Integer salin=Integer.parseInt(request.getParameter("txtSalIn").trim());
				
				
				SalDao sdao=new SalDao();
				sdao.addSal(staid,stana,salcu,salba,salov,saldu,salat,salab,salin);
				
				response.sendRedirect("salary.jsp");
			}		
		}catch(Exception e) {
			response.sendRedirect("error.html");
		}

		
	}
}