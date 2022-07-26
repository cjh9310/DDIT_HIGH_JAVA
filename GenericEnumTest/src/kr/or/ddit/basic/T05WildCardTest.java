package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T05WildCardTest {

		/*
		  와일드 카드에 대하여...
		  
		  와일드카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용하는 특별한 종류의
		  인수(Argument)로써, 변수선언, 객체생성 및 매서드 정의 할 때 사용된다.
		  
		  <? extends T> => 와일드 카드의 상한 제한. T와 그 자손들만 가능
		  <? super T>   => 와일드 카드의 하한 제한. T와 그 조상들만 가능
		  <?>           => 모든 타입이 가능<? extends Object>와 동일
		 */
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	}
}

class Juicer { // 이게뭔데..?
	static void makeJuice(FruitBox < ? extends Fruit> box) {
		String fruitListStr = "";
		
		int cnt =0;
		for(Object f : box.getFruitList()) {
			if(cnt ==0) {
				fruitListStr += f;
			}else {
				fruitListStr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => 쥬스 완성!!!");
	}
		
}
	
	// 부모
class Fruit {
	private String name;
	
	public Fruit(String name) {
		this.name =name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일 [name=" + name + "]";
	}
}
	//자식
	class Apple extends Fruit{
		public Apple() {
			super("사과");
		}
	}
	//자식
	class Grape extends Fruit{
		public Grape() {
			super("포도");
		}
	
	}
	/***
	 * 과일 상자
	 * @author pc-22
	 *
	 * @param <T>
	 */
	class FruitBox<T> {
		private List<T> fruitList;
		
		
		public FruitBox() {
			fruitList = new ArrayList<T>();
		}
		public List<T> getFruitList() {
			return fruitList;
		}
		
		public void add(T fruit) {
			fruitList.add(fruit);
		}
		
		
	}
	

