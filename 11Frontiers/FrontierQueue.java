import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    //java queue is an interface
    private LinkedList<T> queue = new LinkedList<T>();

    public void add(T element) {
	queue.add(element);
    }

    public T next() {
	return queue.remove();
    }

    public boolean hasNext() {
	return queue.size() == 0;
    }
}
