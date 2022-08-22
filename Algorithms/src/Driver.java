import java.util.Arrays;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		//Create random array
		Random rand = new Random();
		int[] numbers = new int[100];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = rand.nextInt(1000);
		}
		System.out.println("Before: " + Arrays.toString(numbers));
		
		MergeSort merge = new MergeSort();
		merge.sort(numbers);
		System.out.println("After: " + Arrays.toString(numbers));
		
	}
}
