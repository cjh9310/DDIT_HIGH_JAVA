package mirror;

import javax.swing.JOptionPane;

public class T06 {
	static boolean inputCheck = false;
	public static void main(String[] args) {
		Thread th1 = new CountDown();
		Thread th2 = new Data();
		th1.start();
		th2.start();
	}
}



// 입력 스레드 클래스
class Data extends Thread {
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력해");
		T06.inputCheck = true;
		System.out.println(str);
		
	}
}

class CountDown extends Thread {
	@Override
	public void run() {
		for(int i=5; i>=0; i--) {
			if(T06.inputCheck ==true) {
				return;
			}
			if(i==0) {
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












