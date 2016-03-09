import java.util.Random;

public class Quick {
    private static int[] partition(int[]data, int left, int right) {
	Random randSeed = new Random();
	int seed = randSeed.nextInt();
	
	Random rand = new Random(seed);
	//generates a random index from left to right, inclusive
	int index = rand.nextInt(right - left + 1) + left;

	//      	index = 2;
	System.out.println(data[index]);
	data = swap(data, index, right);

	//current index going right to left
	int rightCounter = 0;
	for (int i = left; i < right-rightCounter; i++) {
	    System.out.println(toString(data));
	    //if value should be on the right
	    if (data[i] > data[right]) {
		System.out.println("IF STATEMENT: SHOULD BE ON RIGHT");
		swap(data, i, right-rightCounter-1);
		rightCounter += 1;
		i-= 1;
	    }
	}
	System.out.println(rightCounter);
	swap(data, right-rightCounter, right);
	return data;
    }

    private static String toString(int[] ary) {
	String ans = "[";
	for (int i = 0; i < ary.length; i++) {
	    ans += ary[i]+", ";
	}
	return ans + "]";
    }

    
    private static int[] swap(int[]data, int index1, int index2) {
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
	return data;
    }

    public static void main(String[]args) {
	int[] ary1 = new int[] {4, 5, 2, 6, 1, 0};
	System.out.println(toString(partition(ary1, 0, ary1.length-1)));
    }
}
