package mirror;

public class T09 {
public static void main(String[] args) {
	 Auto th = new Auto();
	 
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
	 System.out.println("메인 종료");
}
}


// 스레드 생성
class Auto extends Thread {
	private void save() {
		System.err.println("저장완료");

	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			save();
		}
	}
}