package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSortTest {
	
		/*
		 * 정렬과 관련된 Interface는 Comparable과 Comparator 이렇게 두가지가 있다.
		 * 
		 * - 보통 객체자체에 정렬기능을 넣기 위해서는 Comparable을 구현하고
		 * 	 정렬 기준을 별도로 구현하고 싶을 때는 Comparator를 구현하여 사용하면
		 *   된다.
		 * - Comparable에서는 compareTo()를 구현해야 하고,
		 *   Comparator에서는 compare()를 구현해야 한다.
		 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전 : "+ list);
		
		/*
		 * 정렬은 Collections.sort()를 이용하여 정렬한다.
		 * 정렬은 기본적으로 '오름차순'정렬을 수행한다.
		 * 
		 * 정렬방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서
		 * Collections.sort()메서드의 인수로 넘겨주면 된다.
		 * 
		 */
		Collections.sort(list); // 오름차순으로 정렬하기
		System.out.println("정렬 후 : "+list);
		
		Collections.shuffle(list);   // 섞기
		System.out.println("섞은 후 : "+list);
		
		Collections.sort(list, new Desc());// 외부정렬자를 이용한 리스트 정렬
		System.out.println("외부정렬자를 이용한 정렬 후 : "+list);
	}
}

/*
 *  정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야 한다.
 *  이 Comparator인터페이스의 compare() 메서드를 재정의하여 구현하면 된다.
 */

class Desc implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		/*
		 * compare()의 반환값을 결정하는 방법
		 * => 오름차순이 기본임.
		 * 
		 * - 오름차순 정렬일 경우...
		 * => 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록
		 *    구현한다.
		 * 
		 * 
		 */
		 return str1.compareTo(str2)*-1;
		
	}
	
}
