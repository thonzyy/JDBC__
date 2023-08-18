package day0818;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConn;
import oracle.jdbc.OracleTypes;

public class UseCallableStatementSelect {
	
	public UseCallableStatementSelect ()throws SQLException {
		Connection con = null;
		CallableStatement cstmt= null;
		ResultSet rs= null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			//1
			//2
			con=db.getConnection("localhost", "scott", "tiger");
			//3
			cstmt = con.prepareCall("{call select_all_emp(?) }");
			//4
				//in parameter
				//out parameter
				cstmt.registerOutParameter(1, Types.REF_CURSOR);
//				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				//5
				cstmt.execute();
				//6
				rs=(ResultSet)cstmt.getObject(1);
				
				while (rs.next()) {
					System.out.print(rs.getInt("empno"));
					System.out.print(rs.getString("ename"));
					System.out.print(rs.getInt("sal"));
					System.out.println(rs.getString("hiredate"));
					
				}
			//5
			//6
			//7
		}finally {
			db.dbClose(rs, cstmt, con);
		}
	}
	public static void main(String[] args) {
			try {
				new UseCallableStatementSelect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
