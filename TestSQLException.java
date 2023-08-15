package day0814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLException {
	
	public TestSQLException () throws SQLException {
		//1.드라이버 로딩된
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt = null;
		try {
		//2. 커넥션 얻기
			String url= "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			
			con= DriverManager.getConnection(url,id,pass);
		
		
		//3. 쿼리문 생성 객체 얻기
			stmt=con.createStatement();
		//4. 쿼리문 수행 후 결과 얻기
			int empno= 4323;
			int sal = 555555;
			String name="장용석";
			String sql =
					"insert into cp_emp3(empno,ename,sal,hiredate)values("+empno+",'"+name+"',"+sal+",sysdate)";
			
			
			
			int rowCnt=stmt.executeUpdate(sql);
			System.out.println(rowCnt+"건 추가 되었습니다.");
			
		} finally {
			if(stmt !=null ) {stmt.close();}
			if(con !=null ) {con.close();} // 한 번에 예외처리를 하는 법은 throws 하고 
			// try catch로 잡는다.
		}
		//5. 연결끊기
	}

	public static void main(String[] args) {
		try {
			new TestSQLException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			switch(e.getErrorCode()) {
			case 1 : System.out.println(" 사원번호가 중복되었습니다.");  break;
			case 12899 : System.out.println("사원명의 문자열의 값이 너무 큽니다.");  break;
			case 1438 :   System.out.println(" 연봉에 입력된 값이 너무 큽니다.");  break;
			}
		}
	}

}
