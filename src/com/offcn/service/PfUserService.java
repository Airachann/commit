package com.offcn.service;

import java.util.List;
import java.util.Map;

import com.offcn.dao.BaseDao;

public class PfUserService {
	
	
	public List<Map<String, Object>> queryPfUserList(){
		String sql = "SELECT * FROM u_idle_user";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		return list;
	}

}
