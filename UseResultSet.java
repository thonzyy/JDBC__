package day0814;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import kr.co.sist.statement.DBConnection;

public class UseResultSet {
	
	public UseResultSet() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBConnection db = new DBConnection();
		
		//1 . 로딩 얻기
		try { 
			
			con=db.getConn();//커넥션 얻기
			stmt=con.createStatement();// 쿼리문 생성 객체 얻기
			//4. 쿼리문 실행 후 결과 얻기
			
			String select = "select empno, ename, hiredate , 2023.08 temp, to_char(hiredate,'mm-dd-yyyy') hire  from emp";
			rs=stmt.executeQuery(select);
			
			//조회 결과가 있다면 반복시켜 모두 가져온다.
			//rs에 커서의 제어권이 저장돼있다.
			int empno = 0;
			String ename = "";
			Date date = null;;
			String hire = "";
			double temp = 0.0;
			SimpleDateFormat sdf= new SimpleDateFormat("MM-dd-yyyy");
			
			while (rs.next()) {
				//empno=rs.getInt(1);
				//컬럼인덱스는 어떤 값을 얻는지 알 수가 없다.
				empno= rs.getInt("empno");
				//컬럼명은 어떤 값을 얻는지 알 수 있다.
				ename = rs.getString("ename");
				date = rs.getDate("hiredate");//내가 원하는 날짜 형식으로 출력을 하고 싶다.
				temp = rs.getDouble("temp");
				hire=rs.getString("hire");
				System.out.println(empno+" / "+ename+" / "+sdf.format(date)+" / "+temp+ " / " +hire );
				
			}
			
		}finally { db.closeDB(rs, stmt, con);}

	}//UseResultSet

	public static void main(String[] args) {
		try {
			new UseResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}//main

}//class
