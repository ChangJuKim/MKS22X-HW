import java.util.*;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap() {
	data = (T[]) new Object[10];
    }
    public MyHeap(T[] array) {
	for (int i = 0; i < array.length; i++) {
	    data[i] = array[i];
	}
	heapify();
	size = array.length - 1;
    }
    
    /**pushDown
      precondition: datas[k]'s children are valid heaps
      postconditions:-the element at index k has been 
      shifted to the correct spot.
      -data[k] and is a valid heap
    **/
    private void pushDown(int k) {
	if (compare(data[k*2], data[k]) > 0) { //left child is larger
	    swap(k*2, k);
	    pushDown(k*2);
	}
	else if (compare(data[k*2+1], data[k]) > 0) { //right child is larger
	    swap(k*2+1, k);
	    pushDown(k*2+1);
	}
	//no child is larger
    }
    
    /**pushUp
       precondition: data is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been 
      shifted to the correct spot.
      -data is a valid heap
   **/
    private void pushUp(int k) {
	if (k != 1) { /*if k isn't the root*/
	    if (compare(data[k], data[(k / 2)]) > 0) { /*if the child > parent*/
		swap(k, k/2);
		pushUp(k/2);
	    }
	    /*if parent <= child -- doesn't need to be modified*/
	}
    }

    private void heapify() {
	for (int i = size/2; i > 0; i--) {
	    pushDown(i);
	}
    }
    
    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
        int index = 1;
	T removedData = data[index];
	while (index * 2 + 1 <= size) {
	    swap(index, index * 2 + 1);
	    index = index * 2 + 1;
	}
	if (index * 2 <= size) { //if there is only the left child
	    swap(index, index * 2);
	    index = index * 2;
	}
	data[index] = null;
	size--;
	return removedData;
    }

    public T peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[1];
    }
    
    public void add(T x) {
	if (size == data.length + 1) {
	    doubleSize();
	}
	data[size+1] = x;
	pushUp(size+1);
	size++;
    }
    
    private void doubleSize() {
	Object[] newAry = (T[]) new Object[data.length * 2];
	for (int i = 1; i <= size; i++) {
	    newAry[i] = data[i];
	}
    }

    public String toString() {
        String ans = "[";
	for (int i = 1; i <= size; i++) {
	    ans += data[i] + ", ";
	}
	return ans + "]";
    }
    
    private void swap(int index1, int index2) {
	T temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }

    //write this -- the crux of isMax and isMin
    private int compare(T value1, T value2) {
	if (isMax) {
	    return value1.compareTo(value2);
	} else {
	    return value2.compareTo(value1);
	}
    }
    
    //do this last
    public MyHeap(boolean isMax) {
	this.isMax = isMax;
    }
    
    public MyHeap(T[] array, boolean isMax) {
	this(array);
	this.isMax = isMax;
    }
    
}
