package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MembersqlSessionTest {
	public static void main(String[] args) {
		// sqlSession를 이용하여 DB자료를 처리하는 작업 순서
		// 1. sqlSession의 환경설정파일을 읽어와 실행시킨다.
		SqlSession sqlSession = null;
		try {
			// 1-1. xml문서 읽어오기
			// 설정파일의 인코딩 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("mybatis-config.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을
			//      진행할 객체를 생성하기
			SqlSessionFactory sessionFactory = 
					new SqlSessionFactoryBuilder().build(rd);
			// AutoComit false 설정
			sqlSession = sessionFactory.openSession(false);
			rd.close(); // Reader 객체 닫기
			
			}catch(IOException ex) {    //IOException은 reader만들 때 발생함.
				ex.printStackTrace();
			}
		
			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을
			//    수행한다.
			
			// 2-1. insert 작업 연습
			System.out.println("insert작업 시작...");
			
			// 1) 저장할 데이터를 VO 에 담는다.
			MemberVO mv = new MemberVO();
			mv.setMemId("d001");
			mv.setMemName("강감찬");
			mv.setMemTel("010-1111-1111");
			mv.setMemAddr("경남 사천시");
			
			// 2) SqlSession 객체를 이용하여 해당 쿼리문을 실행한다.
			//   형식) sqlSession.insert("namespace값.id값", 파라미터객체);
			//       반환값 : 성공하면 int 값이 반환된다.
			
			int cnt = sqlSession.insert("memberTest.insertMember", mv);
			
			if(cnt > 0) {
				System.out.println("insert작업 성공");
			}else {
				System.out.println("insert작업 실패!!!");
			}
			System.out.println("------------------------------------");
			
			
			// 2-2. update작업 연습
			System.out.println("update 작업 시작...");
			
			mv = new MemberVO();
			mv.setMemId("d001");
			mv.setMemName("임영웅");
			mv.setMemTel("2222-2222");
			mv.setMemAddr("서울시 영등포구");
			
			sqlSession.update("memberTest.udateMember",mv);          
			
			if(cnt >0) {
				System.out.println("업데이트 작업 성공");
				sqlSession.commit();
			}else {
				System.out.println("업데이트 작업 실패!");
				sqlSession.rollback();
			}
			
			
			
			
			
			
			
			
			
			

		
	}
	
	
	
}
