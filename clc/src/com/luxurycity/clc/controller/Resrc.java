package com.luxurycity.clc.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet({"/css/*","/js/*","/img/*"})
public class Resrc extends HttpServlet {
	/*
		css �뙆�씪�쓣 �슂泥��븯�뒗 寃쎌슦
			/css/w3.css
			/css/cls.css
			/css/member/member.css
	 */
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		String url = req.getRequestURI();
		// 파일 경로 : /WEB-INF/resources/css/member/member.css
		
		
		url = url.substring(url.indexOf("/", 1));
		// 요청 경로 ==> /jspcls/css/member/member.css
		//		==> /css/member/member.css
		
//		String spath = url.substring(0, url.indexOf('/', 1));
		// ==> /css	|| /js	|| /img
		
		/*
			css 파일 : /WEB-INF/resources/css/XXXXX
			js 파일 	: /WEB-INF/resources/js/XXXX
			img 파일	: /WEB-INF/resources/img/XXXXX
		 */
		
//		url = url.substring(url.indexOf(spath + "/"));
		
		String view = "/WEB-INF/resources" + url;
		
//		System.out.println("url : " + url);
//		System.out.println("view : " + view);
		// 요청파일을 알아냈으니 응답해준다.
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}