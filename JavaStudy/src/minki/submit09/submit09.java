package minki.submit09;

import java.util.ArrayList;
import java.util.Collections;

public class submit09 {

	public static void main(String[] args) {
		Product refrigerator = new Product("냉장고", 2000000);
		Product tv = new Product("TV", 1000000);
		Product aircon = new Product("에어컨", 800000);
		Product computor = new Product("컴퓨터", 1300000);
		Product airfan = new Product("선풍기", 100000);

		// Q.02
		ArrayList<Product> List = new ArrayList<>();
		List.add(refrigerator);
		List.add(tv);
		List.add(aircon);
		List.add(computor);
		List.add(airfan);

		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i));
		}
		System.out.println("\n============================\n");

		// Q.03
		Collections.sort(List, (listA, listB) -> (listA.getPrice() - listB.getPrice() > 0) ? (1) : (-1));

		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i));
		}
		System.out.println("\n============================\n");

		// Q.04
		//indexOf()
		//ArrayList<String> ramen = ["신라면", "안성탕면"];
		//ramen.indexOf("안성탕면") = 1
		
		//ArrayList<Product> prodList = [Product객체(냉장고), Product(티비)]
		//prodList.indexOf("TV") = -1을 리턴함
		//System.out.println(prodList.indexOf(fan));
		
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i).getName().equals("TV")) {
				System.out.println(List.get(i).getName() + "의 인덱스는" + i);
				break;
			}
		}
		
		
	}

}
