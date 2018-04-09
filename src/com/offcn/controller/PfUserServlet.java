package com.offcn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.PfUserService;

@WebServlet(urlPatterns="/PfUserServlet")
public class PfUserServlet extends HttpServlet {
	
	PfUserService ps = new PfUserService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = ps.queryPfUserList();
		request.setAttribute("list",list);
		request.getRequestDispatcher("module_pfuser/pfuserlist.jsp").forward(request, response);
	}

}
