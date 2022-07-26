package kr.or.ddit.board;

import java.util.List;
import java.util.Scanner;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.service.BoardSeriveImpl;
import kr.or.ddit.board.service.IBoardService;

/*
 위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
                         
------------------------------------------------------------
create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값

----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal
 
 // 번호가 자동증가하나 실행하는 법 (DB에서 실행)
INSERT INTO JDBC_BOARD
		( board_no, board_writer, board_title, board_content, board_date )
		VALUES( board_seq.nextVal, '7866', 'komojkm', 'klmojmlkmo', sysDate)

select * from JDBC_board


 */


/*
  간단하게 생각하면 main -> service
  			    service -> DAO
  			    DAO -> SQL로 전송하는 방식

 */


public class BoardMain {
private IBoardService bodService;
	
	private Scanner scan = new Scanner(System.in); 
	
	public BoardMain() {
		bodService = BoardSeriveImpl.getInstance();
	}
	public void Menu() {
		System.out.println();
		System.out.println(" 작 업 선 택");
		System.out.println("1. 전체 목록 출력");
		System.out.println("2. 새글 작성");
		System.out.println("3. 글 수정");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("6. 작업 종료");
	}
		
	// 프로그램 실행되는 메서드
	public void start() {
		int choice = 0;
		do {
			Menu(); //메뉴판 출력
			choice = scan.nextInt();  // 번호 입력기
			switch(choice) {
			case 1 :
				displayBoardAll();
				break;
			case 2 :
				insertBoard();
				break;
			case 3 :
				updateBoard(); 
				break;
			case 4 : 
				deleteBoard();
				break;
			case 5 :
				searchBoard();
				break;
			case 6 :
				System.out.println("작업이 끝남");
			default :
				System.out.println("번호 오류");
			}
		}while(choice !=6);

	}
	
	private void searchBoard() {
	/*
	   검색할 번호, 제목, 작성자, 내용 등을 입력하면
	   입력한 정보만 사용하여 검색하는 기능을 구현하시오.
	   주소는 입력한 값이 포함만 되어도 검색 되도록 한다.
	   입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다. 
	*/
		
		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		scan.nextLine();
		System.out.print("회원 이름 >> ");
		String bodName = scan.nextLine().trim();
		
		System.out.print("회원 제목 >> ");
		String bodTitle = scan.nextLine().trim();
		
		System.out.print("회원 내용 >> ");
		String bodClob = scan.nextLine().trim();		
		
		BoardVO bv = new BoardVO();
		bv.setBodTitle(bodTitle);
		bv.setBodName(bodName);
		bv.setBodClob(bodClob);
		
		// 검색 기능 호출...
			List<BoardVO> bodList = bodService.searchBoard(bv);
				
			System.out.println("-----------------------------------------");
			System.out.println("번호 \t 제목 \t 작성자 \t 내용");
			System.out.println("-----------------------------------------");
			
			if(bodList.size() == 0) {
				System.out.println("검색된 회원정보가 없습니다.");
			}else {
				for(BoardVO bv2 : bodList) {
				System.out.println("번호 " +bv2.getBodNo());
				System.out.println("제목" + bv2.getBodTitle());
				System.out.println("작성자" +bv2.getBodName());
				System.out.println("내용" + bv2.getBodClob());
				System.out.println("날짜" + bv2.getSysDate());
				}
			}
			System.out.println("-----------------------------------------");
			System.out.println("검색 작업 끝...");		
		
		
		
	}
	
	
	private void deleteBoard() {
		

		System.out.println();
		System.out.println("삭제할 번호를 입력하세요.");
		System.out.println("등록 번호 >> ");
		
		int bodNo = scan.nextInt();
		
		int cnt = bodService.deleteBoard(bodNo);
		
		if(cnt > 0) {
			System.out.println(bodNo + "등록 번호 삭제 성공");
		}else {
			System.out.println(bodNo + "등록 번호 삭제 성공");
		}
		
		
	}
	private void updateBoard() {
		int bodNo ;
		boolean isExist = false;  //  중복 체크용
		
		do {
			
		System.out.println();
		System.out.println("수정할 번호를 입력하세요.");
		System.out.println("등록 번호 >> ");
		
		bodNo = scan.nextInt();
		
		isExist = checkBoard(bodNo);
		
		if(!isExist) {
			System.out.println("회원ID가 " + bodNo + "인 회원은 "
					+ "존재하지 않습니다.");
			System.out.println("다시 입력해 주세요.");
		}
		
	}while(!isExist);
		
		System.out.println();
		System.out.println("제목");
		String bodTitle = scan.next();
		System.out.println("작성자");
		String bodName = scan.next();
		System.out.println("내용");
		String bodClob = scan.next();
		
		
		
		BoardVO bv = new BoardVO();
		bv.setBodNo(bodNo);  
		bv.setBodName(bodName);
		bv.setBodTitle(bodTitle);
		bv.setBodClob(bodClob);
		
		int cnt = bodService.updateBoard(bv);
		
		if(cnt > 0) {
			System.out.println(bv.getBodNo()+") "+bv.getBodName()+"님 작성 성공");
		}else {
			System.out.println(bv.getBodNo()+") "+bv.getBodName()+"님 작성 실패");
		}
	}
	
	private void insertBoard() {
		String bodName = "";
		String bodTitle = "";
		String bodClob = "";
		
		System.out.println();
		System.out.println("제목");
		bodTitle = scan.next();
		System.out.println("작성자");
		bodName = scan.next();
		System.out.println("내용");
		bodClob = scan.next();
		
		BoardVO bv = new BoardVO();
		bv.setBodName(bodName);
		bv.setBodTitle(bodTitle);
		bv.setBodClob(bodClob);
		
		int cnt = bodService.insertBoard(bv);
		
		if(cnt > 0) {
			System.out.println(bv.getBodNo()+") "+bv.getBodName()+"님 작성 성공");
		}else {
			System.out.println(bv.getBodNo()+") "+bv.getBodName()+"님 작성 실패");
		}
	

	}
	private void displayBoardAll() {
		System.out.println("--------------------------");
		System.out.println("번호 \t 제목 \t 작성자 \t 내용");
		List<BoardVO> bodList = bodService.getAllBoardList();
		if(bodList.size() == 0) { //아무것도 존재하지 않는다면
			System.out.println("회원정보가 없습니다.");
		}else {
			for(BoardVO bv : bodList) {
				System.out.print("번호 " +bv.getBodNo()   );
				System.out.print("\t 제목" + bv.getBodTitle());
				System.out.print("\t 작성자" +bv.getBodName());
				System.out.print("\t 내용" + bv.getBodClob());
				System.out.println("\t 날짜" + bv.getSysDate());
			}
		}
		System.out.println("---------------------------");
		System.out.println("출력 끝");

	}
	
	private boolean checkBoard(int bodNo) {
		boolean isExist = bodService.checkBoard(bodNo);
		
		return isExist;
	}
	
	public static void main(String[] args) {
		BoardMain bodObj = new BoardMain();
		bodObj.start();
	}
		
		
}
