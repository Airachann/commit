package com.offcn.controller.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

@WebServlet(urlPatterns="/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取当前商品信息id
		String id = request.getParameter("id");
		String sql = "SELECT * FROM u_idle_info WHERE id = "+id+"";
		Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
		
		//2.将map带到新页面显示（确认订单）
		request.setAttribute("imap",map);
		request.getRequestDispatcher("front/confirm.jsp").forward(request, response);
		
	}

}
