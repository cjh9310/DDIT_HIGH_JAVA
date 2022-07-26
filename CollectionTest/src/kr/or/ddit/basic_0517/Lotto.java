package kr.or.ddit.basic_0517;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("==================================");
		System.out.println("Lotto 프로그램");
		System.out.println("------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==================================");
		System.out.print("메뉴선택 : ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1 :
			System.out.print("금액 입력 : ");
		int money = sc.nextInt();
		int LottoM =1000;
		int number = 0;
		int change =0;
		int arr[] = new int[6];
		if(money/LottoM !=0 ) {
			number =(int)(money/LottoM);
			System.out.println(number);
		}
		Set hs1 = new HashSet();
		Iterator Lotto = hs1.iterator();
		
		while(Lotto.hasNext()) {
			System.out.println(Lotto.next());
		}
		
		for(int i=0; i<number; i++) {
			Random ran = new Random();
			//Set<Integer> Random = new HashSet<Integer>();
			TreeSet<Integer> Random = new TreeSet<Integer>();
			while(Random.size()<6) {
				int num = (int) (Math.random()*25+1);
				Random.add(num);
				List<Integer> resultList = new ArrayList<Integer>();
				 resultList = new ArrayList<Integer>(Random);
				 
		}
			
			
			
			
			List<Integer> numRandom = new ArrayList<Integer>(Random);
		for(Integer num : numRandom) {
			System.out.print(num+" ");
		}
		System.out.println();
		}
		System.out.println();
		change = money%LottoM;
		System.out.println("받은 금액은 " + money+ "이고 거스름돈은 " + change + " 입니다.");
		
		
		case 2:
			
			System.out.println("감사합니다.");
		}
		break;
		}
	}
}