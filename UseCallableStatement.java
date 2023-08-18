package day0818;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;

import kr.co.sist.dao.DbConn;

public class UseCallableStatement {
	public UseCallableStatement ( int num1, int num2)throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CallableStatement cstmt = null;
		DbConn db = DbConn.getInstance();
		
		try { 
			
			//1
			//2
			
			con= db.getConnection("localhost", "scott", "tiger");
			//3 쿼리문 생성객체 얻기
			cstmt = con.prepareCall("{call plus_proc(?,?, ?,?)}");
			//4 바인드 변수에 값 설정
			//out parameter : registerOutParameter method를 사용하여 값을 저장할
			//변수를 만든다. => oracle bind 변수 등록
			cstmt.setInt(1, num1);
			cstmt.setInt(2, num2);
			cstmt.registerOutParameter(3, Types.NUMERIC);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			//5. 쿼리 수행 후 결과 얻기
			cstmt.execute();
			//6. 아웃풋 파라미터 설정된 값 얻기
			int result=0;
			String msg = "";
			result =cstmt.getInt(3);//registerOutParameter(3,의 값을 얻는다.
			msg=cstmt.getString(4);//registerOutParameter(4,의 값을 얻는다.
			System.out.println(msg);
			System.out.println(num1+" + "+num2+" = "+result);
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}
		//1
		
		//2
		//3
		//4
		//5
		//6
		//7
		
	}
	public static void main(String[] args) {
		try {
			Random r = new Random();
			int num1= r.nextInt(10);
			int num2= r.nextInt(10);
			new UseCallableStatement(num1,num2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
