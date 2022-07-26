package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T08FileReaderTest {
	public static void main(String[] args) {
		
		FileReader fr = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			//fr = new FileReader("d:/D_Other/testChar.txt");  방법1.
			fis = new FileInputStream("d:/D_Other/testChar.txt"); // 방법2.
			isr = new InputStreamReader(fis);                     // 방법2.
			
			int data =0;
			
			while((data = isr.read())!= -1) {
				System.out.print((char) data);
			}
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
		//		fr.close();            방법1.
				isr.close();         //방법2.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
