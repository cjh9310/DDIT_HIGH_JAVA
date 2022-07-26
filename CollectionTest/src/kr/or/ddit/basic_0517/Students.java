package kr.or.ddit.basic_0517;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Students {
	
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();
		memList.add(new Member("2019","정윤상",55,65,75));
		memList.add(new Member("2022","황도연",65,65,65));
		memList.add(new Member("2017","정종운",75,55,43));
		memList.add(new Member("2014","김진",55,30,75));
		System.out.println("정렬 전 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------");
		System.out.println("정렬 후 : ");
		Collections.sort(memList);
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------");
		Collections.sort(memList, new SortNum());
		System.out.println("총점 동일 (학번의 내림차순) : ");
		for(Member mem : memList) {
			System.out.println(mem);		
		
	}
		
		System.out.println("끝");
	}
}

class SortNum implements Comparator<Member>{

	@Override
	public int compare(Member SN1, Member SN2) {
		if(SN1.getSum() == SN2.getSum()){
			return 0;
		}else {
			return -1;
		}
			
	}	
}

class Member implements Comparable<Member>{
	private String studentNum;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int num;
	private int Rank;
	private int count;
	private int[] rank;



	public Member(String studentNum, String name, int kor, int eng, int math) {
		super();
		this.studentNum = studentNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		count++;
		
	}

	public String getStudentNum() {
		return studentNum;
		
	}
	public int getStudentNum1() {
		return Integer.parseInt(studentNum);
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public int getNum() {
		
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSum() {
		return kor+eng+math;
	}

	public void setSum(int sum) {
		this.sum = kor+eng+math;
		
	}

	public int getRank() {
		return Rank;
		
	}

	public void setRank(Member mem) {
		int[] result = new int[count];
		
		for(int i=0; i<count; i ++) {
			 int cnt= 1;
			for(int j=0; j<count; j++) {
				if(rank[i]>rank[j]) {
					cnt++;
				}
			}
			result[i]=cnt;
			Rank = result[i];
		}
	}

	@Override
	public int compareTo(Member mem) {
		return this.getStudentNum().compareTo(mem.getStudentNum()); // 오름차순
	}

	@Override
	public String toString() {
		return "Member [studentNum=" + studentNum + ", name=" + name + ", kor=" + kor + ", Eng=" + eng + ", math="
				+ math + " sum="+getSum()+" num=" + getRank()+ "]";
	}



}
