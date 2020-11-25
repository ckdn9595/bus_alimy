package com.luxurycity.clc.sql;

public class FindSQL {
	public final int ID_COUNT = 1001;
	public final int FIND_ID = 1002;
	public final int SEL_QUEST_LIST = 1003;	
	public final int FIND_PW = 1004;
	public final int FIND_AVT = 1005;
	
	public final int EDIT_PW = 2001;
	
	public final int JOIN_FIND = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ID_COUNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	mail = ? ");
			break;
		case FIND_ID:
			buff.append("SELECT ");
			buff.append("    id ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    mail = ? ");
			break;
		case SEL_QUEST_LIST:
			buff.append("SELECT ");
			buff.append("    qno, quest ");
			buff.append("FROM ");
			buff.append("    quest ");
			break;
		case FIND_PW:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    find f, member m ");
			buff.append("WHERE ");
			buff.append("    f.mno = m.mno ");
			buff.append("    AND id = ? ");
			buff.append("    AND qno = ? ");
			buff.append("    AND answer = ? ");
			break;
		case FIND_AVT:
			buff.append("select ");
			buff.append("    dir, afile, id ");
			buff.append("from ");
			buff.append("    avatar a, member m ");
			buff.append("where ");
			buff.append("	a.ano = m.ano ");
			buff.append("	and id = ? ");
			break;
		case EDIT_PW:
			buff.append("UPDATE ");
			buff.append("    member ");
			buff.append("SET ");
			buff.append("    pw = ? ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
			break;
		case JOIN_FIND:
			buff.append("INSERT INTO ");
			buff.append("    find(fno, mno, qno, answer) ");
			buff.append("VALUES( ");
			buff.append("    ( ");
			buff.append("        SELECT NVL(MAX(fno) + 1, 1001) FROM find ");
			buff.append("    ), ");
			buff.append("    ?, ?, ?) ");
			break;
		}
		return buff.toString();
	}
}
