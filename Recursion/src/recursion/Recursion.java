package recursion;

/**
 * Recursion functions that calculate a sum of digits, counts smiles in a character array, and puts sentences in uppercase. 
 * @author Russell
 *
 */
public class Recursion {
	/**
	 * Breaks a given number up and adds the digits to create a sum
	 * @param n number given that will break up and add together
	 * @return sum of numbers
	 */
	public static int sumOfDigits(int n) {
		n = Math.abs(n);
		if (n == 0) {
			return 0;
		}
		else {
			return n%10 + sumOfDigits(n/10);
		}
	}
	/**
	 * Counts the number of smiles [":)"] in a given character array
	 * @param letters character array of letters and possible colon and closing parentheses
	 * @param index start index in the character array
	 * @return sum of smiles
	 */
	public static int countSmiles(char[] letters, int index) {
		int count = 0;
		if (letters.length == index) {
			return 0;
		}
		if (letters[index] == ':') {
			if (letters[index+1] == ')') {
				count++;
			}
		}
		return count + countSmiles(letters, index+1);
	}
	/**
	 * Members for toUpper
	 */
	static String outstr = "";
	static int index = 0;
	/**
	 * Creates a new string with all capitalized letters--and spaces in-between
	 * @param str statement that will be changed. ex. "Hello World"
	 * @return new and formatted sentence. ex. "H E L L O   W O R L D"
	 */
	public static String toUpper(String str) {
		str = str.toUpperCase();
		if (str.length() == index) {
			outstr = outstr.substring(0,outstr.length()-1);
			index = 0;
			String rtn = outstr;
			outstr = "";
			return rtn;
		}
		outstr = outstr + str.charAt(index) + " ";
		index++;
		return toUpper(str);
	}
}
