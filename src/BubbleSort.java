/*
*
* Bubble sorting class made by Joe Sweeney.
*
*/

import java.util.Arrays;

public class BubbleSort {
	
//	Initialize sortedInts which stores the final 	
	static int[] sortedInts;

//	Constructor which takes an input array and a boolean selector for special debugging messages
	public BubbleSort(int[] inputArr, boolean debugSelect) {
		sort(inputArr, debugSelect);
	}

//	Main sorting method which uses the bubble sorting algorithm to sort the input array
	private static int[] sort(int[] unsortedInts, boolean debugMode) {

//		Initialize variables, determine the array length that is being inputed and save that to arrLength
		int arrLength = unsortedInts.length;
		int swapInt = 0;
	
//		Set the sortedInts array to have the same length as the array inputed
		sortedInts = new int[arrLength];

//		Boolean which indicates whether the array is sorted correctly
		boolean sorted = false;

//		Special message used for debugging purposes
		if (debugMode == true) {
			System.out.println("Numbers to be sorted: " + Arrays.toString(unsortedInts) + "\n");
			System.out.println("_________________________Now Sorting_________________________\n");
		}

//		Loop one iteration of a bubble sort in which the class checks each number in the array (starting with the second), and 
//		switches it with the previous number if appropriate until the check determines weather the array is correctly sorted.
		while (sorted == false) {

//			Set the sorted variable to true so that the sorted check will initiate
			sorted = true;

//			Check each number in the array individually to see if it is less that the previous number, if so, switch the two. If not, continue
//			to the next number.
			for (int j = 1; j < arrLength; j++) {
				if (unsortedInts[j] < unsortedInts[j-1]) {
					if (debugMode == true) {
						
//						Special message used for debugging purposes
						System.out.println("Sorting: switched " + unsortedInts[j] + " at index " + (j+1) + " with " + unsortedInts[j-1] + " at index " + (j) + ".");
					}
					
//					Store the previous number in a temporary variable, then switch the two numbers
					swapInt = unsortedInts[j-1];
					unsortedInts[j-1] = unsortedInts[j];
					unsortedInts[j] = swapInt;
					
//					If the numbers are not in the correct order, set sorted to false. Otherwise, sorted will remain
//					true and the while loop will exit indicating that the sorting is complete
					sorted = false;
					
//					Special message used for debugging purposes
					if (debugMode == true) {
						System.out.println("Current state of sorting: " + Arrays.toString(unsortedInts) + "\n");
					}
				}
			}
			
//			Special message used for debugging purposes
			if (debugMode == true && sorted == false) {
				System.out.println("Not yet sorted, continuing sort...\n");
				System.out.println("-------------------------Resorting-------------------------\n");
			}
		}

//		Store the finally sorted array in another array called sortedInts
		sortedInts = unsortedInts.clone(); 
		
//		Special message used for debugging purposes
		if (debugMode == true) {
			
			String resultStr = " Successfully sorted! Result: " + Arrays.toString(sortedInts) + " ";
			
			printUnders(resultStr);
			System.out.println("\n" + resultStr);
			printUnders(resultStr);
			
		}
		return sortedInts;

	}
	
//	Debugging method that produces a pretty box for the final result
	private static void printUnders (String inputStr) {
		for (int l = 0; l < inputStr.length(); l++) {
			System.out.print("_");
		}
	}
}