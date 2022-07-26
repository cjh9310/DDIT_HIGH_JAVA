package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.service.BoardSeriveImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.MybatisUtil;

public class BoardDAOImpl implements IBoardDAO {
	// SqlSession에  private  MybatisUtil로 생성하되 한 번만 만들기 위해 
		// 싱글톤.....  왜 사용하는지를 좀 더 알아봐야 할 듯
	
	// private static @정적필드
	// private @생성자
	// getInstance()를 이용하여 한 번만 생성가능하게 설정
	private static IBoardDAO bodDao; // 정적필드
	private SqlSession sqlSession; // 싱글톤을 이용시 private를 사용해줌.      생성자

	
	// 
	private BoardDAOImpl() {
		sqlSession = MybatisUtil.getInstance(); 
	}
	
	public static IBoardDAO getInstance() { // getInstance를 쓰게되면 public을 사용 
		if(bodDao == null) {  // bodDao가 한 번도 생성된 적이 없을때 
			bodDao = new BoardDAOImpl(); // 한 번 생성하고 
		}
		
		return bodDao;  // badDao의 객체를 반환해줌.
		// main에서 public BoardMain() {
	//	bodService = BoardSeriveImpl.getInstance();
//		}
		// 
	}
	
	public int insertBoard(BoardVO bv) {
		int cnt = sqlSession.insert("board.insertBoard",bv);
		// 혜림누나가 말한 글 최대 설정 cnt >= 3 로 설정하면 중복 3개까지 가능하다.
		if(cnt > 0) {
			sqlSession.commit(); //insert 작업 성공
		}else {
			sqlSession.rollback(); //insert 작업 실패
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = sqlSession.update("board.updateBoard",bv);
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		return cnt;
	}

	public int deleteBoard(int bodNo) {
		int cnt = sqlSession.delete("board.deleteBoard",bodNo);
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		return cnt;
	}

	
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> memList = sqlSession.selectList("board.getBoardAll");
		
		return memList;
	}

	@Override
	public boolean checkBoard(int bodNo) {
		boolean isExist = false;
		
		int cnt = (int)sqlSession.selectOne("board.checkBoard",bodNo);
		
		if(cnt > 0) {
			isExist = true;
		}
		
		return isExist;
	}


	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		List<BoardVO> bodList = sqlSession.selectList("board.searchBoard", bv);
		return bodList;
	}




	


}
