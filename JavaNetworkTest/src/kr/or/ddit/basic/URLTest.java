package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		// URL클래스 = 인터넷에 존재하는 서버들의 자원에 접근할 수 있는
		//  		  주소를 관리하는 클래스
		   URL url = new URL("http", "ddit.or.kr", 80, 
				   "/main/index.html?ttt=123#kkk");
		   System.out.println("전체 URL주소 : " + url.toString());
		   
		   System.out.println("protocol : " + url.getProtocol());
		   System.out.println("host : " + url.getHost());
		   System.out.println("query : " + url.getQuery()); 
		   System.out.println("file : " + url.getFile()); // file과 path의 차이점 쿼리의 포함 유무
		   System.out.println("path : " + url.getPath());
		   System.out.println("port : " + url.getPort()); // 포트번호 기본값은 80
		   System.out.println("ref : " + url.getRef());
		   //				   ref : reference => kkk 가 아이디값.
		   
		   System.out.println(url.toExternalForm());
		   System.out.println(url.toString());
		   System.out.println(url.toURI().toString()); //uri : Uniform Resource Identifier
		   // uri : 식별 url : uri의 부분집합 
		   // url은 uri인가요? (O)
		   // uri는 url인가요? (맞을수도 있고 틀릴수도 있다)
	}
}
