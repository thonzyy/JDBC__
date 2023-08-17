package day0817;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class ZipcodeDAO {
	
	private static ZipcodeDAO zipDAO;
	private ZipcodeDAO() {
		
	}

	public static ZipcodeDAO getInstance () {
		if(zipDAO==null) {
			zipDAO= new ZipcodeDAO();
		}
		return zipDAO;
		
	}//getInstance
	
	

	
	public List<ZipcodeVO> selectZipcode(String dong)throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConn db = DbConn.getInstance();
		
		try {
			con=db.getConnection("localhost", "scott", "tiger");
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append("    select  zipcode,sido,	gugun,dong, nvl(bunji, ' ') bunji  ")
			.append("      from zipcode      ")
			.append("   where  dong like ?||'%'   ");
					
			
			pstmt= con.prepareStatement(selectZipcode.toString());
			pstmt.setString(1, dong);
			rs=pstmt.executeQuery();
			ZipcodeVO zVO=null;
			while(rs.next()) {
				zVO= new ZipcodeVO ();
				zVO.setZipcode(rs.getString("zipcode"));
				zVO.setSido(rs.getString("sido"));
				zVO.setGugun(rs.getString("gugun"));
				zVO.setDong(rs.getString("dong"));
				zVO.setBunji(rs.getString("bunji"));
				
				list.add(zVO);
			}
			
		}finally {db.dbClose(rs, pstmt, con);} ;
		//1.
		//2.
		//3.
		//4.
		//5.
		//6.
		return list;
	}
}
