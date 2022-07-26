package kr.or.ddit.basic;

/**
 * 멀티스레드 프로그램. 
 * @author pc-22
 * 
 */

public class T02ThreadTest {
	public static void main(String[] args) {
		// 방법 1 : Thread클래스를 상속한 class의 인스턴스를 생성한 후
		// 	 	   이 인스턴스의 start() 메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.run(); //스레드 실행 메서드.
		// start가 아니라 run으로 실행하면 실행은 되지만 싱글스레드처럼 차례대로 실행된다.
		
		// 방법 2 : Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한 후
		//        이 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의
		//        매개변수로 넘겨준다. 이때 생성된 Thread객체의 인스턴스의 
		//        start() 메서드를 호출한다.
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
		// 방법 1과 방법2를 동시에 실행했더니 서로 번갈아서 실행되는게 보임
		// 만든 스레드가 두 개라 동시에 실행되어서 이런 결과나 나온다. 
		// (총 3개의 스레드 : main 스레드 ,MyThread1, MyThread2)
		
		// 방법 3 : 익명클래스를 이용하는 방법
		//         Runnable 인터페이스를 구현한 익명클래스를 이용하여
		//         스레드 객체를 생성한다.
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<200; i++) {
					System.out.println("@");
					
					try { 
						  // Thread.sleep(시간) 주어진 시간동안 작업을 잠시 멈춘다.
						  // 시간은 밀리세컨드 단위를 사용한다. (1초 = 1ms)
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					} 
				}
				
			}
		});      // 괄호를 여기서 닫는다..
		th3.start();
		// 3가지의 스레드가 섞여서 나온다.
		//(총 4개의 스레드)
	}
}

// 방법 1
class MyThread1 extends Thread { //extends Thread 스레드클래스 만들기.
	@Override
	public void run() {
		for(int i=1; i<200; i++) {
			System.out.println("*");
			
			try { 
				  // Thread.sleep(시간) 주어진 시간동안 작업을 잠시 멈춘다.
				  // 시간은 밀리세컨드 단위를 사용한다. (1초 = 1ms)
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
		}
		super.run();
	}
	
}

// 방법 2
class MyThread2 implements Runnable {
	
@Override
public void run() {
	for(int i=1; i<200; i++) {
		System.out.println("$");
		
		try { 
			  // Thread.sleep(시간) 주어진 시간동안 작업을 잠시 멈춘다.
			  // 시간은 밀리세컨드 단위를 사용한다. (1초 = 1ms)
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
	}
	
}

}







