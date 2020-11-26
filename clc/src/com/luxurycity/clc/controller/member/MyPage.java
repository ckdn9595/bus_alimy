package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;
import java.util.*;

public class MyPage implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/MyPage";
		BookmarkDAO bDAO = new BookmarkDAO();
		
		String sid = (String) req.getSession().getAttribute("SID");
		
		if(sid == null) {
			// 세션이 끊어졌을 때 로그인 페이지로 이동하기로 한다.
			req.setAttribute("isRedirect", true);
			return "/clc/member/login.clc";
		}
		
		// 버스 데이터 담을 list 만들고 데이터 받고
		ArrayList<BookmarkVO> bList = bDAO.getBusList(sid);
		
		// 정류소 데이터 담을 list 만들고
		ArrayList<BookmarkVO> sList = bDAO.getStationList(sid);
		
		
		// 리스트 뿌려주기
		req.setAttribute("BLIST", bList);
		req.setAttribute("SLIST", sList);
		return view;
	}

}
