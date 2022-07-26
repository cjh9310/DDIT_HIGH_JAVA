package kr.or.ddit.basic;


class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {
		// doubleValue() 오류 해결법.
		//extends Number extends로 이용해서 Number를 포함해서 숫자형으로 바꿈.
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
		
	}
	
}

/***
 * 제한된 타입 파라미터(Bounded Parameter) 예제
 * @author pc-22
 *
 */
public class T04GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		// 결과 : 20이 더 커서 -1 값이 나온다.
		int result2 = Util2.compare(3.14, 3);
		System.out.println(result2);
		// 결과 : 3.14가 더 커서 1이 나온다.
		int result3 = Util2.compare(4, 4);
		System.out.println(result3);
		// 결과 : 값이 같아서 0이 나온다.
		
	}
}
