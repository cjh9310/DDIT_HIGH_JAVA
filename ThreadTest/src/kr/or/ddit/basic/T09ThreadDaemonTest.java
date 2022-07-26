package kr.or.ddit.basic;
/**
 * 
 *데몬 스레드 : 주 스레드의 작업을 돕는 보조적인 역할
 *특징      : 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료된다.
 * @author pc-22
 *
 */
public class T09ThreadDaemonTest {
	public static void main(String[] args) {
		Thread th = new AutoSaveThread();
		// 데몬스레드로 설정하기 ( start메서드 호출전에 설정한다.)
		th.setDaemon(true);
		th.start();
		try {
			for(int i=0; i<=20; i++) {
				System.out.println("작업" +i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("메인 스레드 종료.");
	}
}


/**
 * 자동저장 기능을 제공하는 스레드
 * (3초에 한번씩 저장하기)
 * 
 * */

// 데몬스레드가 없으면 스레드는 종료되지 않음.  (메인스레드가 종료되어도 AutoSaveThread 스레드는 계속 실행 된다.)
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			save(); //저장기능 호출
			
		}
	}
}