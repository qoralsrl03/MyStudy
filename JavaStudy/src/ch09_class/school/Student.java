package ch09_class.school;

import ch09_class.commons.UtilClass;

public class Student {
	// 1. 필드 변수 선언
	// 접근 제어자
	// public : 공개, 프로젝트 내부 어디서든 접근 가능
	// private : 비공개, 현재 클래스 내에서만 접근 가능
	// default(생략가능) : 같은 폴더 내에 있는 클래스에서만 접근 가능
	// 캡슐화는 필드 변수 접근제어자를 전부 private으로 만든다.
	private String name;
	private int korean, english, math;
	private double avg;

	public Student() {
	}

	public Student(String name, int korean, int english, int math) {
		setKorean(korean);
		setName(name);
		setEnglish(english);
		setMath(math);
		setAvg();
	}
	
	// 변경된 점수에 대해 평균을 고치는 메소드
	// 현재 클래스 내부에서만 사용되므로 private을 사용한다.
	private void setAvg() {
		avg = UtilClass.weRound((getKorean() + getEnglish() + getMath())/3,2);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
		setAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		setAvg();
	}

	public double getAvg() {
		return avg;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
		setAvg();
	}
	
	@Override
	public String toString() {
		return "[" + name + ", korean=" + getKorean() + ", english=" + getEnglish() + ", math=" + getMath() + ", avg=" + getAvg()
				+ "]";
	}
	
	// private으로 접근을 막은 필드변수에 대해
	// Getters and Setter로 접근을 허용한다.
	// 단축키[Alt + Shift + S]
	// Generate getters and setters
	
	
}
