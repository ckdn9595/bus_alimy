package com.luxurycity.clc.dispatch;

import javax.servlet.*;
import javax.servlet.http.*;


import com.luxurycity.clc.controller.ClcMain;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class ClcDispatch extends HttpServlet{
	public HashMap<String, ClcMain> map;
	
	public void init(ServletConfig config) throws ServletException{
		
		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			String spath = this.getClass().getResource("").getPath();
			
			fin = new FileInputStream(spath + "../resources/ClcProperties.properties");
			prop.load(fin);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			}catch(Exception e) {
				System.out.println("fileinputStream 안닫힘..");
			}
		}
		map = new HashMap<String, ClcMain>();
		
		Set set = prop.keySet();
		ArrayList list = new ArrayList(set);
		for(Object o: list) {
			String skey = (String)o;
			
			String classPath = (String)prop.get(skey);
			
			try {
				Class tmp = Class.forName(classPath);
				ClcMain clc = (ClcMain)tmp.newInstance();
				
				map.put(skey, clc);
			}catch(Exception e) {}
		}
		
	}
	public void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String full = req.getRequestURI();

		String realPath = full.substring(full.indexOf('/', 1));
		
		// 3. 요청 내용에 맞는 실제 실행할 클래스를 가져온다.
		ClcMain clc = map.get(realPath);
		
		Boolean bool = null;
		/*
			bool == null	: 비동기 통신 처리
			bool == false	: forward
			bool == true	: redirect
		 */
		req.setAttribute("isRedirect", false);
		String view = clc.exec(req, resp);

		try {
			bool = (Boolean) req.getAttribute("isRedirect");
		} catch(Exception e) {}
		
		if(bool == null) {
			// 이경우는 비동기 통신이므로 반환되는 문자열을 응답문서로 만들어준다.
			PrintWriter pw = resp.getWriter();
			pw.print(view);
		} else if(bool) {
			// 리다이렉트 시켜야 하는 경우
			resp.sendRedirect(view);
		} else if(!bool) {


			String prefix = "/WEB-INF/views/com/luxurycity/clc/";
			String surffix = ".jsp";
			RequestDispatcher rd = req.getRequestDispatcher( prefix + view + surffix);
			rd.forward(req, resp);
		}
		
	}
}
