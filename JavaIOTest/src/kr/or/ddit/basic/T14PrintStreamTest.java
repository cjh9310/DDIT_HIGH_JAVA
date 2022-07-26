package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 프린트기능 보조 스트림
 * @author pc-22
 *
 */
public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		
		/*
		 	PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는
		 	OutputStream의 서브 클래스이다.
		 */
	/*	PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream입니다. \n");
		out.println("안녕하세요. PrintStream입니다.2");
		out.println("안녕하세요. PrintStream입니다.3");
		out.println(out); // 객체 출력
		out.println(3.14);
		
		
		
		out.close();
		// 메모장에서 확인 가능
		*/
		/*
		 	PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는데
		 	적합하다.
		*/
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos, "UTF-8"));
		pw.print("안녕하세요. PrintWriter 입니다. \n");
		pw.println("안녕하세요. PrintWriter 입니다.2");
		pw.println("안녕하세요. PrintWriter 입니다.3");
		pw.println(pw);
		
		pw.close();
		
		
	}
}
