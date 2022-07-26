package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	
	// 시작 메서드
	public void clientStart() {
		
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.141.3", 7777);  // 소켓 접속
			
			System.out.println("서버에 연결되어있습니다.");
			
			// 송신용 스레드 생성
			ClientSender sender = new ClientSender(socket);
			
			
			// 수신용 스레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		
		
	}
	
	// 메시지를 전송하는 스레드 클래스
	class ClientSender extends Thread {
		private DataOutputStream dos;
		private Scanner scanner;
		
		public ClientSender(Socket socket) {
			scanner = new Scanner(System.in);
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
					if(dos != null) {  //처음에만 대화명 쏴주고
						// 시작하자 마자 자신의 대화명을 서버로 전송한다.
						System.out.println("대화명 >> ");
						dos.writeUTF(scanner.nextLine());
					}
					
					while(dos != null) { // 그 후로는 무한 반복을 실행한다.
						// 키보드로 입력받은 메시지를 서버로 전송
						dos.writeUTF(scanner.nextLine());
					}
					
					
					
					
					
					
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
		
	}
	
	// 메시지를 수신하는 스레드 클래스
	class ClientReceiver extends Thread {
		private DataInputStream dis;
		
		private ClientReceiver(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}
		@Override
		public void run() {
			while(dis != null) {
				try {
					// 서버로부터 수신한 메시지를 콘솔에 출력
					System.out.println(dis.readUTF());
					
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
	//	new MultiChatServer().serverStart(); // 서버 열기.
		new MultiChatClient().clientStart(); // 서버 접속.
	}
	
	
}
