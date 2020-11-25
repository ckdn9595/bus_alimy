package com.luxurycity.clc.controller.board;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class WriteProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/board/board.clc";
		
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		String body = (String) req.getAttribute("body");
		
		BoardVO bVO = new BoardVO();
		bVO.setSid(sid);
		bVO.setBody(body);
		
		BoardDao bDao = new BoardDao();
		int cnt = bDao.addBoard(bVO);
		
		System.out.println(cnt + "의 게시글이 추가되었습니다.");
		req.setAttribute("isRedirect", true);
		return view;
	}

}
