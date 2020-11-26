package com.luxurycity.clc.sql;

public class MemberSQL {
	public final int MEM_ID_CK = 1001;
	public final int MEM_LOGIN_CNT = 1002;
	public final int MEM_AVT_INFO = 1003;
	public final int MEM_QUE_INFO = 1004;
	public final int MEM_GET_MNO = 1005;
	public final int MEM_ID_CNT = 1006;
	public final int MEM_GET_AVT = 1007;
	
	public final int MEM_EDIT_MAIL = 2001;
	public final int MEM_EDIT_AVT = 2002;
	public final int MEM_INFO_DEL = 2003;
	
	public final int MEM_JOIN = 3001;
	public final int MEM_JOIN_FIND = 3002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case MEM_ID_CK:
			buff.append("SELECT COUNT(*) cnt ");
			buff.append("FROM MEMBER ");
			buff.append("WHERE  id = ? and isshow = 'Y' ");
			break;
		case MEM_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
			buff.append("    AND pw = ? ");
			buff.append("    AND isshow = 'Y' ");
			break;
		case MEM_AVT_INFO:
			buff.append("SELECT ");
			buff.append("    ano, afile, dir, gen ");
			buff.append("FROM ");
			buff.append("    avatar ");
			break;
		case MEM_QUE_INFO:
			buff.append("SELECT ");
			buff.append("	qno, quest ");
			buff.append("FROM ");
			buff.append("	quest ");
			buff.append("ORDER BY ");
			buff.append("	qno ASC ");
			break;
		case MEM_GET_MNO:
			buff.append("SELECT ");
			buff.append("    mno ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
			break;
		case MEM_ID_CNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case MEM_GET_AVT:
			buff.append("SELECT ");
			buff.append("    afile, dir, m.ano, mail ");
			buff.append("FROM ");
			buff.append("    avatar a, member m ");
			buff.append("WHERE ");
			buff.append("    a.ano = m.ano ");
			buff.append("    AND id = ? ");
			break;
		case MEM_JOIN:
			buff.append("INSERT INTO ");
			buff.append("	member(mno, id, pw, name, mail, gen, ano) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(mno) + 1, 1001) FROM member), ");
			buff.append(" ?, ?, ?, ?, ?, ?) ");
			break;
		case MEM_EDIT_MAIL:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	mail = ? ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case MEM_EDIT_AVT:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	afile = ?, ");
			buff.append("	dir = ?, ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case MEM_INFO_DEL:
			buff.append("UPDATE ");
			buff.append("    member ");
			buff.append("SET ");
			buff.append("    isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("    mno = ? ");
			buff.append("    AND pw = ? ");
			break;
		case MEM_JOIN_FIND:
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
