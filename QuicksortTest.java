package balogna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuicksortTest {
	Quicksort q = new Quicksort();

	@Test
	void testQuickSort() {
		assertEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, q.getArr());
	}

}
