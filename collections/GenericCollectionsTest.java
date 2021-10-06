package collections;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GenericCollectionsTest {
	// LETTERSANDNUMBERS TESTS
	
	@Test
	void lettersAndNumbers_SymbolsOnly() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('?');list.add('#');list.add('@');
		assertEquals(new ArrayList<String>(), GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_Null() {
		ArrayList<Character> list = null;
		assertEquals(null, GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_UpperCase() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('H');list.add('E');list.add('L');list.add('L');list.add('O');
		ArrayList<String> finished = new ArrayList<String>();
		finished.add("U(H)");finished.add("U(E)");finished.add("U(L)");finished.add("U(L)");finished.add("U(O)");
		assertEquals(finished, GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_LowerCase() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('w');list.add('o');list.add('r');list.add('l');list.add('d');
		ArrayList<String> finished = new ArrayList<String>();
		finished.add("L(w)");finished.add("L(o)");finished.add("L(r)");finished.add("L(l)");finished.add("L(d)");
		assertEquals(finished, GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_Numbers() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('1');list.add('2');list.add('4');list.add('8');list.add('0');
		ArrayList<String> finished = new ArrayList<String>();
		finished.add("N(1)");finished.add("N(2)");finished.add("N(4)");finished.add("N(8)");finished.add("N(0)");
		assertEquals(finished, GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_WhiteSpace() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add(' ');list.add(' ');list.add(' ');
		assertEquals(new ArrayList<String>(), GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_Mixed() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('H');list.add('3');list.add('l');list.add('&');list.add('0');list.add('R');
		ArrayList<String> finished = new ArrayList<String>();
		finished.add("U(H)");finished.add("N(3)");finished.add("L(l)");finished.add("N(0)");finished.add("U(R)");
		assertEquals(finished, GenericCollections.lettersAndNumbers(list));
	}
	
	@Test
	void lettersAndNumbers_Mixed2() {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('w');list.add('@');list.add('4');list.add('l');list.add('D');list.add(' ');list.add('h');
		ArrayList<String> finished = new ArrayList<String>();
		finished.add("L(w)");finished.add("N(4)");finished.add("L(l)");finished.add("U(D)");finished.add("L(h)");
		assertEquals(finished, GenericCollections.lettersAndNumbers(list));
	}
	
	// MODIFY TESTS
	
	@Test
	void modify_NullThrow() {
		assertThrows(IllegalArgumentException.class, () -> {GenericCollections.modify(null);});
	}
	
	@Test
	void modify_Empty() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 30};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		assertEquals(13,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	@Test
	void modify_AllMultiplesOf3() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] threes = {3,6,9,12,15,18,21,24,27,30,-3,-6,-9,-12,-15,-18};
		for (int i = 0; i < threes.length; i++) {
			list.add(threes[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 30};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		
		assertEquals(13,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	@Test
	void modify_Multiplesof4() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] number = {24,28,32,36,40};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 28, 30, 32, 40};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		
		assertEquals(16,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	@Test
	void modify_MultiplesOf5Backwards() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] number = {100,85,65,40,30,25,5};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {4, 5, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 25, 30, 40, 65, 85, 100};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		
		assertEquals(17,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	@Test
	void modify_NegativeNumbers() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] number = {-1,-2,-3,-4,-5};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {-5, -4, -2, -1, 4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 30};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		
		assertEquals(17,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	@Test
	void modify_Mixed() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] number = {-2256, 0, 1313};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 24, 25, 30, 1313};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		
		assertEquals(14,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	@Test
	void modify_Mixed2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] number = {22,44,66,88,1,4,9};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Integer[] lst = {1, 4, 4, 5, 6, 8, 10, 12, 12, 15, 16, 18, 20, 20, 22, 24, 25, 30, 44, 88};
		for (int i = 0; i < lst.length; i++) {
			answer.add(lst[i]);
		}
		
		assertEquals(17,GenericCollections.modify(list));
		assertEquals(answer, list);
	}
	
	// REMOVEEVERYNTHELEMENT TESTS
	
	@Test
	void removeEveryNthElement_Null() {
		ArrayList<Integer> list = null;
		assertThrows(IllegalArgumentException.class, () -> {GenericCollections.removeEveryNthElement(list, 1);});
	}
	
	@Test
	void removeEveryNthElement_ZeroN() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertThrows(IllegalArgumentException.class, () -> {GenericCollections.removeEveryNthElement(list, 0);});
	}
	
	@Test
	void removeEveryNthElement_NegativeN() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertThrows(IllegalArgumentException.class, () -> {GenericCollections.removeEveryNthElement(list, -1);});
	}
	
	@Test
	void removeEveryNthElement_EmptyList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		GenericCollections.removeEveryNthElement(list, 1);
		assertTrue(list.isEmpty());
	}
	
	@Test
	void removeEveryNthElement_Doubles() {
		ArrayList<Double> list = new ArrayList<Double>();
		Double[] number = {1.0,1.1,1.2,1.3,1.4,1.5,1.6};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		ArrayList<Double> answer = new ArrayList<Double>();
		Double[] num_ans = {1.0, 1.1, 1.3, 1.4, 1.6};
		for (int i = 0; i < num_ans.length; i++) {
			answer.add(num_ans[i]);
		}
		GenericCollections.removeEveryNthElement(list, 3);
		assertEquals(answer, list);
	}
	
	@Test
	void removeEveryNthElement_Integers() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer[] number = {1,6,3,78,328,50,73,69};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		GenericCollections.removeEveryNthElement(list, 1);
		assertEquals(answer, list);
	}
	
	@Test
	void removeEveryNthElement_Strings() {
		ArrayList<String> list = new ArrayList<String>();
		String[] number = {"Disney", "Theme", "parks", "are", "amazing", "to", "be", "at"};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		ArrayList<String> answer = new ArrayList<String>();
		String[] num_ans = {"Disney", "parks", "amazing", "be"};
		for (int i = 0; i < num_ans.length; i++) {
			answer.add(num_ans[i]);
		}
		GenericCollections.removeEveryNthElement(list, 2);
		assertEquals(answer, list);
	}
	
	@Test
	void removeEveryNthElement_Characters() {
		ArrayList<Character> list = new ArrayList<Character>();
		Character[] number = {'i','a','m','t','i','r','e','d'};
		for (int i = 0; i < number.length; i++) {
			list.add(number[i]);
		}
		ArrayList<Character> answer = new ArrayList<Character>();
		Character[] num_ans = {'i','a','m','i','r','e'};
		for (int i = 0; i < num_ans.length; i++) {
			answer.add(num_ans[i]);
		}
		GenericCollections.removeEveryNthElement(list, 4);
		assertEquals(answer, list);
	}
}
