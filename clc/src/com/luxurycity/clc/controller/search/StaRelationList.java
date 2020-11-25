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

public class StaRelationList implements ClcMain {

	@Override

	public String exec(HttpServletRequest req, HttpServletResponse resp){
		resp.setContentType("text/html;charset=utf-8");
    	try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		SearchDAO sDAO =new SearchDAO();
		ArrayList<StationVO> list = sDAO.getstaCheck(req.getParameter("name"));
		

		buff.append("{ \"searchList\":[");
		for(int i = 0 ; i < list.size(); i++) {
			if(i < list.size()-1) {
				buff.append("{"+"\"id\":\""+list.get(i).getStation_id()+"\""+ ",");						
				buff.append("\"name\":\""+list.get(i).getStation_nn()+"\""+ "}"+ ",");								
			}else {
				buff.append("{"+"\"id\":\""+list.get(i).getStation_id()+"\""+ ",");							
				buff.append("\"name\":\""+list.get(i).getStation_nn()+"\""+ "}"+"],\"memberCount\":"+ list.size());														
			}
		}
		buff.append("}");
		System.out.println(buff.toString());
		return buff.toString();
	}

}
