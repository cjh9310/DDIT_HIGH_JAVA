package kr.or.ddit.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpSocketClientTest {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "192.168.141.21";
		// 자기자신을 나타내는 방법
		// IP : 127.0.0.1
		// 컴이름 : localhost
		
		System.out.println(serverIp + " 서버에 접속 중입니다...");
		
		// 소켓을 생성해서 서버에 연결을 요청합니다.
		Socket socket = new Socket(serverIp, 7777);
		
		// 연결이 되면 이후의 명령이 실행된다.
		System.out.println("연결되었습니다.");
		
		// 서버에서 보내온 메세지 받기
		// 메세지를 받기 위해 InputStream객체를 생성한다. (상대방이 보낸 메세지를 받고 싶어서 inputStream 사용함)
		// Socket의 getInputStream() 메서드 이용
		InputStream is = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		
		// 서버로부터 받은 메세지 출력하기
		System.out.println("받은 메세지 : " + ois.readUTF());
		
		System.out.println("연결종료");
		
		ois.close();
		socket.close();
		
		
		
		
		
		
		
		
		
		
	}
}
