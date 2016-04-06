import java.util.*;

public class MyDeque<T> {
    private T[] data;
    private int start, end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (T[]) new Object[10];
    }
    /*
    public T[] increaseSize(int newSize) {
	T[] newData = new T[newSize];
	int currIndex;
	for (int i = 0; i < size; i++) {
	    currIndex = (start + i) % size;
	}
    }
    */

    //increases the start by 1
    //note: this will decrease size
    private void incrementStart() {
	start = (start + 1) % size;
	size -= 1;
    }
    
    public void addFirst(T n) {
	int index = (start - 1) % size;
	data[index] = n;
	size += 1;
    }

    public void addLast(T n) {
	int index = (end + 1) % size;
	data[index] = n;
	size += 1;
    }

    public T removeFirst() {
	checkNoElementException();
	T ans = data[start];
	start = (start + 1) % size;
	size -= 1;
	return ans;
    }

    public T removeLast() {
	checkNoElementException();
	T ans = data[end];
	end = (end - 1) % size;
	size -= 1;
	return ans;
    }

    public T getFirst() {
	checkNoElementException();
	return data[start];
    }

    public T getLast() {
	checkNoElementException();
	return data[end];
    }

    //checks if not enough elements
    private void checkNoElementException() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }
}
