import java.util.*;

public class MyQueue<T> extends MyLinkedList<T>{
    /**
     * Adds the given item to the rear of the queue.
     */
    //adds to tail
    public void enqueue(T item) {
	add(0, item);
    }
    
    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    //removes from tail
    public T dequeue() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    return remove(size()-1);
	}
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    return get(size()-1);
	}
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size() {
	return size;
    }
    
    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty() {
	return size() == 0;
    }
}
