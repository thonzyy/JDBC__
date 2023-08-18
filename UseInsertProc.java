package day0818;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConn;
import kr.co.sist.statement.DBConnection;

public class UseInsertProc {
	private int deptno;
	private String dname, loc;
	
	public UseInsertProc (CpDeptVO cdVO)throws SQLException {
		Connection con =null;
		CallableStatement cstmt = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			//1
			//2
			con=db.getConnection("localhost", "scott", "tiger");
			cstmt = con.prepareCall("{call insert_proc(?,?,?,?,?)}");
			//4 바인드 변수 값 설정
			//in parameter
			cstmt.setInt(1,cdVO.getDeptno());
			cstmt.setString(2,cdVO.getDname());
			cstmt.setString(3,cdVO.getLoc());
			
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
			cstmt.execute();
			int cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5); 
			//out parameter 
			System.out.println(cnt+" / "+msg);
		}finally {
			db.dbClose(null, cstmt, con);
		}
		
	}

	public static void main(String[] args) {
try {
	CpDeptVO cdVO = new CpDeptVO("SI","서울",2);
	new UseInsertProc(cdVO);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
