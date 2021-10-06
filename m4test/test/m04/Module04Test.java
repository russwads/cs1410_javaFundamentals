package m04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Module04Test {

	@Test
	void method1RandomNumbers() {
		ArrayList<Double> numbers = new ArrayList<Double>();
		Double[] numbuff = {-16.0, 11.0, 16.0, -12.0, 11.0};
		for (int i = 0; i < numbuff.length; i++) {
			numbers.add(numbuff[i]);
		}
		Module04.method1(numbers);
		ArrayList<Double> finish = new ArrayList<Double>();
		Double[] finbuff = {1.6, 1.1};
		for (int i = 0; i < finbuff.length; i++) {
			finish.add(finbuff[i]);
		}
		assertEquals(finish, numbers);
	}
	
	@Test
	void method1AllPositive() {
		ArrayList<Double> numbers = new ArrayList<Double>();
		Double[] numbuff = {1.0, 2.0, 200.5, 100.5, 20.2, 10.1, 1.0, 2.0, 200.5, 100.5, 20.2, 10.1};
		for (int i = 0; i < numbuff.length; i++) {
			numbers.add(numbuff[i]);
		}
		Module04.method1(numbers);
		ArrayList<Double> finish = new ArrayList<Double>();
		Double[] finbuff = {20.05, 10.05, 2.02, 1.01};
		for (int i = 0; i < finbuff.length; i++) {
			finish.add(finbuff[i]);
		}
		assertEquals(finish, numbers);
	}
	
	@Test
	void method1NegativeZeroLessThan1() {
		ArrayList<Double> numbers = new ArrayList<Double>();
		Double[] numbuff = {-2.34567, 5.6789022, 0.0, 1.9, 9.99999, -100000.0,};
		for (int i = 0; i < numbuff.length; i++) {
			numbers.add(numbuff[i]);
		}
		Module04.method1(numbers);
		ArrayList<Double> finish = new ArrayList<Double>();
		assertEquals(finish, numbers);
	}

	@Test
	void method2AllBinaryMajors() {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Integer[] elebuff = {0,1,2,4,8,16,32,64,128,256,512,1024,2048};
		for (int i = 0; i < elebuff.length; i++) {
			elements.add(elebuff[i]);
		}
		ArrayList<String> finish = new ArrayList<String>();
		String[] finbuff = {"100", "1000", "10000", "100000", "1000000", "10000000", "100000000", 
				"1000000000", "0", "1", "10"};
		for (int i = 0; i < finbuff.length; i++) {
			finish.add(finbuff[i]);
		}
		assertEquals(finish,Module04.method2(elements));
	}

	@Test
	void method2Empty() {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		ArrayList<String> finish = new ArrayList<String>();
		assertEquals(finish,Module04.method2(elements));
	}
	
	@Test
	void method2RandomNumbers() {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Integer[] elebuff = {20, 400, 912, 5246, 7};
		for (int i = 0; i < elebuff.length; i++) {
			elements.add(elebuff[i]);
		}
		ArrayList<String> finish = new ArrayList<String>();
		String[] finbuff = {"111", "10100", "110010000", "1110010000"};
		for (int i = 0; i < finbuff.length; i++) {
			finish.add(finbuff[i]);
		}
		assertEquals(finish,Module04.method2(elements));
	}
}
