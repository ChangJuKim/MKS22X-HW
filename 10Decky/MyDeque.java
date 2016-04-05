import java.util.*;

public class MyDeque<T> {
    private T[] data;
    private int start, end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (T[]) new Object[10];
    }

    public void addFirst(T n) {
	
    }

    public void addLast(T n) {

    }

    public T removeFirst() {
	checkNoElementException();
    }

    public T removeLast() {
	checkNoElementException();
    }

    public T getFirst() {
	checkNoElementException();
    }

    public T getLast() {
	checkNoElementException();
    }

    //checks if not enough elements
    private void checkNoElementException() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }
}
