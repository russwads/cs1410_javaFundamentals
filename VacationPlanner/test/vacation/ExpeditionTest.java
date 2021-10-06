package vacation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpeditionTest {

	@Test
	void testGetPrice() {
		Expedition e = new Expedition(2000.99, 4, "Tokyo");
		assertEquals(8003.96,e.getPrice());
	}

	@Test
	void testGetDays() {
		Expedition e = new Expedition(2000.99, 4, "Tokyo");
		assertEquals(4,e.getDays());
	}

	@Test
	void testGetPlace() {
		Expedition e = new Expedition(2000.99, 4, "Tokyo");
		System.out.println(e.toString());
		assertEquals("Tokyo",e.getPlace());
	}
	
	@Test
	void testEqualExpedition() {
		Expedition e = new Expedition(2000.99, 4, "Tokyo");
		assertTrue(e.equals(new Expedition(2000.99, 4, "Tokyo")));
		assertFalse(e.equals(new Expedition(2000.99, 4, "Tokyo DisneySea")));
	}
}
