package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class FindPwPageProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);
		StringBuffer buff = new StringBuffer();
		String result = "";
		// 1. 데이터 가져오고
		String sid = req.getParameter("id");
		String sqno = req.getParameter("qno");
		String sanswer = req.getParameter("answer");

		int qno = Integer.parseInt(sqno);
		
		// 2. dao 만들고
		FindDAO fDAO = new FindDAO();
		
		// 3. 데이터 받고
		int cnt = 0;
		cnt = fDAO.pwCheck(sid, qno, sanswer);
//		System.out.println(cnt);
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
