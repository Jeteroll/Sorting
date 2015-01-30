/*
*
* Bubble sorting class made by Joe Sweeney.
*
*/

import java.util.Arrays;

public class BubbleSort {
	
//	Initialize unsortedNums which stores the input array, tempNums which stores the numbers while they are being sorted, 
//	and sortedNums which stores the final result
	float[] unsortedNums;
	float[] tempNums;
	float[] sortedNums;

//	Constructor which takes an input array and a boolean selector for special debugging messages, and then sorts the input array
	public BubbleSort(float[] inputArr, boolean debugSelect) {
		unsortedNums = inputArr;
		sort(debugSelect);
	}

//	Main sorting method which uses the bubble sorting algorithm to sort the input array
	private float[] sort(boolean debugMode) {
		
//		Clone the unsorted array to a temporary array
		tempNums = unsortedNums.clone(); 

//		Initialize variables, determine the array length that is being inputed and save that to arrLength
		int arrLength = tempNums.length;
		float swapNum = 0;
		
//		Initialize a variable to count the number of passes
		int passes = 0;
		
//		Set the sortedNums array to have the same length as the array inputed
		sortedNums = new float[arrLength];

//		Boolean which indicates whether the array is sorted correctly
		boolean sorted = false;

//		Special message used for debugging purposes
		if (debugMode == true) {
			System.out.println("Numbers to be sorted: " + Arrays.toString(tempNums) + "\n");
			System.out.println("_________________________Now Sorting_________________________\n");
		}

//		Loop one iteration of a bubble sort in which the class checks each number in the array (starting with the second), and 
//		switches it with the previous number if appropriate until the check determines weather the array is correctly sorted.
		while (sorted == false) {

//			Set the sorted variable to true so that the sorted check will initiate
			sorted = true;

//			Check each number in the array individually to see if it is less that the previous number, if so, switch the two. If not, continue
//			to the next number.
			for (int j = 1; j < arrLength - passes; j++) {
				if (tempNums[j] < tempNums[j-1]) {
					if (debugMode == true) {
						
//						Special message used for debugging purposes
						System.out.println("Sorting: switched " + tempNums[j] + " at index " + (j+1) + " with " + tempNums[j-1] + " at index " + (j) + ".");
					}
					
//					Store the previous number in a temporary variable, then switch the two numbers
					swapNum = tempNums[j-1];
					tempNums[j-1] = tempNums[j];
					tempNums[j] = swapNum;
					
//					If the numbers are not in the correct order, set sorted to false. Otherwise, sorted will remain
//					true and the while loop will exit indicating that the sorting is complete
					sorted = false;
					
//					Special message used for debugging purposes
					if (debugMode == true) {
						System.out.println("Current state of sorting: " + Arrays.toString(tempNums) + "\n");
					}
				}
			}
			
			passes += 1;
			
//			Special message used for debugging purposes
			if (debugMode == true && sorted == false) {
				
//				Check if the loop has made more than one pass, and if so print the number that has been skipped due to optimization 
				if (passes > 1) {
					System.out.println("Skipped number: " + tempNums[arrLength  + 1 - passes]);
				}
				System.out.println("Not yet sorted, continuing sort... " + "[Pass: "+ (passes + 1) + "]\n");
				System.out.println("-------------------------Resorting-------------------------\n");
			}
		}

//		Store the finally sorted array in another array called sortedNums
		sortedNums = tempNums.clone(); 
		
//		Special message used for debugging purposes
		if (debugMode == true) {
			
			String resultStr = " Successfully sorted! Result: " + Arrays.toString(sortedNums) + " ";
		
//			Print out the final result, encased in underscores for clarity
			printUnders(resultStr);
			System.out.println("\n" + resultStr);
			printUnders(resultStr);
			
		}
		return sortedNums;

	}
	
//	Debugging method that produces a pretty box for the final result
	private static void printUnders (String inputStr) {
		for (int l = 0; l < inputStr.length(); l++) {
			System.out.print("_");
		}
	}

// toString method that returns a clean description of this object, ant its properties
	public String toString() {
		String bubbleSort = "\nSorting method: bubble, unsorted numbers: " + Arrays.toString(unsortedNums) + ", sorted numbers: " + Arrays.toString(sortedNums) + "\n";
		return bubbleSort;
	}
}