package day0817;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class ResultSetMetaData {
	
	public ResultSetMetaData ( )throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		java.sql.ResultSetMetaData rsmd = null;
		
		DbConn db = DbConn.getInstance();
		
		try {
			//1 
			//2
			con = db.getConnection("localhost", "scott", "tiger");

			
			//3
			pstmt=con.prepareStatement("SELECT * FROM EMP ");
			
			//4
			//5
			rs=pstmt.executeQuery();
			//6 R.S.M.D 얻기
			rsmd=rs.getMetaData();
			//7 연결 끊기
//			System.out.println("컬럼의 개수 : "+rsmd.getColumnCount());
//			System.out.println("처음 컬럼명 : "+rsmd.getColumnName(1));
//			System.out.println("처음 데이터형명 : "+rsmd.getColumnTypeName(1));
//			System.out.println("처음 데이터크기 : "+rsmd.getPrecision(1));
//			System.out.println("널허용여부 : "+rsmd.isNullable(1));
			
			for (int i  = 1 ;i<rsmd.getColumnCount()+1;i++) {
				System.out.println(rsmd.getColumnName(i)+" "+
			rsmd.getColumnTypeName(i)+"("+rsmd.getPrecision(i)+")"+(rsmd.isNullable(i)==0?"not null ":""));
			}//end for 
			
			
		}finally {
			db.dbClose(rs, pstmt, con);
		}
		

	}

	public static void main(String[] args) {
		try {
			new ResultSetMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main

}//class
