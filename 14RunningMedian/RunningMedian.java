import java.util.*;

public class RunningMedian {
    MyHeap<Integer> left, right;
    Integer middleValue;
    int size;
    
    public RunningMedian() {
        left = new MyHeap<Integer>(true);
	right = new MyHeap<Integer>(false);
    }

    public double getMedian() {
        if (size == 0) {
	    throw new NoSuchElementException();
	}
	if (size % 2 == 1) {
	    return (double)middleValue;
	} else {
	    return (left.peek() + right.peek()) / 2.0;
	}
    }

    public void add(Integer x) {
	if (size % 2 == 1) {
	    if (x.compareTo(middleValue) < 0) {
		left.add(x);
		right.add(middleValue);
	    } else {
		right.add(x);
		left.add(middleValue);
	    }
	} else {
	    Integer leftValue = left.peek();
	    Integer rightValue = right.peek();

	    if (x.compareTo(leftValue) > 0) {
		if (x.compareTo(rightValue) < 0) {
		    //smack-dab in the middle
		    middleValue = x;
		}
		else {
		    //larger than middles
		    middleValue = right.delete();
		    right.add(x);
		}
	    }
	    else {
		//smaller than middles
		middleValue = left.delete();
		left.add(x);
	    }
	}
	size += 1;
    }

    public Integer removeMedian() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	Integer ans;
	if (size % 2 == 1) {
	    ans = middleValue;
	    size -= 1;
	}
	else {
	    System.out.println("How do I remove median when there's an even # of terms");
	    ans = Integer.MIN_VALUE;
	}
	return ans;
    }
}
