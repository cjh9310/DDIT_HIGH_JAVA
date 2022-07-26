package kr.or.ddit.board.vo;

/**
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
 * @author cjh99
 * 
 * <p>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
 *  </p>
 */
public class BoardVO2 {
	private int bodNo;
	private String bodTitle;
	private String bodName;
	private String bodClob;
	private String sysDate;
	public int getBodNo() {
		return bodNo;
	}
	public void setBodNo(int bodNo) {
		this.bodNo = bodNo;
	}
	public String getBodTitle() {
		return bodTitle;
	}
	public void setBodTitle(String bodTitle) {
		this.bodTitle = bodTitle;
	}
	public String getBodName() {
		return bodName;
	}
	public void setBodName(String bodName) {
		this.bodName = bodName;
	}
	public String getBodClob() {
		return bodClob;
	}
	public void setBodClob(String bodClob) {
		this.bodClob = bodClob;
	}
	public String getSysDate() {
		return sysDate;
	}
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}
	@Override
	public String toString() {
		return "BoardVO2 [bodNo=" + bodNo + ", bodTitle=" + bodTitle + ", bodName=" + bodName + ", bodClob=" + bodClob
				+ ", sysDate=" + sysDate + "]";
	}
	
	
	
	
}