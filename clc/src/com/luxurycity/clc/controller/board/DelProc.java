package com.luxurycity.clc.controller.board;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;

public class DelProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/board/board.clc";
		
		String sno = (String) req.getAttribute("bno");
		int bno = 0;
		try {
			bno = Integer.parseInt(sno);
			
		} catch(Exception e) {}
		
		BoardDao bDao = new BoardDao();
		
		int cnt = bDao.delBoard(bno);

		
		System.out.println(cnt + " 개의 게시글이 삭제되었습니다.");
		

		req.setAttribute("isRedirect", true);
		return view;
	}

}
