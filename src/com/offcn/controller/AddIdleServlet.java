package com.offcn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;

@WebServlet(urlPatterns="/AddIdleServlet")
@MultipartConfig
public class AddIdleServlet extends HttpServlet {
	
	IdleService idleService = new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = idleService.addIdle(request, response);
		if(n>0){
			System.out.println("添加成功");
			request.getRequestDispatcher("QueryIdle").forward(request, response);
		}else{
			System.out.println("添加失败");
		}
	}
	

}
