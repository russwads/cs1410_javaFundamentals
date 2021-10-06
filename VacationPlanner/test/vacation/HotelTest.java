package vacation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HotelTest {
	private void addHotelRooms(ArrayList<Room> rooms) {
		rooms.add(new Room(TypeBed.KING, View.STANDARD, 1, false));
		rooms.add(new Room(TypeBed.KING, View.POOLSIDE, 1, false));
		rooms.add(new Room(TypeBed.KING, View.LUXURY, 1, false));
		rooms.add(new Room(TypeBed.QUEEN, View.STANDARD, 2, false));
		rooms.add(new Room(TypeBed.QUEEN, View.POOLSIDE, 2, false));
		rooms.add(new Room(TypeBed.QUEEN, View.LUXURY, 2, false));
		rooms.add(new Room(TypeBed.DOUBLE, View.STANDARD, 2, false));
		rooms.add(new Room(TypeBed.DOUBLE, View.POOLSIDE, 2, false));
		rooms.add(new Room(TypeBed.DOUBLE, View.LUXURY, 2, false));
	}

	
	@Test
	void testTreatmentSpa() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		addHotelRooms(rooms);
		Hotel htl = new Hotel(rooms, "Disney Hotel", 400);
		Room r1 = new Room(TypeBed.KING, View.STANDARD, 1, false);
		htl.treatmentSpa();
		assertEquals(645.33, htl.getPrice(r1));
	}

	@Test
	void testTreatmentInternet() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		addHotelRooms(rooms);
		Hotel htl = new Hotel(rooms, "Disney Hotel", 300);
		Room r1 = new Room(TypeBed.QUEEN, View.POOLSIDE, 2, false);
		htl.treatmentInternet();
		assertEquals(650.34, htl.getPrice(r1));
	}

	@Test
	void testTreatmentRoomService() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		addHotelRooms(rooms);
		Hotel htl = new Hotel(rooms, "Disney Hotel", 1250);
		Room r1 = new Room(TypeBed.DOUBLE, View.LUXURY, 2, false);
		htl.treatmentRoomService();
		assertEquals(1907.00, htl.getPrice(r1));
	}
	
	@Test
	void testGetName() {
		Hotel htl = new Hotel(new ArrayList<Room>(), "Disney Hotel", 1250);
		assertEquals("Disney Hotel", htl.getName());
	}
	
	@Test
	void testGetPriceIllegalRoom() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		addHotelRooms(rooms);
		Hotel htl = new Hotel(rooms, "Disney Hotel", 1250);
		Room r1 = new Room(TypeBed.DOUBLE, View.LUXURY, 3, false);
		assertThrows(IllegalArgumentException.class, () -> {htl.getPrice(r1);});
	}

	@Test
	void testGetRoomsList() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		addHotelRooms(rooms);
		Hotel htl = new Hotel(rooms, "Disney Hotel", 1250);
		assertEquals(rooms,htl.getRoomsList());
	}

	@Test
	void testGetRoom() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		addHotelRooms(rooms);
		Hotel htl = new Hotel(rooms, "Disney Hotel", 1250);
		Room r1 = new Room(TypeBed.QUEEN, View.LUXURY, 2, false);
		assertEquals(r1, htl.getRoom(r1));
	}

}
