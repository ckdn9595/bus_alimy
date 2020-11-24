package com.luxurycity.clc.controller.search;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RelationList implements ClcMain {

	@Override

	public String exec(HttpServletRequest req, HttpServletResponse resp){
		resp.setContentType("text/html;charset=utf-8");
    	try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("teststet");
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		SearchDAO sDAO =new SearchDAO();
		ArrayList<RouteVO> list = sDAO.getBusCheck(req.getParameter("name"));
		
//		String result = "YES";
//		
//		if(list.size()==0) {
//			result = "NO";
//		}
		buff.append("{ \"searchList\":[");
//		buff.append("  \"result\":\""+result+"\" ");
		for(int i = 0 ; i < list.size(); i++) {
			if(i < list.size()-1) {
				buff.append("{"+"\"name\":\""+list.get(i).getRoute_nm()+"\""+ ",");				
				buff.append("\"type\":\""+list.get(i).getRoute_tp()+"\""+ "}"+ ",");								
			}else {
				buff.append("{"+"\"name\":\""+list.get(i).getRoute_nm()+"\""+ ",");				
				buff.append("\"type\":\""+list.get(i).getRoute_tp()+"\""+ "}"+"],\"memberCount\":"+ list.size());
																		
			}
		}
		buff.append("}");
		System.out.println(buff.toString());
		return buff.toString();
	}

}
