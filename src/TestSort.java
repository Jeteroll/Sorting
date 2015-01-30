import java.util.Random;

public class TestSort {

	public static void main(String[] args) {
		float[] ints = new float[500];
		
		Random rand = new Random();
		int x;
		
		for (int i = 0; i < 500; i++) {
		  x = rand.nextInt(500);
		  ints[i] = x;
		}
		
		System.out.println("Finished filling!!!");
		
		BubbleSort bubble = new BubbleSort(ints, true);
		
		System.out.println(bubble);
	}

}
