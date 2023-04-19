package ch10_extends_interface.simple;

public class SimpleMain {

	public static void main(String[] args) {
		Parent papa = new Parent("아빠", 50);
		System.out.println(papa);

		Child baby = new Child();
		System.out.println(baby);
		
		baby.setName("아기");
		baby.setAge(3);
		baby.sayHello();
		//상속받더라도 private으로 선언한건 상속받지 못함
		
		//다형성 
		Parent nami = new Child("나미", 17);
		System.out.println(nami.getClass());
		nami.sayHello();
	
	
	}
}
