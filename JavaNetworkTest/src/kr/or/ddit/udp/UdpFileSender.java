package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileSender {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private InetAddress receiverAddr;
	private int port;
	private File file;
	
	public UdpFileSender(String receiverIp, int port) {
		try {
			ds = new DatagramSocket();
			this.port = port;
			this.receiverAddr = InetAddress.getByName(receiverIp);
			file = new File("d:/공유폴더/html/images/suzy.jfif");
			
			if(!file.exists()) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				System.exit(0);
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void start() {
		
		long fileSize = file.length();
		long totalReadBytes = 0;
		
		long startTime = System.currentTimeMillis();
		
		try {
			// 전송시작을 알려주기 위한 문자열 전송
			sendData("start".getBytes()); 
			
			// 파일명을 전송
			sendData(file.getName().getBytes());
			
			// 총 파일 사이즈 정보를 전송
			sendData(String.valueOf(fileSize).getBytes());
			
			FileInputStream fis = new FileInputStream(file);
			
			byte[] buffer = new byte[1000];
			while(true) {
				Thread.sleep(10); // 패킷전송 간의 간격을 주기 위해서...
				int readBytes = fis.read(buffer, 0, buffer.length);
				if(readBytes == -1) { // 다 읽은 경우...
					break;
				}
				
				// 읽어온 파일내용 전송하기
				sendData(buffer, readBytes);
				
				totalReadBytes += readBytes;
				System.out.println(" 진행 상태 : " + totalReadBytes
						+ "/" + fileSize + " Byte(s) ("
						+ (totalReadBytes * 100 / fileSize) + " %)");
			}
			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed =  fileSize / diffTime;
			
			System.out.println("걸린 시간 : " + diffTime + " (ms)");
			System.out.println("평균 전송속도 : " 
							+ transferSpeed + " Bytes/ms");
			System.out.println("전송 종료...");
			
			fis.close();
			ds.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 바이트배열 데이터 전송하기
	 * @param bytes 전송할 바이트 배열
	 * @throws IOException 
	 */
	private void sendData(byte[] bytes) throws IOException {
		
		sendData(bytes, bytes.length);
	}
	
	/**
	 * 바이트배열 데이터 전송하기
	 * @param bytes 전송할 바이트 배열
	 * @param length 전송할 실제 사이즈
	 * @throws IOException
	 */
	private void sendData(byte[] bytes, int length) throws IOException {
		dp = new DatagramPacket(bytes, length, receiverAddr, port);
		ds.send(dp);
	}
	
	public static void main(String[] args) {
		new UdpFileSender("192.168.141.3", 8888).start();
	}
	
	
}
