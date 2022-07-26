package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/*
  실제 DB와 연결해서 SQL문 결과를 조회 후 서비스 전달 (DAO의 인터페이스)
 */
public interface IBoardDAO {
	
	// 새글작성(삽입) 메서드
	public int insertBoard(BoardVO bv);
	
	// 수정 메서드
	public int updateBoard(BoardVO bv);
	
	// 삭제 메서드 	게시글번호를 매개변수로 받아서 그 게시글을 삭제하는 메서드
	public int deleteBoard(int bodNo);

	/**
	 * DB의 mymember테이블에 존재하는 전체 레코드를 가져와 List에 담아서
	 * 반환하는 메서드
	 * @return MemberVO객체를 담고 있는 List 객체
	 */
	public List<BoardVO> getAllBoardList();
	
	// bodNO를 이용하여 존재유무 확인 메서드
	public boolean checkBoard(int bodNo);
	
	// 전체검색기능 메서드
	public List<BoardVO> searchBoard(BoardVO bv);


	
}
