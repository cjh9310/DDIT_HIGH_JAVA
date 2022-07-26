package kr.or.ddit.reflection;

import kr.or.ddit.basic.PrintAnnotation;

public class SampleVO implements Comparable<SampleVO>{
	public String id;
	protected String name;
	private int age;
	public SampleVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public SampleVO() {}  // 위에 생성자를 미리 만들어서 디폴트 생성자를 쓸려면 직접 하나 더 만들어야 함.
	
	@PrintAnnotation
	public String getId() throws RuntimeException{
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
	// 클래스에 SampleVO가 오류뜸. 해결방법은 아래
	@Override
	public int compareTo(SampleVO o) {
		return name.compareTo(o.name);
	}
		
	
	
	
}
