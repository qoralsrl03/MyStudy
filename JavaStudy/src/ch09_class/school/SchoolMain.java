package ch09_class.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch09_class.commons.UtilClass;
import ch09_class.nextit.NextStudent;

public class SchoolMain {
	public static void main(String[] args) {
		// 이름, 국어, 영어, 수학, 평균 점수를 가지는 학생 객체
		Student yesl = new Student("예슬",85, 80, 87);
		System.out.println(yesl);
	
		//	캡슐화 적용
		// 같은 폴더 내에 있는 클래스라면 private 빼곤 다 접근가능
		System.out.println(yesl.getKorean());
		
		//	avg에 대한 Setter를 지워서 평균은 수정할 수 없도록 함
//		yesl.setAvg(100);
		System.out.println(yesl);
		
		System.out.println(yesl.getKorean());
		System.out.println(yesl.getAvg());
		
		// 국어 점수 바꾸기
		yesl.setKorean(93);
		System.out.println(yesl);
		
		//평균을 넣지 않아도 출력되는 생성자 출력
		System.out.println("\n==========================\n");
		Student hyera = new Student("혜라",90,80,87);
		System.out.println(hyera);
		
		hyera.setEnglish(87);
		System.out.println(hyera);
		
		System.out.println("\n=================================\n");
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(yesl);
		stuList.add(hyera);
		stuList.add(new Student("뭘봐",80,81,82));
		stuList.add(new Student("동우",91,90,99));
		
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
		
		System.out.println("\n==============================\n");
		//학생들의 평균을 이용해서
		//1등. 혜라--
		//2등. ~
		/*
		for (int k = 0; k < stuList.size() - 1; k++) {
			for (int i = 0; i < stuList.size() - 1; i++) {
				if (stuList.get(i).getAvg() > stuList.get(i + 1).getAvg()) {
					Student t = stuList.get(i);
					stuList.set(i, stuList.get(i + 1));
					stuList.set(i + 1, t);
				}
			}
		}*/
		UtilClass.BubbleSort(stuList);
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(i + 1 + ". " + stuList.get(i));
		}
		System.out.println("\n===========================\n");
		
		Collections.sort(stuList, new Comparator<Student>() {

			@Override
			public int compare(Student stuA, Student stuB) {
				double diff = stuA.getAvg() - stuB.getAvg();
				if(diff<0) {
					//음의 정수
					return -1;
				}
				return 1;
			}
		});
		;
		Collections.sort(stuList,(stuA,stuB) -> (stuB.getAvg() - stuA.getAvg()>0) ? (1):(-1));
		
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(i + 1 + ". " + stuList.get(i));
		}
	}
	
	
}
