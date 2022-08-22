
public class MergeSort {
	
	//Recursively split array into smaller array until all arrays n=1
	public void sort(int[] inputArray) {
		int inputLength = inputArray.length;
		
		//base case
		if(inputLength < 2) return;
		
		int midIndex = inputLength/2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];
		
		//copy left half or array to 'leftHalf' and visa versa with right half of array
		for(int i=0; i<midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for(int j=midIndex; j<inputLength; j++) {
			rightHalf[j-midIndex] = inputArray[j];
		}
		sort(leftHalf);
		sort(rightHalf);
		
		merge(inputArray, leftHalf, rightHalf);
	}
	
	public void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i=0, j=0, k=0;
		
		while(i<leftSize && j<rightSize) {
			 if (leftHalf[i] <= rightHalf[j]) {
	                inputArray[k] = leftHalf[i];
	                i++;
	            }
	         else {
	                inputArray[k] = rightHalf[j];
	                j++;
	            }
			 k++;
		}
		//Cleanup: add remaining elements in left/right array to output
		while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
		while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
	}
}
