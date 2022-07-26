package kr.or.ddit.reflection;

public class T01ClassObjectCreationTest {

/*
 Java Reflection에 대하여...
 
 1. 리플렉션은 런타임 시점에 클래스 또는 맴버변수, 메서드, 생성자에 대한 정보를
 	가져오거나 수정할 수 있고, 새로운 객체를 생성하거나, 메서드를 실행할 수 있다.
 	(컴파일 시점에 해당 정보를 알 수 없는 경우(소스코드 부재)에 유용하게 사용된다.)
 	
 2. Reflection API는 java.lang.reflect 패키지와 java.lang.Class를 통해 제공된다.
 3. java.lang.Class 의 주요 메서드  (Class 대문자가 특징)
 	- getName(), getSuperclass(), getInterfaces(), getModifiers() 등.
 4. java.lang.reflect 패키지의 주요클래스
 	- Field, Method, Constructor, Modifier 등.
 	
*/
	public static void main(String[] args) throws ClassNotFoundException {
		
		// Class 오브젝트 (클래스 정보를 담고 있는) 생성하는 3가지 방법 
		// 방법 1 : Class.forName()
		Class<?> klass = Class.forName("kr.or.ddit.reflection.T01ClassObjectCreationTest"); //klass = class를 의미
		//Class.forName("kr.or.ddit.reflection.T01ClassObjectCreationTest") 오류 뜸
		// 해결방법 : throws ClassNotFoundException
		
		// 방법 2 : getClass() 메서드 이용
		T01ClassObjectCreationTest obj = new T01ClassObjectCreationTest();
		klass = obj.getClass();
		
		// 방법 3 : .class 이용
		klass = kr.or.ddit.reflection.T01ClassObjectCreationTest.class;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
