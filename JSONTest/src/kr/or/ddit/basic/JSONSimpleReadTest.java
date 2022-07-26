package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONSimpleReadTest {
	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fr = new FileReader("./myJsonFile.txt");
		JSONParser jsonParser = new JSONParser();
		
		Object obj = jsonParser.parse(fr);
		JSONObject jsonObj = (JSONObject) obj;
		
		String name = (String) jsonObj.get("name");
		String job = (String) jsonObj.get("job");
		long age = (long) jsonObj.get("age");
		String addr = (String) jsonObj.get("addr");
		
		System.out.println("name : " + name);
		System.out.println("job : " + job);
		System.out.println("age : " + age);
		System.out.println("addr : " + addr);
		
		JSONArray memList = (JSONArray) jsonObj.get("memList");
		System.out.println("--------------------------------");
		
		Iterator<JSONObject> it = memList.iterator();
		
		JSONObject jsonObj2 = null;
		while(it.hasNext()) {
			jsonObj2 = it.next();
			String str = String.format("이름 : %s, \t직업 : %s, \t나이 : %d, \t주서 : %s\n", 
					jsonObj2.get("name"), jsonObj2.get("job"), 
					jsonObj2.get("age"), jsonObj2.get("addr"));
			System.out.println(str);
		}
		
		
		
	}
}
