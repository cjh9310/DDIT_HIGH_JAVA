package kr.or.ddit.basic;

class NonGClass{
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

}

class MyGeneric<T>{
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}
public class T02G{
	public static void main(String[] args) {
		NonGClass ng1 = new NonGClass();
		ng1.setVal("정윤상바보");
		
		NonGClass ng2 = new NonGClass();
		ng1.setVal("1234");
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 : " + rtnVal1);
		
		Integer rtnVal2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 rtnNg2 : " + rtnVal2);
		System.out.println();
		
		
		// 그떄마다 원하는 타입 바꾸는 법
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}


