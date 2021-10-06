package m01;

/**
 * Module 01 Test
 * JUnit | Text Manipulation | Doc Comments
 * February 3, 2020
 * @author Russell Wadsworth
 *
 */
public class Module01 {
	/**
	 * Replaces the beginning of "word" with "CSIS" if "csis", "cis", or "cs" exist
	 * Private function only accessible to Module01 class
	 * Private function implemented only in tranform() function
	 * @return replaced word
	 */
	private static String csisReplace(String word, String replace, String caseCheck) {
		int index = caseCheck.indexOf(replace);
		StringBuilder sb1 = new StringBuilder();
		sb1 = sb1.append(word);
		if (index == 0 && replace == "csis") {
			sb1 = sb1.replace(0,4,"CSIS");
			return sb1.toString();
		}
		else if (index == 0 && replace == "cs") {
			sb1 = sb1.delete(0,2).insert(0, "CSIS");
			return sb1.toString();
		}
		else if (index == 0 && replace == "cis") {
			sb1 = sb1.delete(0,3).insert(0, "CSIS");
			return sb1.toString();
		}
		else {
			char[] csis = new char[4];
			for (int i = 0; i < 4; i++) {
				csis[i] = word.charAt(i);
			}
			if (csis[1] == 's') {
				if (csis[3] == 's') {
					sb1 = sb1.replace(0,4,"CSIS");
					return sb1.toString();
				}
				else {
					sb1 = sb1.delete(0,2).insert(0, "CSIS");
					return sb1.toString();
				}
			}
			else if (csis[1] == 'i') {
				sb1 = sb1.delete(0,3).insert(0, "CSIS");
				return sb1.toString();
			}
		}
		return word;
	}
	/**
	 * Transforms word into the following parameters:
	 * 1. Spaces in the word are replaced with hyphens
	 * 	ex. "  hello   world " --> "--hello---world-"
	 * 2. Words that start with "csis," "cs," and "cis" (ignoring case) are replaced 
	 * with "CSIS"
	 *  ex. "csis1400" --> "CSIS1400"; "cSiScLaSs" --> "CSIScLaSs"
	 * 3. Surround the word with pointed brackets
	 * 	ex. "Disney" --> "<Disney>"
	 * 
	 * Final Result Example:
	 * " cSiS Disney relics " --> "<-CSIS-Disney-relics->"
	 * (Notice how "cs" is the end of the word "relics," but it is not changed to CSIS)
	 * 
	 * @param word sentence or single word that will undergo the specified changes
	 * @return new sentence or word that applies specified changes
	 */
	public static String transform(String word) {
	/*
	 * -1. Begin stringbuilder with open bracket <
	 * -2. Check "word" if there are spaces
	 * 		-2a. If there are spaces, replace all spaces with the character "-"
	 * -3. Check to see if "word" *STARTS WITH* either of the following:
	 * 		3a. "csis","Csis","cSis","csIs","csiS","CSis","CsIs","CsiS","CSIs","CSiS","CSIS"
	 * 		3b. "cis","Cis","cIs","ciS","CIs","CiS","CIS"
	 * 		3c. "cs","Cs","cS","CS"
	 * 		NOTE. ****Start with a test to see if the start of the word is "c" ignoring case
	 * 			Follow it by either "is" or "s"
	 * 3.5. If "word" *STARTS WITH* any of those, replace it with "CSIS"
	 * 4. Append "word" into stringbuilder
	 * 5. End stringbuilder with close bracket >
	 * 6. Return stringbuilder's toString() function
	 * 	 */
		StringBuilder sb = new StringBuilder();
		// Places first angle bracket into final string
		sb = sb.append("<");
		// Test to see if word is blank ("")
		if (word == "") {
			sb = sb.append(">");
			return sb.toString();
		}
		// Replaces all spaces with hyphens
		word = word.replace(' ', '-');
		
		String caseCheck = word;
		caseCheck = caseCheck.toLowerCase();
		if (caseCheck.contains("cs")) {
			if (caseCheck.contains("csis")) {
				word = csisReplace(word,"csis",caseCheck);
			}
			else {
				word = csisReplace(word,"cs",caseCheck);
			}
		}
		else if (caseCheck.contains("cis")) {
			word = csisReplace(word,"cs",caseCheck);
		}
		
		// Appends transformed word and closing angle bracket into final string
		sb = sb.append(word).append(">");
		return sb.toString();
	}

	public static void main(String[] args) {

	}

}
