package kr.or.ddit.basic;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws IOException {
	/*
	    InetAddress 클래스 => IP주소를 다루기 위한 클래스
	    
	    getByName()은 www.naver.com 또는 SEM-PC 등과 같은 머신이름이나
	    IP주소를 파라미터를 이용하여 유효한 InetAddress 객체를 제공한다.
	    IP주소 자체를 넣으면 주소 구성 자체의 유효성 체크만 이루어진다.
	*/
		
		// 네이버 사이트의 IP정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name => " + naverIp.getHostName());
		// Host Name : 도메인 이름.
		System.out.println("Host Address => " + naverIp.getHostAddress());
		System.out.println();
		
		// 자기 자신 컴퓨터의 IP주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name => " 
						+ localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => " 
				+ localIp.getHostAddress());
		System.out.println();
		
		// IP주소가 여러개인 호스트의 정보 가져오기
		//						getAllByName에 메핑되어 있는 모든 주소를 가져옴
		// 						naver에 접속하는 사람들이 많아서, 나눠서 접속할 수 있게 관리함.
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress iAddr : naverIps) {
			System.out.println("네이버 주소들 : " +iAddr.toString());
		}
	}
}
