package AbstractionLab;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Household> neighborhood = new ArrayList<>();
		neighborhood.add(new DogPeople());
		neighborhood.add(new CatPeople());
		
		for(Household household : neighborhood) {
			household.gainIncome();
			household.throwGetTogether();
			household.careForPet();
			household.payTaxes();
		}
	}

}
