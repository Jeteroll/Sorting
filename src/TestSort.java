import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		int[] ints = {1,3,5,7,0,9};
		BubbleSort bubble = new BubbleSort(ints, true);
		
		System.out.println(Arrays.toString(bubble.sortedInts));

	}

}
