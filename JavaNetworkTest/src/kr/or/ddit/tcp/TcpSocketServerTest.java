package kr.or.ddit.tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocketServerTest {
	public static void main(String[] args) throws IOException {
		
		// 소켓이란? 두 호스트간 통신을 하기 위한 양 끝단(Endpoint)을 말한다. (전화기같은 역할)
		// Serversocket 없이는 socket객체를 만들 수 없다.
		// TCP 소켓 통신을 하기 위해 ServerSocket객체 생성하기
		ServerSocket server = new ServerSocket(7777); //임의로 7777(포트)번호 지정 0~65535로 지정
		System.out.println("서버가 접속을 기다립니다...");
		
		//accept()메서드는 Client에서 연결 요청이 올 때까지 계속 기다린다.
		// 연결 요청이 오면 Socket객체를 생성해서 Client의 Socket과
		// 연결한다.         
		Socket socket = server.accept();
		
		//--------------------------------
		// 이 이후는 클라이언트와 연결된 후의 작업을 진행하면 된다.
		
		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소 : " +  socket.getInetAddress());
		
		
		// Client에 메세지 보내기
		
		// OutputStream객체를 구성하여 전송한다.
		// 접속한 Socket의 getOutputStream()메서드를 이용하여 구한다.
		OutputStream out = socket.getOutputStream();
		
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeUTF("어서오세요"); // 메세지 보내기
		System.out.println("메세지를 보냈습니다.");
		
		oos.close(); //스트림 닫기
		
		server.close(); // 소켓 닫기
		
	}
}
