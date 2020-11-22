package db;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author 이지우
 * @since 2020.11.14
 * @version v.1.1
 * 
 */
public class ClsDBCP {

	public DataSource ds;
	
	public ClsDBCP() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/TestDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
		Connection con = null;
		try {
			con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		return stmt;
		
	}
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return pstmt;
		
	}
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
				((Connection)o).close();
			}else if(o instanceof Statement) {
				((Statement)o).close();
			}else if(o instanceof PreparedStatement) {
				((PreparedStatement)o).close();
			}else if(o instanceof ResultSet) {
				((ResultSet)o).close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
