package kr.or.ddit.basic_0517;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class tress {
	public void getDistinctTreeSet() {

		List<String> originList = new ArrayList<String>();
		originList.add("1");
		originList.add("1");
		originList.add("가나다");
		originList.add("가나다");
		originList.add("ABC");
		originList.add("ABC");
		
		List<String> resultList = new ArrayList<String>();

		TreeSet<String> distinctData = new TreeSet<String>(originList);
		resultList = new ArrayList<String>(distinctData);

		System.out.println("getDistinctTreeSet : originList " + originList);
		System.out.println("getDistinctTreeSet : resultList " + resultList);
	}
}
