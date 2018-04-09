package com.offcn.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.dao.BaseDao;
import com.sun.org.apache.bcel.internal.generic.IREM;

public class IdleService {

	BaseDao dao = new BaseDao();

	public int addIdle(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String name = request.getParameter("name");
		String presentation = request.getParameter("presentation");
		String unit = request.getParameter("unit");
		String amount = request.getParameter("amount");
		String location = request.getParameter("location");
		String purchasing_date = request.getParameter("purchasing_date");
		String original_price = request.getParameter("original_price");
		String transfer_price = request.getParameter("transfer_price");
		String transfer_mode = request.getParameter("transfer_mode");
		String percentage = request.getParameter("percentage");
		String fk_idletype = request.getParameter("fk_idletype");

		String idleimg = saveImg(request, response);
		
		String sql = " INSERT INTO u_idle_info "
				+ "(NAME,idleimg,presentation,unit,amount,location,purchasing_date,original_price,transfer_price,transfer_mode,transfer_state,percentage,fk_idletype,uidle_state,create_date)  "
				+ " VALUES " + " ('" + name + "', '"+idleimg+"' , '" + presentation + "','" + unit + "'," + amount + ",'" + location
				+ "','" + purchasing_date + "'," + original_price + "," + transfer_price + ",'" + transfer_mode
				+ "','δ����','" + percentage + "'," + fk_idletype + ",'����',CURRENT_DATE()) ";

		int n = new BaseDao().executeUpdate(sql);

		return n;
	}

	public List<Map<String, Object>> queryIdleList() {
		String sql = "SELECT * FROM u_idle_info";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}

	public int deleteIdleById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String sql = "DELETE FROM u_idle_info WHERE id = " + id + "";

		int n = dao.executeUpdate(sql);
		return n;
	}
	
	/**
	 * �����û���������֣�����ģ����ѯ
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String,Object>> queryIdleByLike(HttpServletRequest request, HttpServletResponse response){
		String idlename = request.getParameter("idlename");
		String sql = "SELECT * FROM u_idle_info WHERE NAME LIKE '%"+idlename+"%'";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}
	
	/**
	 * ���û��ϴ���ͼƬ���浽webroot/idleimg�ļ��У�����ͼƬ����yyyyMMddhhmmss���������շ��������ļ���
	 * @return
	 */
	public String saveImg(HttpServletRequest request, HttpServletResponse response){
		Part part = null;
		try {
			//1.��ȡ�û��ϴ�ͼƬ��Ӧ��part����
			part = request.getPart("idleimg");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		//2.��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sf.format(date);
		
		//3.��ȡ�û��ϴ���ͼƬ�ĺ�׺
		String cd = part.getHeader("Content-Disposition");
		//form-data; name="idleimg"; filename="20171108083623.jpg"
		String houzui = cd.substring(cd.lastIndexOf("."), cd.length()-1);
		String fileName = str+houzui;
		
		//4.��ͼƬ����,�������ɵ��ļ���
		try {
			//D:\apache-tomcat-9.0.0.M21\webapps\offcn_idle_sys\idleimg
			String realPath = request.getServletContext().getRealPath("/idleimg")+"\\"+fileName;
			part.write(realPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
	

}