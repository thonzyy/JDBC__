package day0817;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class CheckTableDAO {
	
	public ArrayList<String> tableName() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> tname = new ArrayList<String>();
		
		DbConn dc = DbConn.getInstance();
		
		try {
			con = dc.getConnection("localhost", "scott", "tiger");
			
			String selectTable = "select distinct table_name from user_tab_cols";
			
			pstmt = con.prepareStatement(selectTable);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tname.add(rs.getString("table_name"));
			}
			return tname;
		}finally {
			dc.dbClose(rs, pstmt, con);
		}
	}
	
	
	public List<TableVO> selecTable(String tableName) throws SQLException{
		TableVO tVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TableVO> list = new ArrayList<TableVO>();
		
		DbConn dc = DbConn.getInstance();
		
		try {
			con = dc.getConnection("localhost", "scott", "tiger");
			
			StringBuilder selectTable = new StringBuilder();
			selectTable
			.append("	select column_name,data_type,data_length,data_precision,nullable,data_default 									")
			.append("	from user_tab_cols							")  
			.append("	where table_name = ?					");
			
			pstmt = con.prepareStatement(selectTable.toString());
			
			pstmt.setString(1, tableName);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tVO = new TableVO(rs.getString("column_name"),rs.getString("data_type"),rs.getString("data_length"),
						rs.getString("data_precision"),rs.getString("nullable"),rs.getString("data_default"));
				
				list.add(tVO);
			}
			
		}finally {
			dc.dbClose(rs, pstmt, con);
		}
		return list;
	}
	
	
}
