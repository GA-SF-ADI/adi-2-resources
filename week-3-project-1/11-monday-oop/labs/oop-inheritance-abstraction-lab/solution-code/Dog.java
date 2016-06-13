package AbstractionLab;

public class Dog implements IPet {

	@Override
	public void feed() {
		System.out.println("Eat Kibble");
	}

	@Override
	public void play() {
		System.out.println("Play fetch");
	}

	@Override
	public void groom() {
		System.out.println("Brush fur");
	}
	
}
