import java.util.Random;
import java.util.Arrays;

public class Quick {

    private static int partitionOld(int[]data, int left, int right) {
	Random randSeed = new Random();
	int seed = randSeed.nextInt();
	
	Random rand = new Random(seed);
	//generates a random index from left to right, inclusive
	int index = rand.nextInt(right - left + 1) + left;

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

    public static int quickselectOld(int[]data, int k) {
	//my quickselect actually finds kth smallest. To account for this, (data.length-k) = kth largest
	return quickselectOld(data, data.length-k, 0, data.length-1);
    }
    
    private static int quickselectOld(int[]data, int k, int left, int right) {
	int partitionIndex = partitionOld(data, left, right);
	//System.out.println("~~~~~~~PartitionIndex, value: "+partitionIndex+", "+data[partitionIndex]+"~~~~~~~~~~~~~~");
	//System.out.println("Left, Right: "+left+", "+right);
	//System.out.println("data: "+toString(data));


	//if we randomly got kth largest
	if (partitionIndex == k) {
	    //System.out.println("DONE BY LUCK -- ans: "+data[partitionIndex]);
	    return data[partitionIndex];
	}
	//if done partitioning
	if (left == right) {
	    //System.out.println("DONE BY LEFT=RIGHT -- ans: "+data[partitionIndex]);
	    return data[partitionIndex];
	}
	//if we need a smaller value
	if (partitionIndex > k) {
	    return quickselectOld(data, k, left, partitionIndex);
	}
	if (partitionIndex < k) {
	    return quickselectOld(data, k, partitionIndex, right);
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

    public static void quickSortOld(int[]data) {
	quickSortOld(data, 0, data.length-1);
    }

    private static void quickSortOld(int[]data, int left, int right) {
	if (left < right) {
	    int index = partitionOld(data, left, right);
	    quickSortOld(data, left, index-1);
	    quickSortOld(data, index, right);
	}
    }

    private static int[] partition(int[]data, int left, int right) {
	Random randSeed = new Random();
	int seed = randSeed.nextInt();
	
	Random rand = new Random(seed);
	//generates a random index from left to right, inclusive
	int index = rand.nextInt(right - left + 1) + left;

	//	System.out.println(data[index]);
	data = swap(data, index, right);

	//current index goes right to left
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

	//the last index of the middle group
	int indexMiddleRight = right-rightCounter;
	System.out.println(toString(data));

	//moves values equal to the pivot to the middle
	for (int i = left; i < right; i++) {
	    if (data[i] == data[right]) {
		swap(data, data[i], data[right-rightCounter-1]);
		rightCounter += 1;
	    }
	}
	    
	//	System.out.println(rightCounter);
	swap(data, right-rightCounter, right);
	return new int[] {right - rightCounter, indexMiddleRight};
    }

    public static int quickselect(int[]data, int k) {
	//my quickselect finds kth smallest. To account for this, (data.length-k) = kth largest
	return quickselect(data, data.length-k, 0, data.length-1);
    }
    
    private static int quickselect(int[]data, int k, int left, int right) {
	//removes possible random errors (when two function calls get different randoms
	int[] partitionArray = partition(data, left, right);
	int partitionIndexLeft = partitionArray[0];
	int partitionIndexRight = partitionArray[1];
	//System.out.println("~~~~~~~PartitionIndex, value: "+partitionIndex+", "+data[partitionIndex]+"~~~~~~~~~~~~~~");
	//System.out.println("Left, Right: "+left+", "+right);
	//System.out.println("data: "+toString(data));


	//if we randomly got kth largest
	if (partitionIndexLeft == k) {
	    //System.out.println("DONE BY LUCK -- ans: "+data[partitionIndex]);
	    return data[partitionIndexLeft];
	}
	if (partitionIndexRight == k) {
	    return data[partitionIndexRight];
	}
	//if done partitioning
	if (left == right) {
	    //System.out.println("DONE BY LEFT=RIGHT -- ans: "+data[partitionIndex]);
	    return data[left];
	}
	//if we need a smaller value
	if (partitionIndexLeft > k) {
	    return quickselect(data, k, left, partitionIndexLeft);
	}
	//if between
	if (partitionIndexLeft < k && partitionIndexRight > k) {
	    return data[partitionIndexLeft];
	}
	if (partitionIndexRight < k) {
	    return quickselect(data, k, partitionIndexRight, right);
	}
	return 0;
    }

        public static void quickSort(int[]data) {
	quickSort(data, 0, data.length-1);
    }

    private static void quickSort(int[]data, int left, int right) {
	if (left < right) {
	    int[] partitionArray = partition(data, left, right);
	    int indexLeft = partitionArray[0];
	    int indexRight = partitionArray[1];
	    quickSort(data, left, indexLeft-1);
	    quickSort(data, indexRight, right);
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
	//int[] d = new int [10000];
	//int[] c = new int [d.length];	

	int[] a = new int[4000000];
	//Arrays.sort(a);
       	//quickSort(a);
	for(int i = 0; i < a.length; i++) {
	    a[i] = (int)(Math.random()*4);
	}

	int[]b = new int [4000000];
	for(int i = 0; i < b.length; i++) {
	    b[i] = (int)(Math.random()*Integer.MIN_VALUE) * (int)(Math.pow(-1, (int)(Math.random()*2)));
	}
	//Arrays.sort(b);
	//quickSortOld(b);
	quickSort(b);
	/*
	for(int i = 0; i < d.length; i++){	    
	    d[i]= (int)(4000);
	    c[i]= d[i];
	}
	quickSort(d); //or even your old quicksort!!!
      	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	*/
    }
}
