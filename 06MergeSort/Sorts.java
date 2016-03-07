public class Sorts{
    public static void printArray(int[]data){
	//print the array like:  [ 1, 2, 3, 4]
	String ans = "[";
	for (int i = 0; i < data.length; i++) {
	    ans += " " + i + ",";
	}
	System.out.println(ans.substring(0, ans.length() - 1) + "]");
    }
    //finds num's rightful place
    private static int[] increaseSize(int[]data) {
	int[] newData = new int[data.length * 2];
	for (int i = 0; i < data.length; i++) {
	    newData[i] = data[i];
	}
	return newData;
    }
    
    private static int find(int[]data, int num) {
        int first = 0;
	int last = data.length;
	int middle = (first + last) / 2;
	if (first == last - 1) {
	    return num;
	} else if (data[middle] > num) {
	    first = middle + 1;
	    middle = (first + last) / 2;
	} else if (data[middle] < num) {
	    last = middle;
	    middle = (first + last) / 2;
	} else if (data[middle] == num) {
	    last = middle + 1;
	    middle = (first + last) / 2;
	}
	return num;
    }
    private static int[] add(int[]data, int num) {
	for (int i = data.length; i > find(data,num); i--) {
	    data[i] = data[i-1];
	}
	data[find(data,num)] = num;
	return data;
    }
    public static void insertionSort(int[]data){
	//your code here to make data re-order its elements
	//from least to greatest just like we did in class
	//same algorithm as the way you created your OrderedSuperArray
	
    }

    public static int[] mergeSort(int[] data1, int[] data2) {
        int[] ans = new int[data1.length+data2.length];
	//loops through data1 and 2
        int counter1 = 0;
	int counter2 = 0;
	//System.out.println("data1.length: "+data1.length);
	//System.out.println("data2.length: "+data2.length);
	while (counter1 <= data1.length && counter2 <= data2.length) { //loop until it's time to fill in an array's value
	    //System.out.println("counter1: "+counter1);
	    //System.out.println("counter2: "+counter2);
	    if (counter1 >= data1.length) {
		fillInRest(ans, data2, counter2);
		counter1 += 1; //breaks loop
	    }
	    else if (counter2 >= data2.length) {
		fillInRest(ans, data1, counter1);
		counter2 += 1; //breaks loop
	    } else {
		//if data1's value is smaller
		if (data1[counter1] <= data2[counter2]) {
		    ans[counter1+counter2] = data1[counter1];
		    counter1 += 1;
		}
		else if (data2[counter2] <= data1[counter1]) {
		    ans[counter1+counter2] = data2[counter2];
		    counter2 += 1;
		}
	    }
	    //System.out.println(toString(ans));
	}
	return ans;
    }

    public static String toString(int[] ary) {
	String ans = "[";
	for (int i = 0; i < ary.length; i++) {
	    ans += ary[i]+", ";
	}
	return ans + "]";
    }

    //fills in the rest of the values of data to answer, when other data has no more values
    public static void fillInRest(int[] ans, int[] data, int dataCounter) {
	/*
	System.out.println("\n\nFilling in the rest of: "+toString(data));
	System.out.println("ans.length: "+ans.length);
	System.out.println("data.length: "+data.length);
	System.out.println("~~~~Start of loop~~~~\n\n");
	*/
	for (int i = dataCounter; i < data.length; i++) {
	    //System.out.println(i);
	    //System.out.println("ans: "+toString(ans));

	    //ans.length - dataCounter starts at the first open spot and ends at the last index
	    //in other words, dataCounter-data.length = amount of numbers to fill in 
	    ans[ans.length-data.length+i] = data[i];
	}
    }

    public static void main(String[]args) {
	int[] ary1 = new int[] {0, 10, 20, 30, 40};
	int[] ary2 = new int[] {9, 11};
	System.out.println(toString(mergeSort(ary1, ary2)));
	
    }
}
