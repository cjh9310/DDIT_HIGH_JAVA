package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj= new ShareObject();
		Thread th1 = new WorkThread("1번 쓰레드",sObj);
		Thread th2 = new WorkThread("2번 쓰레드",sObj);
		
		th1.start();
		th2.start();
	}
}


//  공통으로 사용할 객체
class ShareObject {
	private int sum = 0;
	// 동기화 하는 방법1 : 메서드 자체에 동기화 설정하기.  public synchronized void add() {
	 public  void add() {
	//	 synchronized (this) {  // 여기서 실행시키면 데이터가 순서대로 진행 (단점 : 속도가 느리다)
		for(int i =0; i<1000000000; i++) {} // 동기화처리 전까지 시간벌이용
		
		// 동기화 하는 방법2 : 동기화 블럭으로 설정하기 (synchronized (this)){ this는 ShareObject를 뜻함.
	//	synchronized (this) { 여기서 실행시키면 데이터가 꼬임 (@번이 섞인다.)
			
	
		int n = sum;
		n += 10;
		sum = n;
		
		System.out.println(Thread.currentThread().getName()
							  + "합계 " + sum);
	//	}
	}
}

// 작업을 수행하는 스레드
class WorkThread extends Thread {
	private ShareObject sObj;
	
	
	public WorkThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			synchronized (sObj) {   //sObj에 대해서 동기화를 한다.
				sObj.add();
			}
			
		}
	}
}
