package m04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Using generic collections to manipulate lists
 * @author Russell
 *
 */
public class Module04 {
	/**
	 * Manipulates a list of numbers through a series of calculations. Uses iterators to pass through
	 * methods and Generic Collection methods to complete these tasks:
	 * 1. Divide each number in the list by 10.
	 * 2. Removes each element that is less than 1.
	 * 3. Removes duplicate elements.
	 * 4. Rearranges the list in descending order (biggest number to smallest number).
	 * @param numbers any list of numbers
	 */
	public static void method1(ArrayList<Double> numbers) {
		// Divides each number by 10
		for (int i = 0; i < numbers.size(); i++) {
			Double e = numbers.get(0);
			e = e / 10;
			numbers.add(e);
			numbers.remove(0);
		}
		// Removes each number less than 1
		numbers.removeIf(x -> x < 1);
		// Removes duplicates
		HashSet<Double> duplicate = new HashSet<Double>();
		duplicate.addAll(numbers);
		numbers.clear();
		numbers.addAll(duplicate);
		// Rearranges numbers in descending order
		Collections.sort(numbers);
		Collections.reverse(numbers);
	}
	
	/**
	 * Creates strings of binary representations of numbers, after said numbers were shuffled, and 
	 * removes all strings with a size over 10 characters.  
	 * @param elements list of numbers
	 * @return list of binary representations of numbers
	 */
	public static ArrayList<String> method2 (ArrayList<Integer> elements) {
		ArrayList<String> rtn = new ArrayList<String>();
		// Shift all elements one position to the left; first element to end of the list; repeats 3 times
		if (elements.isEmpty()) {
			return rtn;
		}
		for (int i = 0; i < 3; i++) {
			Integer first = elements.get(0);
			elements.remove(0);
			elements.add(first);
		}
		// Creates strings of binary representations for each number in the list
		for (int i = 0; i < elements.size(); i++) {
			rtn.add(Integer.toBinaryString(elements.get(i)));
		}
		// Removes all strings longer than 10 characters
		rtn.removeIf((n) -> n.length() > 10);
		return rtn;
	}
}