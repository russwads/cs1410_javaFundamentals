package balogna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadixSortTest {
	RadixSort r = new RadixSort();

	@Test
	void testRadixsort() {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        r.radixsort(arr, n);
        assertEquals("2 24 45 66 75 90 170 802 ", r.print(arr, n));
	}

}
