package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Horse {
	static int Ranks =1;
	public static void main(String[] args) {
		List<Horses> list = new ArrayList<>();
		list.add(new Horses("1번마"));
		list.add(new Horses("2번마"));
		list.add(new Horses("3번마"));
		list.add(new Horses("4번마"));
		list.add(new Horses("5번마"));
		list.add(new Horses("6번마"));
		list.add(new Horses("7번마"));
		list.add(new Horses("8번마"));
		list.add(new Horses("9번마"));
		list.add(new Horses("10번마"));
		
		for(Horses h : list) {
			h.start();
		}
		for (Horses hs : list) {
			try {
				hs.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
		Collections.sort(list); // 등수 기준으로 정렬
		System.out.println("경기 끝");
		System.out.println("=====================");
		System.out.println();
		System.out.println("경기 결과");
		
		for(Horses h : list) {
			System.out.println(h.getHname()	 + " " + h.getRank() + "등");
		}
}

}
class Horses extends Thread implements Comparable<Horses>{
	String Hname ;
	int rank;
	public Horses(String name) {
		
		this.Hname = name;
		
	}
	public String getHname() {
		return Hname;
	}
	public void setHname(String hname) {
		Hname = hname;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=50; i++) {
			System.out.println("\n" + Hname);
			for(int j=0; j<i; j++) {
				System.out.print("-");
			}
			System.out.print(">");
			for(int k=49; k>i; k--) {
				System.out.print("-");
			}
			System.out.println();
			System.out.println();
			try {
				Thread.sleep((int) (Math.random() * 200)); //랜덤 도착
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
		}
		System.out.println(Hname+ "도착");
		setRank(Horse.Ranks);
		Horse.Ranks++;
		
	}
		@Override //랭킹
		public int compareTo(Horses H) {
			if(rank > H.getRank()) {
				return 1;
			}else {
				return -1;	
			}
		}
	
}