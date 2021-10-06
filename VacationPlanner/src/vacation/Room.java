package vacation;

/**
 * Represents a room that the hotel can use to accommodate guests staying over select nights.
 * @author Russell
 *
 */
public class Room {
	private Price pr;
	private int beds;
	private TypeBed tb;
	private View vw;
	private boolean vacancy;
	
	/**
	 * Creates a room, given a specific bed type, room view, and number of beds. With these
	 * parameters, it calculates a price for the room and it will set whether or not the room
	 * is vacant in general.
	 * @param b type of the bed
	 * @param v room view
	 * @param num number of beds
	 * @param vacant boolean that either says true or false for vacancy
	 */
	public Room(TypeBed b, View v, int num, boolean vacant) {
		if (num > 4 || num < 1) {
			throw new IllegalArgumentException("The number of beds must be in between 1-4.");
		}
		beds = num;
		tb = b;
		vw = v;
		pr = new Price();
		calculatePrice();
		vacancy = vacant;
	}
	public Room() {
		pr = new Price();
		beds = 0;
		tb = TypeBed.DOUBLE;
		vw = View.STANDARD;
		vacancy = false;
	}
	/**
	 * Creates a room through a line. Used ONLY for creating rooms read in through files.
	 * @param line hotel room with comma separations
	 * @return Usable room for hotel
	 * @throws IllegalArgumentException Any illegal arguments get thrown and written into the error log.
	 * @throws ArrayIndexOutOfBoundsException Any illegal index entrances get thrown and written into the error log.
	 */
	public static Room getRoom(String line) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
		try  {
			String[] parts = line.split(",");
			TypeBed type = TypeBed.valueOf(parts[0]);
			View views = View.valueOf(parts[1]);
			int bedsInside = Integer.parseInt(parts[2]);
			boolean isItVacant = Boolean.parseBoolean(parts[3]);
			return new Room(type, views, bedsInside, isItVacant);
		} 
		catch (Exception e) {
			System.err.println("Error: " + line);
			return null;
		} 
	}
	/**
	 * Calculates the price for the room. Uses average rates denoted from research of
	 * the resorts used, and then adds on the dollars and cents to the price.
	 */
	private void calculatePrice() {
		int dollars = 0;
		int cents = 0;
		// Determining standard pricing for different hotel views
		if (vw == View.LUXURY) {
			dollars = dollars + 565;
		}
		else if (vw == View.POOLSIDE) {
			dollars = dollars + 249;
		}
		// Determining standard pricing for different types of beds
		// Also number of beds is calculated
		if (tb == TypeBed.KING) {
			dollars = dollars + (45 * beds);
			cents = cents + (33 * beds);
		}
		else if (tb == TypeBed.QUEEN) {
			dollars = dollars + (38 * beds);
			cents = cents + (17 * beds);
		}
		else {
			dollars = dollars + (31 * beds);
		}
		pr.addMoney(dollars, cents);
	}
	/**
	 * Retrieves the price for the hotel room. 
	 * @return
	 */
	public Double getPrice() {
		return pr.getPrice();
	}
	/**
	 * Retrieves the number of beds found in the room.
	 * @return
	 */
	public int getBeds() {
		return beds;
	}
	/**
	 * Retrieves the type of bed. The properties, from smallest to largest, include Twin,
	 * Double, Full, Queen, King, and California King.
	 * @return bed type
	 */
	public TypeBed getBedType() {
		return tb;
	}
	/**
	 * Retrieves the room view property. The properties include Standard, Pool-side, and 
	 * Luxury (this order is also from least expensive to most expensive).
	 * @return view
	 */
	public View getView() {
		return vw;
	}
	/**
	 * Sets the vacancy status as empty, or vacant, for the room.
	 * @param in the current vacancy status for the room
	 */
	public void makeVacant() {
		vacancy = true;
	}
	/**
	 * Sets the vacancy status as full (not vacant) for the room.
	 * @param in the current vacancy status for the room
	 */
	public void makeFull() {
		vacancy = false;
	}
	/**
	 * Returns the vacancy status of the room.
	 * @return vacancy
	 */
	public boolean isVacant() {
		return vacancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beds;
		result = prime * result + ((tb == null) ? 0 : tb.hashCode());
		result = prime * result + ((vw == null) ? 0 : vw.hashCode());
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
		Room other = (Room) obj;
		if (beds != other.beds)
			return false;
		if (tb != other.tb)
			return false;
		if (vw != other.vw)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Room: " + beds + " " + tb.toString() + "-size beds, with a " + vw.toString() + " view ";
	}
}
