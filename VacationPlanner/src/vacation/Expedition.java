package vacation;

/**
 * Represents a destination that causes the user to book the hotel excursion anyway.
 * @author Russell
 *
 */
public class Expedition{
	private Price pr;
	private int days;
	private String place;
	
	/**
	 * Creates an expedition with specific properties. Uses a daily price and number of days
	 * to calculate the final price of the expedition. Name of the expedition is also
	 * denoted.
	 * @param price price per day of the expedition
	 * @param daysIn number of days on the expedition
	 * @param placeIn the name of the expedition
	 */
	public Expedition(double price, int daysIn, String placeIn) {
		days = daysIn;
		place = placeIn;
		pr = new Price();
		pr.addMoney(price);
	}
	public Expedition() {
		days = 0;
		place = "<unselected>";
		pr = new Price();
	}
	/**
	 * Retrieves the price for the expedition.
	 * @return
	 */
	public Double getPrice() {
		return pr.getPrice();
	}
	/**
	 * Retrieves the number of days during the excursion.
	 * @return
	 */
	public int getDays() {
		return days;
	}
	/**
	 * Retrieves the name of the expedition place.
	 * @return
	 */
	public String getPlace() {
		return place;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expedition other = (Expedition) obj;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Expedition: " + place + " for " + days + " days";
	}
}
