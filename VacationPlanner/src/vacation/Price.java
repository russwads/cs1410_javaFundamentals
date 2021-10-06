package vacation;

import java.util.ArrayList;
import java.util.List;

/**
 * The representation of a price, denoted by dollars and cents.
 * @author Russell
 *
 */
public class Price {
	private int dollars;
	private int cents;
	/**
	 * Returns dollars as an integer. Used through in-class members only.
	 * @return dollars
	 */
	private int getDollars() {
		return dollars;
	}
	/**
	 * Returns cents as an integer. Used through in-class members only.
	 * @return cents
	 */
	private int getCents() {
		return cents;
	}
	/**
	 * Converts cents to dollars when the cents are over 100. Used through in-class members
	 * only.
	 */
	private void centsToDollars() {
		if (cents > 999) {
			throw new IllegalArgumentException("Error in cent parse. Terminate program, and "
					+ "instigate the vacation input file for errors.");
		}
		else if (cents >= 100) {
			String finish = Integer.toString(cents);
			List<Character> characters = new ArrayList<Character>();
			for (int i = 0; i < finish.length(); i++) {
				characters.add(finish.charAt(i));
			}
			int dollar = Character.getNumericValue(characters.get(0));
			characters.remove(0);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < characters.size(); i++) {
				sb.append(characters.get(i));
			}
			int cent = Integer.parseInt(sb.toString());
			dollars = dollars + dollar;
			cents = cent;
		}
	}

	/**
	 * Creates a price. Price is split up between two properties: dollars and cents.
	 * @param dollar integer of the dollars property
	 * @param cent integer of the cents property
	 */
	public Price(int dollar, int cent) {
		this.dollars = dollar;
		this.cents = cent;
	}
	/**
	 * Creates a price value where there is zero dollars and zero cents.
	 */
	public Price() {
		dollars = 0;
		cents = 0;
	}
	/**
	 * Adds dollars and cents to a price. 
	 * @param dollar dollars in a price
	 * @param cent cents in a price
	 */
	public void addMoney(int dollar, int cent) {
		dollars = dollars + dollar;
		cents = cents + cent;
		centsToDollars();
	}
	/**
	 * Adds money presently represented by a Double property. This function splits up the 
	 * dollars and cents accordingly, so the price can accurately reflect each property.
	 * @param pr price, as represented by a "double"
	 */
	public void addMoney(double pr) {
		// Convert to string to split up dollars and cents
		String doub = Double.toString(pr);
		int point = doub.indexOf('.');
		String d = doub.substring(0, point);
		String c = doub.substring(point + 1);
		if (c.length() == 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(c).append("0");
			c = sb.toString();
		}
		int dollar = Integer.parseInt(d);
		int cent = Integer.parseInt(c);
		// The actual adding of the money 
		dollars = dollars + dollar;
		cents = cents + cent;
		centsToDollars();
	}
	/**
	 * Adds money to existing price by using another Price. It extracts dollars and cents
	 * using private methods, and adds these together, again checking cents to dollars.
	 * @param pr price of another object
	 */
	public void addMoney(Price pr) {
		int dollar = pr.getDollars();
		int cent = pr.getCents();
		dollars = dollars + dollar;
		cents = cents + cent;
		centsToDollars();
	}
	/**
	 * Retrieves the price of the object and turns it into a Double value.
	 * @return price as represented by a double
	 */
	public Double getPrice() {
		StringBuilder sb = new StringBuilder();
		sb.append(dollars).append('.');
		sb.append(String.format("%02d", cents));
		String finish = sb.toString();
		Double f = Double.parseDouble(finish);
		return Math.round(f * 100.0) / 100.0;
	}
}
