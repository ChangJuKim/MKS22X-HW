import java.util.*;
@SuppressWarnings("unchecked")

public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

    public MyHeap() {
	
    }
    public MyHeap(T[] array) {
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
	if (data[k*2].compareTo(data[k]) > 0) { //left child is larger
	    swap(k*2, k);
	    pushDown(k*2);
	}
	else if (data[k*2+1].compareTo(data[k]) > 0) { //right child is larger
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
	    if (data[k].compareTo(data[(k / 2)]) > 0) { /*if the child > parent*/
		swap(k, k/2);
		pushUp(k/2);
	    }
	    /*if parent <= child -- doesn't need to be modified*/
	}
    }

    //not done
    private void heapify() {
	
    }
    
    public T delete() {
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

    //not done
    
    //do this last
    public MyHeap(boolean isMax) {

    }
    public MyHeap(T[] array, boolean isMax) {

    }

}
