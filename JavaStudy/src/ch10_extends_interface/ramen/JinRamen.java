package ch10_extends_interface.ramen;

public class JinRamen extends Ramen{
	String name;
	int price;


	public JinRamen(String name, int price) {
		super(name, price);
	}


	@Override
	public void printRecipe() {
		System.out.println("끓은 물에 면과 스프를 넣고 3분후에 드세요");
	}

}
