package ch10_extends_interface.lol;

public class Amumu extends Champion implements SkillInterface{

	
	public Amumu() {
		super();
	}

	public Amumu(String name, int damage, int hp) {
		super(name, damage, hp);
	}

	@Override
	public void skillQ() {
		System.out.println();
	}

	@Override
	public void skillW() {
		System.out.println();
	}

	@Override
	public void skillE() {
		System.out.println();
	}

	@Override
	public void skillR() {
		System.out.println();
	}


}
