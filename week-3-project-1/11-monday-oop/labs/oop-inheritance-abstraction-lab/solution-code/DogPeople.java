package AbstractionLab;

public class DogPeople extends Household {

	public DogPeople() {
		super(new Dog());
	}

	@Override
	public void gainIncome() {
		System.out.println("Allow people to play with dog.");
		this.incomeGained += 200;
		System.out.println("Accept donations from admirers of dog.");
		this.incomeGained += 200;
	}

	@Override
	public void throwGetTogether() {
		System.out.println("Throw awesome barbecue. Everybody plays with dog.");
		this.incomeGained += 150; //subtract cost of food
	}

}
