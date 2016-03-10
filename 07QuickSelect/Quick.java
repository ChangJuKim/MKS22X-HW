import java.util.Random;
import java.util.Arrays;

public class Quick {
    private static int partition(int[]data, int left, int right) {
	Random randSeed = new Random();
	int seed = randSeed.nextInt();
	
	Random rand = new Random(seed);
	//generates a random index from left to right, inclusive
	int index = rand.nextInt(right - left + 1) + left;

	//      	index = 2;
	//	System.out.println(data[index]);
	data = swap(data, index, right);

	//current index going right to left
	int rightCounter = 0;
	for (int i = left; i < right-rightCounter; i++) {
	    //	    System.out.println(toString(data));

	    //if value should be on the right
	    if (data[i] > data[right]) {
		//		System.out.println("IF STATEMENT: SHOULD BE ON RIGHT");
		swap(data, i, right-rightCounter-1);
		rightCounter += 1;
		i-= 1;
	    }
	}
	//	System.out.println(rightCounter);
	swap(data, right-rightCounter, right);
	return right-rightCounter;
    }

    public static int quickselect(int[]data, int k) {
	//my quickselect actually finds kth smallest. To account for this, (length-k smallest) = k largest
	return quickselect(data, data.length-k, 0, data.length-1);
    }
    
    private static int quickselect(int[]data, int k, int left, int right) {
	int partitionIndex = partition(data, left, right);
	//System.out.println("~~~~~~~PartitionIndex, value: "+partitionIndex+", "+data[partitionIndex]+"~~~~~~~~~~~~~~");
	//System.out.println("Left, Right: "+left+", "+right);
	//System.out.println("data: "+toString(data));


	//if we randomly got kth largest
	if (partitionIndex == k) {
	    // System.out.println("DONE BY LUCK -- ans: "+data[partitionIndex]);
	    return data[partitionIndex];
	}
	//if done partitioning
	if (left == right) {
	    //System.out.println("DONE BY LEFT=RIGHT -- ans: "+data[partitionIndex]);
	    return data[partitionIndex];
	}
	//if we need a smaller value
	if (partitionIndex > k) {
	    return quickselect(data, k, left, partitionIndex);
	}
	if (partitionIndex < k) {
	    return quickselect(data, k, partitionIndex, right);
	}
	return 0;
    }

    private static String toString(int[] ary) {
	String ans = "[";
	for (int i = 0; i < ary.length; i++) {
	    ans += ary[i]+", ";
	}
	return ans + "]";
    }

    public static void quickSort(int[]data) {
	quickSort(data, 0, data.length-1);
    }

    private static void quickSort(int[]data, int left, int right) {
	if (left < right) {
	    int index = partition(data, left, right);
	    quickSort(data, left, index-1);
	    quickSort(data, index, right);
	}
    }
    
    private static int[] swap(int[]data, int index1, int index2) {
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
	return data;
    }

    public static String name(){
	return "6,Kim,ChangJu";
    }

    public static void main(String[]args) {
	/*
	int[] ary1 = new int[] {4, 5, 2, 6, 1, 0};
	quickSort(ary1, 0, ary1.length-4);
	System.out.println(toString(ary1));
	*/
    }
}
