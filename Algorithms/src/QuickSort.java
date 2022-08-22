/*
 * Quicksort has three main stages
 * Choose pivot
 * Partition
 * Recursion
 */

import java.util.Random;

public class QuickSort {
	
	public void sort(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case, stops recursion
		if(lowIndex >= highIndex)
			return;
		
		//Choose pivot randomly and swap to last element in array
		int pivotIndex = new Random().nextInt(highIndex-lowIndex) + lowIndex;
		int pivot = inputArray[pivotIndex];
		swap(inputArray, pivotIndex, highIndex);
		
		//Partition left and right side of pivot
		int leftPointer = partition(inputArray, lowIndex, highIndex, pivot);
		
		//Recursively sort both sides of pivot
		sort(inputArray, lowIndex, leftPointer-1);
		sort(inputArray, leftPointer+1, highIndex);
	}

	private int partition(int[] inputArray, int lowIndex, int highIndex, int pivot) {
	
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while(leftPointer < rightPointer) {
			//increment left pointer until element value is larger than pivot
			while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			//decrement right pointer until element value is less than pivot
			while(inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			swap(inputArray, leftPointer, rightPointer);
		}
		swap(inputArray, leftPointer, highIndex);
		return leftPointer;
	}
	
	private void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
