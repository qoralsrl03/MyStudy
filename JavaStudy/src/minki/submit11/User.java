package minki.submit11;

import java.util.Scanner;

public class User {
	private int x = 0, y = 0;

	public User() {
	}

	int convertInput(String choice) {
		// 입력받은 이동에 맞춰 x,y값을 1을 증감시켜준다.
		if (choice.equals("a")) {
			this.setY(getY() - 1);
			return getY();
		} else if (choice.equals("s")) {
			this.setX(getX() + 1);
			return getX();
		} else if (choice.equals("w")) {
			this.setX(getX() - 1);
			return getX();
		} else if (choice.equals("d")) {
			this.setY(getY() + 1);
			return getY();
		} else {
			System.out.println("");
			return 0;
		}
	}

	int reverseInput(String choice) {
		// 입력받은 이동에 맞춰 x,y값을 1을 증감시켜준다.
		if (choice.equals("a")) {
			this.setY(getY() + 1);
			return getY();
		} else if (choice.equals("s")) {
			this.setX(getX() - 1);
			return getX();
		} else if (choice.equals("w")) {
			this.setX(getX() + 1);
			return getX();
		} else if (choice.equals("d")) {
			this.setY(getY() - 1);
			return getY();
		} else {
			System.out.println("");
			return 0;
		}
	}

	int reverseShape(String choice) {
		// 입력받은 이동에 맞춰 x,y값을 1을 증감시켜준다.
		if (choice.equals("a")) {
			return getY()+1;
		} else if (choice.equals("s")) {
			return getX()-1;
		} else if (choice.equals("w")) {
			return getX()+1;
		} else if (choice.equals("d")) {
			return getY()-1;
		} else {
			System.out.println("");
			return 0;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char shape() {
		return '⛄';
	}

}
