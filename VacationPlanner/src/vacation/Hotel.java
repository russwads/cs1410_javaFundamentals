package vacation;

import java.util.ArrayList;

/**
 * A luxury hotel with amenities and rooms. Picking a hotel will require the user to pick a 
 * room as well. Picking amenities will increase the price of the hotel. 
 * The price of the hotel is the price of amenities plus the price of the room.
 * @author Russell
 *
 */
public class Hotel{
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private String name = "";
	private Price pr;
	
	/**
	 * As read into the program, this should create a hotel's properties from a file. The 
	 * name, list of rooms, and generic price will go into the properties.
	 * @param roomIn list of rooms going into the hotel
	 * @param nameIn name of the hotel
	 * @param price price of the hotel
	 */
	public Hotel(ArrayList<Room> roomIn, String nameIn, double price) {
		if (roomIn == null) {throw new NullPointerException("List is empty or was not made.");}
		for (int i = 0; i < roomIn.size(); i++) {
			rooms.add(roomIn.get(i));
		}
		name = nameIn;
		pr = new Price();
		pr.addMoney(price);
	}
	public Hotel() {
		pr = new Price();
	}
	/**
	 * Adds a spa treatment to the price to the hotel.
	 */
	public void treatmentSpa() {
		pr.addMoney(200.00);
	}
	/**
	 * Adds internet usage to the price to the hotel.
	 */
	public void treatmentInternet() {
		pr.addMoney(25.00);
	}
	/**
	 * Adds room service treatment to the price of the hotel.
	 */
	public void treatmentRoomService() {
		pr.addMoney(30.00);
	}
	/**
	 * Returns the price of the hotel. This includes the price of the room.
	 * @param r1 room
	 * @return price
	 */
	public Double getPrice(Room r1) {
		Double htlprice = pr.getPrice();
		int j = 0;
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).equals(r1)) {
				j = i;
				break;
			}
			else if (i + 1 == rooms.size()) {
				throw new IllegalArgumentException("The room you're looking for is not in this list.");
			}
			else {
				continue;
			}
		}
		
		Double rmprice = rooms.get(j).getPrice();
		return Math.round((htlprice + rmprice) * 100.0) / 100.0;
	}
	/**
	 * Returns the name of the hotel. 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns an array list of rooms provided by the hotel.
	 * @return
	 */
	public ArrayList<Room> getRoomsList() {
		return rooms;
	}
	/**
	 * Retrieves a room that matches the room looking for.
	 * @param r1 desired room
	 * @return
	 */
	public Room getRoom(Room r1) {
		for (int i = 0; i < rooms.size(); i++) {
			if (r1.equals(rooms.get(i))) {
				return rooms.get(i);
			}
			else {
				continue;
			}
		}
		return null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Hotel other = (Hotel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Hotel: " + name;
	}
}
