package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	
	// 장바구니 항목조회를 위한 메서드 (모든것)  //와일드 카드
	public static void displayCartItemInfo(Cart<?> cart) {
		System.out.println("= 음식류 장바구니 항목 리스트 =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("-----------------------");
	}
	
	// 장바구니 항목조회를 위한 메서드2 (음료와 그 하위)     
	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
		System.out.println("= 음식류 장바구니 항목 리스트 =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("-----------------------");
	}	
	
	// 장바구니 항목조회를 위한 메서드3 (고기류나 그 상위)    <? super T>   => 와일드 카드의 하한 제한. T와 그 조상들만 가능
	public static void displayCartItemInfo3(Cart<?super Meat> cart) {
		System.out.println("= 음식류 장바구니 항목 리스트 =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("-----------------------");
	}		
	
	/*
	 * 관계 
	 	Food
	 	1) Meat
	 	
	 	2) Drink
	 	 - Juice
	 	 - coffee
	 */
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<Food>();
		foodCart.addItem(new Meat("돼지고기", 5000));
		foodCart.addItem(new Meat("소고기", 15000));
		foodCart.addItem(new Juice("오렌지주스", 1500));
		foodCart.addItem(new Coffee("아아", 2000));
		
		Cart<Meat> meatCart = new Cart<Meat>();
		meatCart.addItem(new Meat("돼지고기", 5000));
		meatCart.addItem(new Meat("소고기", 15000));
	//	meatCart.addItem(new Juice("오렌지주스", 15000)); Cart<Meat>로 인해 Juice는 담아지지 않음.
		
		Cart<Drink> drinkCart = new Cart<Drink>();
		drinkCart.addItem(new Juice("오렌지주스", 5000));
		drinkCart.addItem(new Coffee("아아", 15000));
		
		displayCartItemInfo(foodCart);
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);
		//모두 허용
		
	//	displayCartItemInfo2(foodCart);   --에러
	//	displayCartItemInfo2(meatCart);   --에러
		displayCartItemInfo2(drinkCart);
		//drink 타입만 허용
		
		displayCartItemInfo3(foodCart);
		displayCartItemInfo3(meatCart);
	//	displayCartItemInfo3(drinkCart);   --에러
		// super meatCart의 상위까지 허용
		
		
		
		
	}
	
}



class Food {
	private String name; // 음식이름
	private int price;  // 음식가격
	
	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
		// 데이터를 꺼낼 것이 아니라 getter, setter은 필요없음.
	
	@Override
	public String toString() {
		return this.name + "(" + this.price + "원)";
	}
}

class Meat extends Food{
	
	public Meat(String name, int price) {
	super(name,price);
}

}


class Drink extends Food{
	
	public Drink(String name, int price) {
	super(name,price);
}

}

class Juice extends Drink {
	
	public Juice(String name, int price) {
		super(name,price);
	}
}

class Coffee extends Drink {
	
	public Coffee(String name, int price) {
		super(name,price);
	}
}
// 장바구니
class Cart<T> {
	private List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}
	
	public void addItem(T item) {
		list.add(item);
	}
}











