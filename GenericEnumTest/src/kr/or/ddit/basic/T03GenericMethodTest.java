package kr.or.ddit.basic;

	class Util{
		/* 
		  	재너릭 메서드 <T,R> R method(T t)
		  	
		  	파라미터 타입과 리턴타입으로 타입 파라미터를 가지는 메서드
		  	
		  	선언방법 : 라턴타입 앞에 <> 기호를 추가하고 타입 파라미터를 기술 후 사용함.
		 */
		
		public static <K,V> boolean compare(Pair<K,V> p1,  Pair<K,V> p2) {
			boolean keyCompare = p1.getKey().equals(p2.getKey());
			boolean valueCompare = p1.getValue().equals(p2.getValue());
			
			return keyCompare && valueCompare;
		}
	}
	/**
	 * 멀티타입<K,V>을 가지는 제너릭 클래스
	 * @author pc-22
	 *
	 * @param <K>
	 * @param <V>
	 */
class Pair<K,V> {
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public <K,V> void displayAll(K key, V val) {
		System.out.println(key.toString() + " : " + val.toString());
	}         //  일반 메서드에  <K,V> 안써도 에러가 없는 이유 : class Pair<K,V> 클래스 안에 있어서 
		      // 대신 main에 적용이 안된다... 그냥 에러만 안뜸
}
	
public class T03GenericMethodTest {
	public static void main(String[] args) {
		
		// Pair<?, ?> p1 : 와일드카드 : 선언해야 할 것을 모를때.. (타입이 아직 정해지지 않을때)
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");  
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		
		// 구체적 타입을 명ㅅ적으로 지정(생략가능)
		boolean result1 = Util.<Integer, String> compare(p1,p2);
		
		if(result1) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체가 아님.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("001","홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002","홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		
		if(result2) {
			
			System.out.println("논리(의미)적으로 동일한 객체임.");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체가 아님.");
		}
		
		p1.displayAll("키",180);
		
	}
	
}
