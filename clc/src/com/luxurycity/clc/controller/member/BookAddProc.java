package com.luxurycity.clc.controller.member;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.util.*;

public class BookAddProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);
		System.out.println("잘나오나요>>>>>>>>>>1");
		StringBuffer buff = new StringBuffer();
		String result = "";
		// 1. 세션에서 아이디값 얻어오고
		String sid = SessionUtil.procSession(req, resp);
		if(sid == null) {
			// 세션이 끊어졌을 때 로그인 페이지로 이동하기로 한다.
			req.setAttribute("isRedirect", true);
			return "/clc/member/login.clc";
		}
		System.out.println("잘나오나요>>>>>>>>>>2");
		
		// 2. 북마크태이블에 추가할 녀석의 정보를 가져온다.
		int addid = Integer.parseInt(req.getParameter("addid"));
		System.out.println("잘나오나요>>>>>>>>>>3" + addid);
		
		String type = req.getParameter("type");
		System.out.println("잘나오나요>>>>>>>>>>4" + type);
		
		// 4. dao 만들고
		BookmarkDAO bDAO = new BookmarkDAO();
		System.out.println(type);
		
		// 5. 어떤 녀석을 추가하라는건지 알아내고
		int cnt = 0;
		if(type.equals("bus")) {
			cnt = bDAO.AddBusMark(sid, addid);
		}else {			
			cnt = bDAO.AddStaMark(sid, addid);
		}
		
		if(cnt == 0) {
			// 이 경우는 테이블에 일치하는 메일이 없으므로 NO를 반환해준다.
			result = "NO";
			buff.append("{");
			buff.append("	\"result\":\"" + result + "\"");
			buff.append("}");
		} else {
		// 이 경우는 테이블에 일치하는 메일이 있는 경우이므로
		// 아이디를 가져온다.
			result = "OK";
			buff.append("{");
			buff.append("	\"result\":\"" + result + "\"");
			buff.append("}");
		}
		
		// 5. 결과 출력하고
		System.out.println(cnt + " 개의 즐겨찾기 데이터 추가");
		return buff.toString();
	}

}