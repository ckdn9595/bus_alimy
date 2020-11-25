package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
public class FindIdPageProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);
		StringBuffer buff = new StringBuffer();
		String result = "";
		String sid = "";
		
		// 1. 파라미터 꺼내오고
		String smail = req.getParameter("mail");
		// 2. Dao 만들고
		FindDAO fDao = new FindDAO();
		
		// 3. 메일이 존재하는지 확인하고
		int cnt = 0;
		cnt = fDao.idCount(smail);
		
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
			sid = fDao.findId(smail);
			buff.append("{");
			buff.append("	\"id\":\"" + sid + "\",");
			buff.append("	\"result\":\"" + result + "\"");
			buff.append("}");
		}
		
		return buff.toString();
	}

}
