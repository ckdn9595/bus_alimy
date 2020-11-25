package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;
import java.util.*;

public class FindPage implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/FindPage";
		// 아이디 찾기인지 비번 찾기인지 구분하기 위한 파라미터를 가져온다.
		// 일단 로그인 작업이 완성이 안되었으므로 강제로 파라미터값을 주기로 한다.(추후 수정예정)
//		String type = req.getParameter("findType");
		String type="pwCk";
		req.setAttribute("TYPE", type);
		
		// 비번찾기 타입일 경우
		if(type.equals("pwCk")) {
			// dao 만들고
			FindDAO fDAO = new FindDAO();
			// 리스트 만들고 데이터 받고
			ArrayList<FindVO> list = fDAO.getQuestList();
			
			req.setAttribute("LIST", list);
		}
		return view;
	}

}
