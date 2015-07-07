package com.lolo.utils.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.lolo.utils.utils.Base64Utils;

@Controller
@RequestMapping("/utils")
public class UtilsController {
	
	

	@RequestMapping(value = "/zip",  produces = { "application/json;charset=UTF-8" })
	public void zip(@RequestParam String content,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response){
		try {
			JSONObject json = new JSONObject();
			//对内容进行转换
			if(StringUtils.isNotBlank(content)){
				json.put("success", true);
				String code = Base64Utils.zip(content);
				json.put("data", code);
				System.out.println("result:" + json.toString());
			}else{
				json.put("success", false);
			}
			String result = json.toString();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
			response.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/gzip",  produces = { "application/json;charset=UTF-8" })
	public void gzip(@RequestParam String content,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response){
		try {
			JSONObject json = new JSONObject();
			//对内容进行转换
			if(StringUtils.isNotBlank(content)){
				json.put("success", true);
				String code = Base64Utils.gzip(content);
				json.put("data", code);
				System.out.println("result:" + json.toString());
			}else{
				json.put("success", false);
			}
			String result = json.toString();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
			response.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/base64",  produces = { "application/json;charset=UTF-8" })
	public void base64(@RequestParam String content,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response){
		try {
			JSONObject json = new JSONObject();
			//对内容进行转换
			if(StringUtils.isNotBlank(content)){
				json.put("success", true);
				//zip
				//String code = Base64Utils.zip(content);
				//base64
				String code = Base64Utils.base64(content);
				json.put("data", code);
				System.out.println("result:" + json.toString());
			}else{
				json.put("success", false);
			}
			String result = json.toString();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
			response.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
