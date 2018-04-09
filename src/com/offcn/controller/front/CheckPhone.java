package com.offcn.controller.front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

@WebServlet(urlPatterns="/CheckPhone")
public class CheckPhone extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		request.getSession().setAttribute("phone",phone);
		//校验该手机号是否已经被注册过
		String sql = "SELECT 1 FROM u_idle_user WHERE u_phonenum = '"+phone+"'";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		if(list!=null&&list.size()>0){
			//说明该手机号已经被注册过了
			response.getWriter().write("no");
		}else{
			//可以正常注册
			response.getWriter().write("yes");
		}
	}

}
