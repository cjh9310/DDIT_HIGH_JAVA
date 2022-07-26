package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02jdbcT2 {
	/*
	문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다
lprod_id가 큰 자료들을 출력하시오.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("lprod_id 값 1개 출력");
		int num = sc.nextInt();
		
		sc.close();
		
		
		
		
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"cjh99",
					"java"
					);
			stmt = conn.createStatement();
			
			String sql = "select * from lprod where lprod_id > " + num ;
			
rs = stmt.executeQuery(sql);
			
			// ResultSet객체에 저장된 자료를 출력한다.
			System.out.println("----- 실행 결과 -----");
			while(rs.next()){
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				//System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_gu : " + rs.getString(2));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("---------------------------------");
			}
			
			System.out.println("자료 출력 끝...");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//  사용했던 자원 반납
			if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
			if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
			if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
		}

	}

}
