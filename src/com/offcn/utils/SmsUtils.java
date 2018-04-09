package com.offcn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SmsUtils {
	
	private static String x_id = "diy";
	private static String x_pwd = "liumeng1234567890";

	
	public static String SendSms(String mobile) throws UnsupportedEncodingException {
		
		//生成6位随机验证码
		String verification_code = getRandNum();
		//短信模板
		String content = "你的验证码是:"+verification_code;
		
		HttpURLConnection httpconn = null;
		StringBuilder sb = new StringBuilder();
		sb.append("http://service.winic.org:8009/sys_port/gateway/index.asp?");

		// 以下是参数
		// 为了你的测试方便收到短信！请短信内容编辑为：你的验证码为：123456【中正云通信】
		sb.append("id=").append(URLEncoder.encode(x_id, "gb2312"));
		sb.append("&pwd=").append(x_pwd);
		sb.append("&to=").append(mobile);
		sb.append("&content=").append(URLEncoder.encode(content, "gb2312"));
		sb.append("&time=").append("");
		try {
			URL url = new URL(sb.toString());
			httpconn = (HttpURLConnection) url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
			rd.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpconn != null) {
				httpconn.disconnect();
				httpconn = null;
			}
		}
		return verification_code;
	}

	public static String getRandNum() {
		int randNum = 1 + (int) (Math.random() * ((999999 - 1) + 1));
		return randNum + "";
	}

}
