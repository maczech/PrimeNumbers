package com.mcz.visualdna;

import java.util.ArrayList;
import java.util.List;


public class PrimeNumbers {

	public Integer[] findPrimeNumbers(Integer startIndex, Integer endIndex){
		checkPreconditions(startIndex, endIndex);
				
		Integer numberOfElements = calculateNumberOfElements(startIndex, endIndex);
		
		Integer[] elements = initializeElements(startIndex, numberOfElements);
		
		Double stopCondition = calculateStopCondition(endIndex);
		
		for (int i = 0; i < numberOfElements; i++) {
			if(elements[i] == null){
				continue;
			}
			if(elements[i] == 1) {
				continue;
			}
			
			if (elements[i] >= stopCondition){
				break;
			} 
			
			filterMultiplications(i, elements);
			
		}
		
		elements = removeEmptyElements(elements);
		
		return elements;
		
	}

	private void checkPreconditions(Integer startIndex, Integer endIndex) {
		if (startIndex == null || endIndex == null) {
			throw new IllegalArgumentException("Start index and end index cannot be null");
		}
		if (startIndex <= 0 || endIndex <= 0) {
			throw new IllegalArgumentException("Start index and end index cannot be lower than one");
		}
		
		
		if (startIndex >= endIndex) {
			throw new IllegalArgumentException("Start index must be lower than end index");
		}
	}

	private Integer[] removeEmptyElements(Integer[] elements) {
		List<Integer> elementsList = new ArrayList<Integer>();
		
		for (int i = 0; i < elements.length; i++ ) {
			if (elements[i] != null) {
				elementsList.add(elements[i]);
			}
		}
		
		return elementsList.toArray(new Integer[0]);
	}

	private void filterMultiplications(Integer multiplicationIndex, Integer[] elements) {
		Integer multiplier = elements[multiplicationIndex];
		
		for (int i = multiplicationIndex + 1 ; i < elements.length; i *= multiplier ) {

			if(elements[i] != null && elements[i] % multiplier == 0){
				elements[i] = null;
			}
		}
		
	}

	private Double calculateStopCondition(Integer endIndex) {
		return Math.floor(Math.sqrt(endIndex));
	}

	private Integer[] initializeElements(Integer startIndex, Integer numberOfElements) {
		Integer[] elements = new Integer[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			elements[i] = startIndex + i;
		}
		return elements;
	}

	private Integer calculateNumberOfElements(Integer startIndex,
			Integer endIndex) {
		return (endIndex - startIndex) + 1;
	}
	
}
