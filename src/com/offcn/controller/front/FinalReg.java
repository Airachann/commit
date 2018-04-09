package com.offcn.controller.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

public class FinalReg extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("pwd");
		String phone = request.getSession().getAttribute("phone")+"";
	
		String sql = "";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			//注册成功，跳转跳转到登录页面
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
		}
	}

}
