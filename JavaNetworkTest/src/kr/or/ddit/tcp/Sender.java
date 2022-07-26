package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{
	private Scanner scanner;
	private String name;
	private DataOutputStream dos;
	
	public Sender(Socket socket) {
		name = "[" + socket.getInetAddress() + " : "
				+ socket.getLocalPort() + " ] ";
		scanner = new Scanner(System.in);
		try {
			dos = new DataOutputStream(socket.getOutputStream());  
			// DataOutputStream을 사용한 이유  writeUTF를 이용하고 싶어서.
			// writeUTF : String 문자열을 파일에 쓰기 위한 메소드
			// writeUTF 와 readUTF 가 있는데 sender은 보내는 역할이니깐...
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(dos != null) {
			try {
				dos.writeUTF(name + " >>> " + scanner.nextLine());
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
