package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;

public class BookDelProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/clc/member/mypage.clc";
	
		// 1. 세션에서 아이디값 얻어오고
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid == null) {
			// 세션이 끊어졌을 때 로그인 페이지로 이동하기로 한다.
			req.setAttribute("isRedirect", true);
			return "/clc/member/login.clc";
		}
		
		// 2. 삭제할 즐겨찾기의 밸류 값들을 얻어오고
		String[] values = req.getParameterValues("dellist");
		
		// 3. 정수형 배열로 변환하고
		int[] bmno = new int[values.length];
		for(int i = 0; i < values.length; i++) {
			bmno[i] = Integer.parseInt(values[i]);
		}
		
		// 4. dao 만들고
		BookmarkDAO bDAO = new BookmarkDAO();
		
		// 5. 삭제 작업 요청하고 결과 받고
		int cnt = 0;
		cnt = bDAO.delBookmark(bmno);
		
		// 5. 결과 출력하고
		System.out.println(cnt + " 개의 즐겨찾기 데이터 삭제");
		return view;
	}

}
