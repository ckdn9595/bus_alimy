package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import java.util.regex.*;

public class EditProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);
		StringBuffer buff = new StringBuffer();
		int cnt = 0;
		String result = "";
		// 1. 아이디 비번 값 가져오고
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		// 2. 한 번 더 정규식 검사 하고
		String pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$";
		boolean regex = Pattern.matches(pattern, spw);
		if(regex == false) {
			// 일치하지 않으면 NO 반환
			result = "NO";
			buff.append("{");
			buff.append("	\"result\":\"" + result + "\"");
			buff.append("}");
			return buff.toString();
		}
		// 3. dao 만들고
		FindDAO fDAO = new FindDAO();
		
		// 4. 데이터 보내고 결과 받고
		cnt = fDAO.pwEdit(spw, sid);
		if(cnt != 0) {
			result = "OK";
		} else {
			result = "NO";
		}
		buff.append("{");
		buff.append("	\"result\":\"" + result + "\"");
		buff.append("}");
		
		return buff.toString();
	}

}
