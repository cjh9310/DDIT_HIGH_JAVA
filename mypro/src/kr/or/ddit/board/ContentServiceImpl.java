package kr.or.ddit.board;

import java.util.List;

public class ContentServiceImpl implements IContentService{
	private IContentDAO conDao;
	
	public ContentServiceImpl() {
		conDao = new ContentDaoImpl();
	}
	
	@Override
	public List<ContentVO> seeAll() {
		List<ContentVO> conList = conDao.seeAll();
		return conList;
	}

	@Override
	public int writeContent(ContentVO cv) {
		
		int cnt = conDao.writeContent(cv);
		return cnt;
	}

	@Override
	public int editContent(ContentVO cv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteContent(int boardNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ContentVO> searchContent(ContentVO cv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkBoardNum(int boardNum) {
		// TODO Auto-generated method stub
		return false;
	}

}
