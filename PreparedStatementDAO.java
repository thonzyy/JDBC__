package kr.co.sist.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;
import kr.co.sist.statement.DBConnection;
import kr.co.sist.statement.StudentVO;

//싱글레톤 만들기

public class PreparedStatementDAO {
	private static PreparedStatementDAO psDAO;
	private PreparedStatementDAO () {
		
	}
	
	public static PreparedStatementDAO getInstance () {
		if (psDAO==null ) {
			psDAO = new PreparedStatementDAO();
		}
		return psDAO;
	}
	
	public void insertStudent(StudentVO stuVO)throws SQLException{
		Connection con = null;
		PreparedStatement pstmt =null;
		
//		Statement stmt= null;
//		ResultSet rs = null;
		DbConn db= DbConn.getInstance();
		
		
		try {
			//1.드라이버 로딩얻기
			//2. 커넥션 얻기
			con=db.getConnection("localhost","scott","tiger");
			//3. 쿼리문 생성 객체 얻기
			String insertStudent="INSERT INTO STUDENT(NUM,NAME,AGE,EMAIL,INPUT_DATE) VALUES(?,?,?,?,SYSDATE)";
			
			pstmt = con.prepareStatement(insertStudent);
		//4.바인드 변수 값 설정
			pstmt.setInt(1, stuVO.getNum());
			pstmt.setString(2, stuVO.getName());
			pstmt.setInt(3, stuVO.getAge());
			pstmt.setString(4, stuVO.getEmail());
		
			
		//5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
			
			
		}finally {
			db.dbClose(null, pstmt, con);
		}
				
		
		
		
	}
	public int updateStudent(StudentVO stuVO) throws SQLException {
		 int rowCnt = 0;
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 
		 DbConn db = DbConn.getInstance();
		 
		 try {
			 //1. 드라이버로딩얻기
			 //2. 로딩딘 드라이버를 사용하여 db연결 얻기
			 //3. Connection에 쿼리문을 넣어 쿼리문 생성객체 얻기
			 con=db.getConnection("127.0.0.1", "scott", "tiger");
			 StringBuilder updateStudent = new StringBuilder();
			 updateStudent
			 .append("update student	")
			 .append("	set age = ?, email = ?	")
			 .append("	where num = ?	");
			 
			 pstmt= con.prepareStatement(updateStudent.toString());
		
			 //4. 바인드 변수에 값 설정
			 pstmt.setInt(1, stuVO.getAge());
			 pstmt.setString(2, stuVO.getEmail());
			 pstmt.setInt(3, stuVO.getNum());
			 
			 //5. 퀴리문 수행 후 결과 얻기
			 rowCnt=pstmt.executeUpdate();
		 }finally {
			 
			 //6. 연결 끊기
			 db.dbClose(null, pstmt, con);
		 }
		
		 return rowCnt;
		}//updateStudent
	
	/** 학생 번호를 입력받아 학생 레코드를 삭제
	 *
	 * @param stuNum
	 * @throws SQLException
	 */
	public int deleteStudent (int stuNum)throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt= null;
		DbConn db =  DbConn.getInstance();
		
		try {
			con = db.getConnection("localhost", "scott","tiger");
			String deleteStudent = "delete from student where num = ?";
			pstmt = con.prepareStatement(deleteStudent);
			pstmt.setInt(1, stuNum);
			rowCnt=pstmt.executeUpdate();
		}finally {
			db.dbClose(null, pstmt, con);
			
		}
		return rowCnt;
	}
	
	public StudentVO selectOneStudent (int stuNum)throws SQLException {
		StudentVO stuVO=null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConn db = DbConn.getInstance();
		
		try {
			//1. 
			con = db.getConnection("localhost", "scott","tiger");
			//2.
			StringBuilder selectStudent = new StringBuilder();
			selectStudent
			.append("     SELECT NUM, NAME, AGE, EMAIL, INPUT_DATE       ")
			.append("     FROM  STUDENT    ")
			.append("     WHERE  NUM=?    ");
			
			pstmt= con.prepareStatement(selectStudent.toString());
			pstmt.setInt(1, stuNum);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { // 학생의 번호가 검색된 레코드가 존재?
				stuVO= new StudentVO();
				stuVO.setNum(stuNum);
				stuVO.setName(rs.getString("name"));
				stuVO.setAge(rs.getInt("age"));
				stuVO.setEmail(rs.getNString("email"));
				stuVO.setInput_date(rs.getDate("input_date"));
				
		
				
			}
			//3.
			//4.
			//5
			//6
			
		}finally {
			db.dbClose(null, pstmt, con);
		}
		return stuVO;
		
	}
	public List<StudentVO> selectAllStudent() throws SQLException {
		List<StudentVO> list = new ArrayList<StudentVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConn db = DbConn.getInstance();
		
		try {
			//1.
			//2.
			con=db.getConnection("localhost", "scott", "tiger");
			String selectAllStudent = "select num,name, age,email , input_date  from student ";
			//3.
			
			pstmt=con.prepareStatement(selectAllStudent);
			//4.바인드 변수 없음
			//5.
			rs=pstmt.executeQuery();
			
			StudentVO stuVO=null;
			
			while(rs.next()) {//다음 레코드가 존재하면 
				stuVO= new StudentVO(rs.getInt("num"),rs.getString("name"),rs.getInt("age"),rs.getString("email")
						,rs.getDate("input_date"));
				
				list.add(stuVO);
			}//end while
			
		}finally {
			//6.
			db.dbClose(rs, pstmt, con);
		}
		
		//1
		//2
		//3
		//4
		//5
		//6
		return list;
	}
//	public static void main (String[]args) {
//////		StudentVO stu = new StudentVO(5,null,26,"kim26@test.com",null);
//////	try {
////////		int cnt =getInstance().updateStudent(stu);
//////		int cnt =getInstance().deleteStudent(1);
//////		if (cnt==0) {
//////			System.out.println("삭제성공");
//////		}
//////	} catch (SQLException e) {
//////		System.out.println("변경실패");
//////		e.printStackTrace();
//////	}
////		
//		try {
////			System.out.println(getInstance().selectOneStudent(6));
//			System.out.println(getInstance().selectAllStudent());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	
//	}
	}
