package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatServer {
	public static void main(String[] args) {
		
		// 서버 소켓을 만들고, 클라이언트가 접속하면 소켓을 만들어 데이터를
		// 받는 스레드 클래스와 데이터를 보내는 스레드 클래스에 이 소켓을
		// 넘겨준다.
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			
			server = new ServerSocket(7777);
			
			System.out.println("서버 준비 완료...");
			
			socket = server.accept(); // 상대방과 소켓이 잘 만들어질 때까지 멈춰있음
			 
			Sender sender = new Sender(socket);  // 보내기만 함 스레드1
			Receiver receiver = new Receiver(socket);// 받기만 함 스레드2
			// sender 와 receiver가 만들어지면 스레드가 실행?
			// 메인 스레드는 죽지만, sender 와 receiver가 살릴 것.
			sender.start();
			receiver.start();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		

	}
}