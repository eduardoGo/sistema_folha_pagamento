
package Card;

import DateHour.Date;
import DateHour.Hour;

public class DataCard {
	
	private Date date = null;
	private Hour hourStart = null;
	private Hour hourEnd = null;
	
	public DataCard() {
		
		this.date = new Date();
		this.hourStart = new Hour(1);
		this.hourEnd = new Hour(2);
		
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Hour getHourStart() {
		return hourStart;
	}

	public void setHourStart(Hour hourStart) {
		this.hourStart = hourStart;
	}

	public Hour getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(Hour hourEnd) {
		this.hourEnd = hourEnd;
	}
	
	
	
	

}
