package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 *  멀티 스레드에서의 사용자 입력 처리하기
 * @author pc-22
 *
 */

public class T06ThreadTest {
	// 입력 여부를 확인하기 위한 변수 선언
	// 모든 스레드에서 공통으로 사용할 변수
	static boolean inputCheck = false;
	public static void main(String[] args) {

		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		th1.start();
		th2.start();
		
	}
}

// 사용자 입력을 처리하는 스레드 클래스
class DataInput extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		
		// 입력이 완료되면 inputCheck변수를 true로 변경한다.
		T06ThreadTest.inputCheck = true;
		
		System.out.println("입력한 값은 : " +str + "입니다.");
		
	}
}
// 카운트다운을 처리하는 스레드 클래스
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=0; i--) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면 
			// run()를 종료시킨다. 즉 현재 스레드를 종료시킨다.
			if(T06ThreadTest.inputCheck) { //true 라면?(입력이 완료되었다면)
				return; // run()메서드가 종료되면 스레드가 종료된다.
			}
			if(i ==0) {
				JOptionPane.getRootFrame().dispose();  

				System.out.println("늦음");
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}