package com.offcn.controller.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
import com.sun.xml.internal.messaging.saaj.util.Base64;

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/InitMaiData")
public class InitMaiData extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		
		//出售中的数量
		String sql_chushouzhong = "SELECT COUNT(1) AS 'chushouzhong' FROM u_idle_info WHERE fk_fisher = "+uid+" AND transfer_state = '未交易'";
		//成交记录的数量
		String sql_chengjiaojilu = "SELECT COUNT(1) AS 'chengjiaojilu' FROM u_idle_info WHERE fk_fisher = "+uid+" AND transfer_state = '已交易'";
		
		BaseDao dao = new BaseDao();
		List<Map<String, Object>> list_chushouzhong = dao.executeQuery(sql_chushouzhong);
		List<Map<String, Object>> list_chengjiaojilu = dao.executeQuery(sql_chengjiaojilu);
		
		
		String chushouzhong = list_chushouzhong.get(0).get("chushouzhong")+"";
		String chengjiaojilu = list_chengjiaojilu.get(0).get("chengjiaojilu")+"";
		
		Map<String,String> initMaiMap = new HashMap<String, String>();
		initMaiMap.put("chushouzhong", chushouzhong);
		initMaiMap.put("chengjiaojilu",chengjiaojilu);
		
		String str = JSONArray.fromObject(initMaiMap).toString();
		response.getWriter().write(str);
		
	}
}
