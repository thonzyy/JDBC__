package day0821;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import kr.co.sist.dao.DbConn;

/**
 * Procedure를 사용한 부서 사원정보 조회
 * @author USER
 */
public class UseProcedureSelectEmp {

	public UseProcedureSelectEmp(int deptno) throws SQLException{
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		DbConn dc = DbConn.getInstance();
		
		try {	
		// 1. 드라이버 로딩
		// 2. 커넥션 얻기
			con = dc.getConnection("localhost", "scott", "tiger");
		
		// 3.
			cstmt = con.prepareCall("{ call select_dept_emp(?, ?)}");
			
		// 4.
			// in parameter
			cstmt.setInt(1, deptno); 
			
			// out parameter
			cstmt.registerOutParameter(2, Types.REF_CURSOR);
		
		// 5.
			cstmt.execute();
			
		// 6.
			rs = (ResultSet)cstmt.getObject(2);
			
			System.out.println( deptno + "번 부서 정보 조회");
			
			while(rs.next()) {
				System.out.println(rs.getInt("deptno") + " / " + rs.getString("dname") + " / " + rs.getString("loc") + " / " 
								+ rs.getInt("empno") + " / " + rs.getString("ename") + " / " + rs.getInt("sal"));
			}
			
		}finally{
			// 7. 연결 끊기
			dc.dbClose(rs, cstmt, con);
		}
	}//UseProcedureSelectEmp
	
	public static void main(String[] args) {
		try {
			String inputDeptno = JOptionPane.showInputDialog("부서번호 입력");
			
			new UseProcedureSelectEmp(Integer.parseInt(inputDeptno));
			
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
