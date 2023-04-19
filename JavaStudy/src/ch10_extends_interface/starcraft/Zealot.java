package ch10_extends_interface.starcraft;

public class Zealot extends StarUnit {
	private int shield;

	public Zealot() {
		this("질럿", 16, 100, 1, 60);
	}

	public Zealot(String name, int damage, int hp, int armor, int shield) {
		super(name, damage, hp, armor);
		this.shield = shield; 
	}

	public void move(int x, int y) {
		System.out.println("X: " + x + ", y: " + y + "로 이동");
	}

	public void stimpack() {
		System.out.println("으아아아");

		super.setHp(super.getHp() - 10);
		super.setDamage(super.getDamage() * 2);
	}

	@Override
	public String toString() {
		return "Zealot [name=" + getName() + ", damage=" + getDamage() + ", hp=" + getHp() + ", armor=" + getArmor()
				+ ", shield=" + shield + "]";
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

}
