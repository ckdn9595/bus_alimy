package com.luxurycity.clc.controller.member;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;

public class IdCheck implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		String sid = req.getParameter("id");
	
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.getIdCnt(sid);
		
		String result = "";
		if(cnt == 0) {
			result = "OK";
		} else {
			result = "NO";
		}
		
		buff.append("{");
		buff.append("	\"result\": \"" + result + "\"");
		buff.append("}");
		
		return buff.toString();
	}

}
