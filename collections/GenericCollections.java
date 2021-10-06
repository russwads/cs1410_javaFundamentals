package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * A class devoted to explaining and demonstrating the power of collections
 * @author Russell
 *
 */
public class GenericCollections {
	/**
	 * Creates a new list. If the character is uppercase, the string is "U(#)". If the character is
	 * lowercase, the string is "L(#)". If the character is a number, the string is "N(#)". If
	 * the character is anything else, the character is ignored and the function continues.
	 * @param list list of characters
	 * @return
	 */
	public static List<String> lettersAndNumbers(List<Character> list) {
		if (list == null) {return null;}
		List<String> rtn = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (Character.isLetter(list.get(i))) {
				if (Character.isUpperCase(list.get(i))) {
					rtn.add("U(" + list.get(i) + ")");
				}
				else {
					rtn.add("L(" + list.get(i) + ")");
				}
			}
			else if (Character.isDigit(list.get(i))) {
				rtn.add("N(" + list.get(i) + ")");
			}
			else {
				continue;
			}
		}
		return rtn;
	}
	
	/**
	 * Changes the list by removing multiples of 3, adding the first five multiples of 4, 5, 6,
	 * and sorting the list in ascending order.
	 * @param list list of integers
	 * @return number of unique elements in list
	 */
	public static int modify(List<Integer> list) {
		if (list == null) {
			throw new IllegalArgumentException("The List must not be null.");
		}
		else {
			// Removes multiples of 3
			list.removeIf(x -> x % 3 == 0);
			// Adds first 5 multiples of 4,5,6 and sorts list in sequential order
			Integer[] numbers = {4,8,12,16,20,5,10,15,20,25,6,12,18,24,30};
			for (int i = 0; i < numbers.length; i++) {
				list.add(numbers[i]);
			}
			Collections.sort(list);
			// Removes duplicates and returns number of unique elements
			HashSet<Integer> number = new HashSet<Integer>();
			number.addAll(list);
			return number.size();
		}
	}
	
	/**
	 * 
	 * @param list generic list of items
	 * @param num the number by which elements will be deleted in
	 */
	public static void removeEveryNthElement(List<?> list, int num) {
		if (num <= 0) {
			throw new IllegalArgumentException("N must be a positive number.");
		}
		else if (list == null) {
			throw new IllegalArgumentException("The list must not be null.");
		}
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if ((i + 1) % num == 0) {
				indexes.add(i);
			}
		}
		for (int i = indexes.size() - 1; i > -1; i--) {
			int index = indexes.get(i);
			list.remove(index);
		}
	}
}
