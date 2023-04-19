package ch10_extends_interface.starcraft;

public class HighTemplar extends StarUnit {
	private int mp;

	public HighTemplar() {
		this("하이템플러", 0, 60, 0, 50);
	}

	public HighTemplar(String name, int damage, int hp, int armor, int mp) {
		super(name, damage, hp, armor);
		this.mp = mp;
	}


	public void thunderStorm() {
		mp -= 75;
		System.out.println("우르르 쾅쾅!!");
	}

	@Override
	public String toString() {
		return "HighTemplar [name=" + getName() + ", damage=" + getDamage() + ", hp=" + getHp() + ", armor="
				+ getArmor() + ", mp =" + mp + "]";
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

}
