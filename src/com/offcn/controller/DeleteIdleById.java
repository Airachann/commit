package com.offcn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;

@WebServlet(urlPatterns="/DeleteIdleById")
public class DeleteIdleById extends HttpServlet {
	
	IdleService is = new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = is.deleteIdleById(request, response);
		if(n>0){
			request.getRequestDispatcher("QueryIdle").forward(request, response);
		}else{
			System.out.println("É¾³ýÊ§°Ü");
		}
	}
	

}
