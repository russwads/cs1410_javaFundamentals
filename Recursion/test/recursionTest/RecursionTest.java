package recursionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import recursion.Recursion;

class RecursionTest {
	/**
	 * Tests for sumOfDigits() function
	 * Expected:
	 * 1. 7
	 * 2. 12
	 * 3. 45
	 * 4. 2
	 * 5. 5
	 * 6. 20
	 * 7. 52
	 * 8. 90
	 */
	@Test
	void firstSumOfDigitsParamEquals7() {
		assertEquals(Recursion.sumOfDigits(-34),7,7);
	}
	
	@Test
	void secondSumOfDigitsParamEquals12() {
		assertEquals(Recursion.sumOfDigits(1038),12,12);
	}
	
	@Test
	void thirdSumOfDigitsParamEquals45() {
		assertEquals(Recursion.sumOfDigits(99999),45,45);
	}

	@Test
	void fourthSumOfDigitsParamEquals2() {
		assertEquals(Recursion.sumOfDigits(1000000002 - 1),2,2);
	}
	
	@Test
	void fifthSumOfDigitsParamEquals5() {
		assertEquals(Recursion.sumOfDigits(1010100505 + 505),5,5);
	}
	
	@Test
	void sixthSumOfDigitsParamEquals20() {
		assertEquals(Recursion.sumOfDigits(24680),20,20);
	}
	
	@Test
	void seventhSumOfDigitsParamEquals52() {
		assertEquals(Recursion.sumOfDigits(-878706565),52,52);
	}
	
	@Test
	void eighthSumOfDigitsParamEquals90() {
		assertEquals(Recursion.sumOfDigits(999999999),81,81);
	}
	
	
	/**
	 * Tests for countSmiles() function
	 * Expected:
	 * 1. 2
	 * 2. 3
	 * 3. 0
	 * 4. 3
	 * 5. 5
	 * 6. 1
	 * 7. 0
	 * 8. 4
	 */
	@Test
	void lifeIsGoodShouldReturn2() {
		char[] letters = {':',')',' ','L','i','f','e',' ','i','s',' ',
				+ 'g','o','o','d',' ',':',')'};
		assertEquals(Recursion.countSmiles(letters,0),2,2);
	}
	
	@Test
	void happyDayShouldReturn3() {
		char[] letters = {'H','a','p','p','y',' ','D','a','y',' ',
				+ ':',')',':',')',':',')','!'};
		assertEquals(Recursion.countSmiles(letters,0),3,3);
	}
	
	@Test
	void abceShouldReturn0() {
		char[] letters = {'a',':','b','(','c',')',':',' ',')','e'};
		assertEquals(Recursion.countSmiles(letters,0),0,0);
	}
	
	@Test
	void dreamsComeTrueShouldReturn3() {
		char[] letters = {'D',':',')','r','e','a','m','s',' ','C','o',':',')','m','e',' ','T','r','u','e',':',')'};
		assertEquals(Recursion.countSmiles(letters,0),3,3);
	}
	
	@Test
	void manySmilesShouldReturn5() {
		char[] letters = {':',')',':',')',':',')',':',')',':',')'};
		assertEquals(Recursion.countSmiles(letters,0),5,5);
	}
	
	@Test
	void margeShouldReturn1() {
		char[] letters = {'8','8','8','8','8','8','8','8',':',')'};
		assertEquals(Recursion.countSmiles(letters,0),1,1);
	}
	
	@Test
	void semicolonTearsOfJoyShouldReturn0() {
		char[] letters = {';',')','T','e','a','r','s',' ','o','f',' ','J','o','y',' ',';','(',':','(',';',')'};
		assertEquals(Recursion.countSmiles(letters,0),0,0);
	}
	
	@Test
	void disneylandShouldReturn4() {
		char[] letters = {':',')','D',':','(','i',':','@','s',':',')','n',':','*','e',':','%','y',':','!','l',';','(','a',':',')','n',':',')','d'};
		assertEquals(Recursion.countSmiles(letters,0),4,4);
	}
	
	
	/**
	 * Tests for toUpper() function
	 * Expected:
	 * 1. H I   T H E R E !
	 * 2. M Y   N A M E   I S   R U S S .
	 * 3. I   L O V E   T O   T R A V E L .
	 * 4. D I S N E Y L A N D   I S   T H E   B E S T !
	 * 5. I S   D I S N E Y   T O K Y O   C O O L ?
	 * 6. C A L L   M E   @   D I S N E Y   P A R I S .
	 * 7. I   N E E D   A   D I S N E Y   C R U I S E .
	 * 8. T I M E   F O R   A   N A P :   Z Z Z Z
	 */
	@Test
	void hiThereToUpper() {
		assertEquals(Recursion.toUpper("Hi there!"),"H I   T H E R E !","H I   T H E R E !");
	}
	
	@Test
	void myNameIsRussToUpper() {
		assertEquals(Recursion.toUpper("My name is RuSs."),"M Y   N A M E   I S   R U S S .","M Y   N A M E   I S   R U S S .");
	}
	
	@Test
	void iLoveToTravelToUpper() {
		assertEquals(Recursion.toUpper("i LoVe To TrAvEl."),"I   L O V E   T O   T R A V E L .","I   L O V E   T O   T R A V E L .");
	}

	@Test
	void disneylandIsTheBestToUpper() {
		assertEquals(Recursion.toUpper("DISNEYLAND IS THE BEST!"),"D I S N E Y L A N D   I S   T H E   B E S T !",
				"D I S N E Y L A N D   I S   T H E   B E S T !");
	}
	
	@Test
	void isDisneyTokyoCoolToUpper() {
		assertEquals(Recursion.toUpper("is disney tokyo cool?"),"I S   D I S N E Y   T O K Y O   C O O L ?","I S   D I S N E Y   T O K Y O   C O O L ?");
	}
	
	@Test
	void callMeAtDisneyParisToUpper() {
		assertEquals(Recursion.toUpper("caLL me @ DISNey paRIS."),"C A L L   M E   @   D I S N E Y   P A R I S .",
				"C A L L   M E   @   D I S N E Y   P A R I S .");
	}
	
	@Test
	void iNeedADisneyCruiseToUpper() {
		assertEquals(Recursion.toUpper("i NEED a disney CRUISE."),"I   N E E D   A   D I S N E Y   C R U I S E .",
				"I   N E E D   A   D I S N E Y   C R U I S E .");
	}
	
	@Test
	void timeForANapZzzzToUpper() {
		assertEquals(Recursion.toUpper("time for a NAP: zZzZ"),"T I M E   F O R   A   N A P :   Z Z Z Z","T I M E   F O R   A   N A P :   Z Z Z Z");
	}
}
