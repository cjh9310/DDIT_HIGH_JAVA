package kr.or.ddit.basic_0517;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class i {
	  public static void main(String[] args) {
		   
		   List<Student> memList = new ArrayList<Student>();
		   memList.add(new Student("202201","이은정",100,100,100));
		   memList.add(new Student("202202","가나다",80,40,100));
		   memList.add(new Student("202203","홍길동",90,100,50));
		   memList.add(new Student("202204","이순신",100,100,100));
		   memList.add(new Student("202205","변학도",20,80,80));
		   
		/*   int rank=1;
		   memList.get(0).setRank(1);
		   for(int i=0;i<memList.size();i++) {
		      memList.get(i).setRank(rank);
		   }
		*/   
		    System.out.println("정렬전:");
		    for (Student mem : memList) {
		       System.out.println(mem);
		    }
		    System.out.println("-------------------------------");

		    Collections.sort(memList);
		    System.out.println("정렬 후(학번의 오름차순) :");
		    //정렬이후 rank함수 호출하여 정렬 순서대로 랭크 입력
		    rank(memList);
		    for (Student mem : memList) {
		       System.out.println(mem);
		    }
		    System.out.println("-----------------------");
		    Collections.sort(memList, new SortTotalDesc());
		    
		    //정렬이후 rank함수 호출하여 정렬 순서대로 랭크 입력
		    rank(memList);
		    System.out.println("정렬 후(총점의 내림차순) :");
		    for (Student mem : memList) {
		       System.out.println(mem);
		    }
		   }
	  
		   //정렬된 리스트를 파라미터로 받고, student rank setter로 랭크값을 지정함
		   public static void rank(List<Student> memList) {
		      int rank = 1;
		       for(Student s : memList) {
		         s.setRank(rank);
		          rank++;
		            }
		   }
		   
		}

		class SortTotalDesc implements Comparator<Student> {
		      @Override
		      public int compare(Student mem1, Student mem2) {
		        //총점이 같을경우 학번순으로 한번 더 정렬해서 return해줌
		        if(mem1.total() == mem2.total()) {
		           return mem1.getNum().compareTo(mem2.getNum()) * -1;
		        }
		        else
		         return Integer.compare(mem1.total(), mem2.total()) * -1;
		      }
		   }



		class Student implements Comparable<Student>{
		   private String num;
		   private String name;
		   private int kor;
		   private int eng;
		   private int math;
		   private int total;
		   private int rank;
		   
		   public String getNum() {
		      return num;
		   }

		   public void setNum(String num) {
		      this.num = num;
		   }

		   public String getName() {
		      return name;
		   }

		   public void setName(String name) {
		      this.name = name;
		   }

		   public int getKor() {
		      return kor;
		   }

		   public void setKor(int kor) {
		      this.kor = kor;
		   }

		   public int getEng() {
		      return eng;
		   }

		   public void setEng(int eng) {
		      this.eng = eng;
		   }

		   public int getMath() {
		      return math;
		   }

		   public void setMath(int math) {
		      this.math = math;
		   }
		   
		   public int getRank() {
		      return rank;
		   }
		   public void setRank(int rank) {
		      this.rank = rank;
		   }

		   public Student(String num, String name, int kor, int eng, int math) {
		      super();
		      this.num = num;
		      this.name = name;
		      this.kor = kor;
		      this.eng = eng;
		      this.math = math;
		      total();
		   }

		   public int total() {
		      this.total = kor+eng+math;
		      return total;   
		   }
		   

		   @Override
		   public String toString() {
		      return "Student [num=" + num + ", name=" + name + ", Kor=" + kor + ", Eng=" + eng + ", Math=" + math
		            + ", total=" + total + ", rank=" + rank + "]";
		   }
		   
		    @Override
		      public int compareTo(Student mem) {

		         return this.getNum().compareTo(mem.getNum());
		      }
		}

