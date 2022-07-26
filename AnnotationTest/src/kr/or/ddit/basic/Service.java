package kr.or.ddit.basic;

public class Service {
	
	@PrintAnnotation()   //주석처럼 동작해서 에러가 안뜸. (메서드에 붙여도 되도록 만들어둠.)
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	@PrintAnnotation(value = "St") //@PrintAnnotation의 괄호에 value가 기본값으로 들어가서 출력만 써도 됨.
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	@PrintAnnotation(value = "#",count=25) // 2개 이상이면 value를 필수로 작성.
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}

