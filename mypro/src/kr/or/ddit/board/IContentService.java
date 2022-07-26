package kr.or.ddit.board;

import java.util.List;

public interface IContentService {
	
	public List<ContentVO> seeAll();
	
	public int writeContent(ContentVO cv);
	
	public int editContent(ContentVO cv);
	
	public int deleteContent(int boardNum);
	
	public List<ContentVO> searchContent(ContentVO cv);
	
	public boolean checkBoardNum(int boardNum);
}
