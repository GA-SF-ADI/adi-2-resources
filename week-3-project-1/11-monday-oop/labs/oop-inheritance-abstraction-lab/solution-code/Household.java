package AbstractionLab;

import java.text.NumberFormat;

public abstract class Household {
	
	private final double TAX_RATE = .2;
	
	protected double incomeGained = 0;
	
	private IPet pet;
	
	public Household(IPet pet) {
		this.pet = pet;
	}
	
	public abstract void gainIncome();
	public abstract void throwGetTogether();
	
	public void payTaxes() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String incomeString = formatter.format(incomeGained);
		String taxString = formatter.format(incomeGained * TAX_RATE);
		System.out.println(String.format("Paid %s in taxes on %s in income.", taxString, incomeString));
	}
	
	public void careForPet() {
		pet.feed();
		pet.play();
		pet.groom();
	}
}
