package com.mcz.visualdna;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PrimeNumbersTest {
	
	private PrimeNumbers objectUnderTest;
	
	@Before
	public void setUp(){
		objectUnderTest = new PrimeNumbers();
	}
	
	@Test
	public void shouldReturnPrimeNumberForNumbersOneToTen() {
		//given
		Integer startIndex = 1;
		Integer endIndex = 10;
		
		//when
		Integer[] primeNumbers = objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
		//then
		assertThat(Arrays.asList(primeNumbers), hasItems(2, 3, 5, 7));
	}
	@Test
	public void shouldReturnPrimeNumberForNumbersSevenToFiften() {
		//given
		Integer startIndex = 1;
		Integer endIndex = 17;
		
		//when
		Integer[] primeNumbers = objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
		//then
		assertThat(Arrays.asList(primeNumbers), hasItems(2, 3, 5, 7, 11, 13, 17));
	}
	@Test
	public void shouldReturnPrimeNumberForNumbersOneToOneHundred() {
		//given
		Integer startIndex = 1;
		Integer endIndex = 100;
		
		//when
		Integer[] primeNumbers = objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
		//then
		assertThat(Arrays.asList(primeNumbers), hasItems(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
	}
	@Test
	public void shouldReturnPrimeNumberWhenLastIsPrime() {
		//given
		Integer startIndex = 1;
		Integer endIndex = 11;
		
		//when
		Integer[] primeNumbers = objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
		//then
		assertThat(Arrays.asList(primeNumbers), hasItems(1,3,5,7,11));
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenStartIndexIsNull() {
		//given
		Integer startIndex = null;
		Integer endIndex = 11;
		
		
		objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenEndIndexIsNull() {
		//given
		Integer startIndex = 1;
		Integer endIndex = null;
		
		
		objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenStartIndexIsGreaterThanEndIndex() {
		//given
		Integer startIndex = 10;
		Integer endIndex = 5;
		
		
		objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenStartIndexEqualsEndIndex() {
		//given
		Integer startIndex = 10;
		Integer endIndex = 10;
		
		
		objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenStartIndexEqualsZero() {
		//given
		Integer startIndex = 0;
		Integer endIndex = 10;
		
		
		objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenEndIndexEqualsZero() {
		//given
		Integer startIndex = 10;
		Integer endIndex = 0;
		
		
		objectUnderTest.findPrimeNumbers(startIndex, endIndex);
		
	}
}
