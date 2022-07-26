package kr.or.ddit.basic;

public class T04ThreadTest {
	/*
	 1억부터 20억까지의 합계를 구하는데 걸린 시간을 체크해 보기
	 전체 합계를 구하는 작업을 단독으로 했을 때(1개의 스레드를 이용)와   => 메인 스레드 제외
	 여러 스레드로 분할해서 작업할 때의 시간을 확인해 보기.
	 */
	public static void main(String[] args) {
		//단독으로 처리할 때...
		SumThread sm = new SumThread(1L, 2000000000L);
		long startTime = System.currentTimeMillis();
		
		sm.start();
		
		try {
			sm.join();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리할 때의 처리시간 : "
							+ (endTime - startTime) + "(ms)");
		System.out.println();
		System.out.println();
		
		
		// 여러 스레드가 협력해서 처리 할때...   
		SumThread[] sumThs = new SumThread[] {
			new SumThread(1L,          500000000L),
			new SumThread(500000001L,  1000000000L),
			new SumThread(1000000001L, 1500000000L),
			new SumThread(1500000001L, 2000000000L)
		};
		startTime = System.currentTimeMillis();
		
		for(Thread th : sumThs) {
			th.start();
		}
		for(Thread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("협력으로 처리할 때의 처리시간 :"
				           + (endTime - startTime) + "(ms)");
		// 결과 동시에 실행되어서 결과값은 섞여서 나온다.  
		// 대신 처리값은 싱글스레드를 이용할 때 보다 대폭 줄어든 결과를 보여준다.
	}
}

class SumThread extends Thread { //Thread 클래스로 정의함.
	private long min, max;
	
	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=min; i<=max; i++) {
			sum +=i;
		}
		System.out.println(min + " ~ " + max + "까지의 합 : " + sum);
		
	}
	
}