package Card;


import java.util.ArrayList;

import Employeer.Empregado;
import Employeer.PayedByHour;

public class Card {
	
	private ArrayList<DataCard> dates = new ArrayList<DataCard>();
	
	public void addPoint(Empregado employee) {
		
		DataCard dataCard = new DataCard();
		int workedHours = dataCard.getHourStart().getHour() - dataCard.getHourEnd().getHour();
		
		if(workedHours > 8
				&& employee instanceof PayedByHour)
			((PayedByHour) employee).addExtraHours(workedHours - 8);
		
		dates.add(dataCard);
		
	}
}
