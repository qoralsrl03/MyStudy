package ch10_extends_interface.starcraft;

public class Marine extends StarUnit {

	public Marine() {
		this("마린", 6, 50, 0);
	}

	public Marine(String name, int damage, int hp, int armor) {
		super(name, damage, hp, armor);
		super.setName(name);// 이런식으로도 가능하지만 super에서 한번에 처리하는게 훨 나음
	}

	public void move(int x, int y) {
		super.move(x, y);
	}

	public void stimpack() {
		System.out.println("우아아아아");

		super.setHp(super.getHp() - 10);
		super.setDamage(super.getDamage() * 2);
	}

	@Override
	public String toString() { // get 메소드들이 public이기 때문에 굳이 super로 접근을 안해도 가능함
		return "Marine [name=" + super.getName() + ", damage=" + super.getDamage() + ", hp=" + getHp() + ", armor="
				+ getArmor() + "]";
	}

	public void attack(StarUnit unit) {
		unit.setHp(unit.getHp() - super.getDamage());
	}

}
