package kr.or.ddit.board.service;

import java.util.List;


import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.vo.BoardVO;

/**
 * board(게시물) 정보 처리를 수행하는 Service
 * @author pc-22
 *
 */

public class BoardSeriveImpl implements IBoardService {
	
	private IBoardDAO bodDao;
	
	private static IBoardService bodService;
	
	private BoardSeriveImpl() {
		bodDao = BoardDAOImpl.getInstance();
	}
	// 싱글톤?
	public static IBoardService getInstance() {
		if(bodService == null) {
			bodService = new BoardSeriveImpl();
		}
		
		return bodService;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		
		// 주민등록번호 암호화 처리하기
		
		int cnt = bodDao.insertBoard(bv);
		
		// 해당 사용자에 회원정보 등록 완료 메일 발송하기
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = bodDao.updateBoard(bv);
		return cnt;
	}

	@Override
	public int deleteBoard(int bodNo) {
		int cnt = bodDao.deleteBoard(bodNo);
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> bodList = bodDao.getAllBoardList();
		return bodList;
	}

	@Override
	public boolean checkBoard(int bodNo) {
		boolean isExist = bodDao.checkBoard(bodNo);
		return isExist;
	}


	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> bodList = bodDao.searchBoard(bv);
		
		return bodList;
	}

}
