package vacation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testGetPriceKingStandard() {
		Double finish = 45.33;
		Room r = new Room(TypeBed.KING, View.STANDARD, 1, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceKingPoolside() {
		Double finish = 339.66;
		Room r = new Room(TypeBed.KING, View.POOLSIDE, 2, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceKingLuxury() {
		Double finish = 700.99;
		Room r = new Room(TypeBed.KING, View.LUXURY, 3, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceQueenStandard() {
		Double finish = 76.34;
		Room r = new Room(TypeBed.QUEEN, View.STANDARD, 2, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceQueenPoolside() {
		Double finish = 287.17;
		Room r = new Room(TypeBed.QUEEN, View.POOLSIDE, 1, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceQueenLuxury() {
		Double finish = 717.68;
		Room r = new Room(TypeBed.QUEEN, View.LUXURY, 4, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceDoubleStandard() {
		Double finish = 31.0;
		Room r = new Room(TypeBed.DOUBLE, View.STANDARD, 1, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceDoublePoolside() {
		Double finish = 311.0;
		Room r = new Room(TypeBed.DOUBLE, View.POOLSIDE, 2, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceDoubleLuxury() {
		Double finish = 658.0;
		Room r = new Room(TypeBed.DOUBLE, View.LUXURY, 3, false);
		assertEquals(finish,r.getPrice());
	}
	
	@Test
	void testGetPriceTooManyBeds() {
		assertThrows(IllegalArgumentException.class, () -> {new Room(TypeBed.DOUBLE, View.LUXURY, 5, false);});
	}
	
	@Test
	void testGetPriceZeroBeds() {
		assertThrows(IllegalArgumentException.class, () -> {new Room(TypeBed.DOUBLE, View.LUXURY, 0, false);});
	}

	@Test
	void testGetBeds() {
		Room r = new Room(TypeBed.DOUBLE, View.LUXURY, 3, false);
		System.out.println(r.toString());
		assertEquals(3, r.getBeds());
	}

	@Test
	void testGetBedType() {
		Room r = new Room(TypeBed.DOUBLE, View.LUXURY, 3, false);
		assertEquals(TypeBed.DOUBLE, r.getBedType());
	}

	@Test
	void testGetView() {
		Room r = new Room(TypeBed.DOUBLE, View.LUXURY, 3, false);
		assertEquals(View.LUXURY, r.getView());
	}

	@Test
	void testVacancy() {
		Room r = new Room(TypeBed.DOUBLE, View.LUXURY, 3, false);
		assertFalse(r.isVacant());
		r.makeVacant();
		assertTrue(r.isVacant());
		r.makeFull();
		assertFalse(r.isVacant());
	}
}
