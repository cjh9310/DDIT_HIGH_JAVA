package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class T06FileStreamTest {
	
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream("d:/D_Other/out.txt");
			
			for(char ch='a'; ch<= 'z'; ch++) {
				fos.write(ch);
			}
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
