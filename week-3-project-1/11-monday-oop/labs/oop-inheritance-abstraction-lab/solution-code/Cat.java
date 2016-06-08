package AbstractionLab;

public class Cat implements IPet {

	@Override
	public void feed() {
		System.out.println("Eat dead mouse while glaring at owner.");
	}

	@Override
	public void play() {
		System.out.println("Bat yarn while glaring at owner.");
	}

	@Override
	public void groom() {
		System.out.println("Lick self while glaring at owner.");
	}
}
