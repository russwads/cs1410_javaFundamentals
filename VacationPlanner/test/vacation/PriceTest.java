package vacation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {

	@Test
	void testAddMoneyIntInt() {
		Price p = new Price(100,100);
		p.addMoney(100, 100);
		assertEquals(202.00,p.getPrice());
	}

	@Test
	void testAddMoneyDouble() {
		Price p = new Price(100,100);
		p.addMoney(63.50);
		assertEquals(164.50,p.getPrice());
	}

	@Test
	void testAddMoneyPrice() {
		Price p1 = new Price(100,100);
		Price p2 = new Price(22,298);
		p1.addMoney(p2);
		assertEquals(125.98,p1.getPrice());
	}

	@Test
	void testGetPrice() {
		Double finish = 100.99;
		Price pr = new Price(100, 99);
		assertEquals(finish,pr.getPrice());
	}

}
