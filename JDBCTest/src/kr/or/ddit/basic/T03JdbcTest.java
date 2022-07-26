package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class T03JdbcTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로딩확인(옵션)
				Class.forName("oracle.jdbc.driver.OracleDriver");
						
						// 2. DB에 접속 (Connection객체 생성)
				String url = "jdbc:oracle:thin:@localhost:1521/xe";
				String userId = "cjh99";
				String password = "java";
						
				conn = DriverManager.getConnection(url, userId, password);
						
				//3. Statement객체 생성 => Connection객체를 이용한다.
				stmt = conn.createStatement();
				
				/*
				String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm)\r\n"
						+ " values(101,'N101','농산물')";
				int cnt = stmt.executeUpdate(sql);
				System.out.println("처리결과(cnt)" + cnt);
				
				sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm)\r\n"
						+ " values(102,'N102','수산물')";
				cnt = stmt.executeUpdate(sql);
				System.out.println("처리결과(cnt)" + cnt);
				
				sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm)\r\n"
						+ " values(103,'N103','축산물')";
				cnt = stmt.executeUpdate(sql);
				System.out.println("처리결과(cnt)" + cnt);
				*/
				
				// 3) PreparedStatement객체를 이용한 자료 추가 방법
				String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm)\r\n"
						  + " values(?,?,?)"; // ?자리에 ;0-GKstatement를 여러개 생성하려고 할 때
				// prepareStatement객체를 생성할때 SQL문을 넣어서 생성한다.
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 101);   //values의 첫번째 물음표 
				pstmt.setString(2, "N101"); //values의 두번째 물음표 
				pstmt.setString(3, "농산물"); //values의 세번째 물음표 
				int cnt = pstmt.executeUpdate();
				System.out.println("첫번째 반환값 : " +cnt);
				//------------------------------------------------------
				pstmt.setInt(1, 102);   //values의 첫번째 물음표 
				pstmt.setString(2, "N102"); //values의 두번째 물음표 
				pstmt.setString(3, "수산물"); //values의 세번째 물음표 
				cnt = pstmt.executeUpdate();
				System.out.println("두번째 반환값 : " +cnt);
				// ------------------------------------------------------
				pstmt.setInt(1, 103);   //values의 첫번째 물음표 
				pstmt.setString(2, "N103"); //values의 두번째 물음표 
				pstmt.setString(3, "축산물"); //values의 세번째 물음표 
				cnt = pstmt.executeUpdate();
				System.out.println("세번째 반환값 : " +cnt);
				
				
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(stmt != null) try {stmt.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
	}
}




