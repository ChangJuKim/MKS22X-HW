import java.util.*;

public class MyDeque<T> {
    private T[] data;
    private int start, end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    //puts the starting value at 0
    public T[] increaseSize(int newSize) {
	T[] newData = (T[]) new Object[newSize];
	int currIndex;
	for (int i = 0; i < size; i++) {
	    currIndex = (start + i) % size;
	    newData[i] = data[currIndex];
	}
	start = 0;
	end = size-1;
	size = newSize;
	return newData;
    }
    

    //increases the start by 1
    //note: this will decrease size
    private void incrementStart() {
	start = (start + 1) % size;
	size -= 1;
    }
    
    public void addFirst(T n) {
	if (size == data.length) {
	    increaseSize(size + 10);
	}
	int index = (start - 1) % size;
	data[index] = n;
	size += 1;
    }

    public void addLast(T n) {
	if (size == data.length) {
	    increaseSize(size + 10);
	}
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
