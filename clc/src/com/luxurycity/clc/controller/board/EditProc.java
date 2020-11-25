package com.luxurycity.clc.controller.board;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class EditProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/board/board.clc";
		
		// 파라미터 뽑기
		String sno = (String)req.getAttribute("bno");
		String body = (String)req.getAttribute("body");
		int bno = 0;
		try {
			bno = Integer.parseInt(sno);
		} catch(Exception e) {}
		
		BoardDao bDao = new BoardDao();
		BoardVO bVO = new BoardVO();
		bVO.setBody(body);
		bVO.setBno(bno);
		
		int cnt = bDao.editBoard(bVO);
		
		System.out.println(cnt + " 개의 게시글이 수정되었습니다.");
		req.setAttribute("isRedirect", true);
		return view;
	}

}
