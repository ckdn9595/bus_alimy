package com.luxurycity.clc.sql;

public class BoardSQL {
	public final int ADD_BOARD = 1001;
	
	public final int DEL_BOARD = 2001;
	
	public final int EDIT_BOARD = 3001;
	
	public final int SEL_BOARD_LIST = 4001;
	public final int SEL_BOARD_CNT = 4002;
	
	public String getSQL(int code) {
		StringBuilder builder = new StringBuilder();
		
		switch(code) {
		case ADD_BOARD:
			builder.append("INSERT INTO ");
			builder.append("	board(bno, mno, body) ");
			builder.append("VALUES( ");
			builder.append("	(SELECT NVL(MAX(bno), 10000)+1 FROM board), ");
			builder.append("	(SELECT mno FROM member WHERE id = ? AND isshow = 'Y' ), ");
			builder.append("	? ");
			builder.append(") ");
			break;
		case DEL_BOARD:
			builder.append("UPDATE ");
			builder.append("	board ");
			builder.append("SET ");
			builder.append("	isshow = 'N' ");
			builder.append("WHERE ");
			builder.append("	bno = ? ");
			break;
		case EDIT_BOARD:
			builder.append("UPDATE ");
			builder.append("	board ");
			builder.append("SET ");
			builder.append("	body = ? ");
			builder.append("WHERE ");
			builder.append("	bno = ? ");
			break;
		case SEL_BOARD_LIST:
			builder.append("SELECT ");
			builder.append("	* ");
			builder.append("FROM ");
			builder.append("	(SELECT ");
			builder.append("		afile, id, wdate, body, bno, rownum rno ");
			builder.append("	FROM ");
			builder.append("		avatar a, member m, board b ");
			builder.append("	WHERE ");
			builder.append("		a.ano = m.ano ");
			builder.append("		AND m.mno = b.mno ");
			builder.append("	ORDER BY ");
			builder.append("		bno DESC) ");
			builder.append("WHERE ");
			builder.append("	rno BETWEEN ? AND ? ");
			break;
		case SEL_BOARD_CNT:
			builder.append("SELECT ");
			builder.append("	COUNT(*) cnt ");
			builder.append("FROM ");
			builder.append("	board ");
			break;
		}
		return builder.toString();
	}
}
