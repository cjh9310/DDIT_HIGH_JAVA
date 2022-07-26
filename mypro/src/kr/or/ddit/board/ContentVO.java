package kr.or.ddit.board;

public class ContentVO {
	private int boardNum;
	private String title;
	private String writer;
	private String date;
	private String content;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "ContentVO [boardNum=" + boardNum + ", title=" + title + ", writer=" + writer + ", date=" + date
				+ ", content=" + content + "]";
	}
	
	
}
