package kr.or.ddit.basic;

/**
 * 싱글 스레드 프로그램
 * @author pc-22
 *
 */


public class T01ThreadTest {
	public static void main(String[] args) {
		for(int i=1; i<=200; i++) {
			System.out.println("*");
		}
		for(int i=1; i<=200; i++) {
			System.out.println("$");
		}
	// 동작이 순서대로 실행되는 것을 확인해보는 작업.  (싱글스레드 : 하나의 스레드로 작동하는 것.)
	}
}
