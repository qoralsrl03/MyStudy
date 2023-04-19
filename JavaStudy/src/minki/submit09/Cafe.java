package minki.submit09;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
	private String name;
	private ArrayList<Coffee> menuList;

	public Cafe() {
	}

	public Cafe(String name) {
		this.name = name;
		menuList = new ArrayList<>(); // 어레이 리스트 같은 경우의 객체 선언은 맨위 필드 딴에서 해도 상관없음
	}

	// 커피 메뉴를 추가한다.
	public void addCoffee(Coffee cf) {
		menuList.add(cf);
	}

	// 메뉴판을 출력하는 메소
	public void showMenu() {
		for (int i = 0; i < menuList.size(); i++) {
			System.out.println((i + 1) + ". " + menuList.get(i));
		}
	}

	// 커피 구매
	public void buyCoffee(Scanner sc) {
		System.out.println("메뉴를 선택해 주세요:");
		int choice = Integer.parseInt(sc.nextLine()) - 1;

		System.out.println(menuList.get(choice).getName() + "를" + menuList.get(choice).getPrice() + "원에 구매했습니다.");

	}

	public Cafe(String name, ArrayList<Coffee> menuList) {
		super();
		this.name = name;
		this.menuList = menuList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Coffee> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Coffee> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "Cafe [name=" + name + ", menuList=" + menuList + "]";
	}

}
