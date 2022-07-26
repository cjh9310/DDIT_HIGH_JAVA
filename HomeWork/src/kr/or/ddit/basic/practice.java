package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class practice {
	static boolean inputCheck = false;
	public static
	String man = "";
	
	public static void main(String[] args) {
		String[] ran = {"가위", "바위", "보"};
		
		int temp = (int)(Math.random()*3);
		System.out.println(ran[temp]);
		
		UserInput th1 = new UserInput();
		Count th2 = new Count();
		th1.start();
		th2.start();
		
		
		System.out.println("컴퓨터 : " + ran[temp]);
		System.out.println("입력한 값은 : " +man + "입니다.");			
	if(man.equals(ran)) {
		System.out.println("무승부 입니다.");
	}else if (man.equals("가위") && ran.equals("보") || 
			man.equals("주먹") && ran.equals("가위") || 
			man.equals("보") && ran.equals("바위")) {
		System.out.println("당신이 이겼습니다.");
	}else {
		System.out.println("컴퓨터가 이겼습니다.");
	}
	

	}
}


class UserInput extends Thread {
	@Override
	public void run() {
		String inputData;
		inputData= JOptionPane.showInputDialog("아무거나 입력하세요.");	
		practice.inputCheck = true;  // 입력이 완료됨을 알려주는 변수값을 변경한다.
		practice.man = inputData;	   //  입력값 설정
		
	}
}

class Count extends Thread{
	public void run() {
		for(int i=5; i>0; i--) {
			if(practice.inputCheck==true) { 
				return; 
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("시간이 초과되어 당신이 졌습니다.");
		System.exit(0);
	}
}

