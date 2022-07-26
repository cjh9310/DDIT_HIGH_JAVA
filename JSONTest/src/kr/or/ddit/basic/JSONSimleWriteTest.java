package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONSimleWriteTest {
/*
	JSON : JavaScript Object Notation
	
	- JSON에서 value값으로 가능한 데이터 타입
	1. String
	2. number
	3. object(JSON object)
	4. array
	5. boolean
	6. null
 
*/
	public static void main(String[] args) throws IOException {
		
		//JSON 데이터 생성하기
		JSONObject mv = new JSONObject();
		
		mv.put("name", "홍길동");
		mv.put("job", "학생");
		mv.put("age", 30);
		mv.put("addr", "대전시 오류동 대덕인재개발원");
		
		// JSONArray 데이터 생성
		JSONArray memList = new JSONArray(); //배열형태의 데이터 구성준비
		
		JSONObject mv2 = new JSONObject();
		mv2.put("name", "이순신");
		mv2.put("job", "자영업");
		mv2.put("age", 40);
		mv2.put("addr", "경남 사천시");
		memList.add(mv2);
		
		mv2 = new JSONObject();
		mv2.put("name", "강감찬");
		mv2.put("job", "회사원");
		mv2.put("age", 20);
		mv2.put("addr", "부산시 해운대구");
		memList.add(mv2);
		
		mv2 = new JSONObject();
		mv2.put("name", "이몽룡");
		mv2.put("job", "무직");
		mv2.put("age", 40);
		mv2.put("addr", "경기도 광명시");
		memList.add(mv2);
		
		mv2 = new JSONObject();
		mv2.put("name", "정도전");
		mv2.put("job", "농업");
		mv2.put("age", 50);
		mv2.put("addr", "인천시 부평구");
		memList.add(mv2);
		
		mv.put("memList", memList);
		
		FileWriter fw = new FileWriter("./myJsonFile.txt");
		fw.write(mv.toString());
		fw.flush();   // 남은데이터를 비워준다.
		fw.close();   // 데이터를 닫아준다.
		
		
	}
	
	
	
	
	
}
