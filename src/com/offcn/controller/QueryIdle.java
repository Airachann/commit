package com.offcn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.IdleService;

@WebServlet(urlPatterns="/QueryIdle")
public class QueryIdle extends HttpServlet {
	
	IdleService service = new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Map<String, Object>> list = service.queryIdleList();
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("module_idle/idleList.jsp").forward(request, response);
		
	}

}
