package kr.or.ddit.board;

import java.util.List;
import java.util.Scanner;

public class ContentInfoMain {
	
	private IContentService conService;
	
	private Scanner scan = new Scanner(System.in);
	
	public ContentInfoMain() {
		conService = new ContentServiceImpl();
	}
	
	public void start() {
		int choice = 0;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 전체 글 보기
				seeAll();
				break;
			case 2: // 글 작성
				writeContent();
				break;
			case 3: // 글 수정
				editContent();
				break;
			case 4: // 글 삭제
				deleteContent();
				break;
			case 5: // 글 검색
				searchContent();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}
	
	private void searchContent() {
		
	}

	private void deleteContent() {
		
	}

	private void editContent() {
		
	}

	private void writeContent() {
		
		scan.nextLine();
		
		System.out.print("제목 >>");
		String title = scan.nextLine();
		
		
		System.out.print("작성자 >>");
		String writer = scan.nextLine();
		
		
		System.out.print("내용 >>");
		String content = scan.nextLine();
		
		ContentVO cv = new ContentVO();
		cv.setTitle(title);
		cv.setWriter(writer);
		cv.setContent(content);
		
		int cnt = conService.writeContent(cv);
		
		if (cnt > 0) {
			System.out.println("성공적으로 작성되었습니다.");
		}else {
			System.out.println("작성 실패!!!");
		}
		
	}

	private void seeAll() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("번호\t제목\t작성자\t날짜\t\t\t내용");
		System.out.println("----------------------------------------------------------------------");
		
		List<ContentVO> conList = conService.seeAll();
		if (conList.size() == 0) {
			System.out.println("작성된 글이 없습니다.");
		}else {
			for (ContentVO cv : conList) {
				System.out.println(cv.getBoardNum() + "\t"
								 + cv.getTitle() + "\t"
								 + cv.getWriter() + "\t"
								 + cv.getDate() + "\t"
								 + cv.getContent());
			}
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("출력작업 끝...");
		
	}
	private boolean checkBoardNum(int boardNum) {
		boolean isExist = conService.checkBoardNum(boardNum);
		return isExist;
	}

	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 글 보기");
		System.out.println("  2. 새글 작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	public static void main(String[] args) {
		ContentInfoMain conObj = new ContentInfoMain();
		conObj.start();
	}
}
