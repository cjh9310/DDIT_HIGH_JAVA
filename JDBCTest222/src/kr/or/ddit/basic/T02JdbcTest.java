package kr.or.ddit.basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class T02JdbcTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		

		System.out.print("lprod_id값 2개 입력 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		scan.close();

		int max, min;

		max = Math.max(num1, num2);
		min = Math.min(num1, num2);
		
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"cjh99",
					"java"
					);
			// Statement객체 생성
			stmt = conn.createStatement();
			
			// SQL문을 Statement객체를 이용하여 실행하고
			// 실행 결과를 ResultSet객체에 저장한다.

			String sql = "select * from lprod "
					+ " where lprod_id  between " + min + " and " + max;
			// String sql에 lprod 전체검색 후 min과 max 사이의 값을 입력
			rs = stmt.executeQuery(sql);
			// ResultSet객체에 저장된 자료를 출력한다.
			System.out.println("----- 실행 결과 -----");
			while(rs.next()){
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				//System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_gu : " + rs.getString(2));     //  "lprod_gu" 대신 2를 써도 되는 것.. 이유는?
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






