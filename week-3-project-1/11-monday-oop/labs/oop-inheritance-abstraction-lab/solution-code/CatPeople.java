package AbstractionLab;

public class CatPeople extends Household {

	public CatPeople() {
		super(new Cat());
	}

	@Override
	public void gainIncome() {
		System.out.println("Sell dead mice");
		this.incomeGained += .5;
	}

	@Override
	public void throwGetTogether() {
		System.out.println("Throw boring dinner party.");
	}

}
