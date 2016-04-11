import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    private Stack<T> stack = new Stack<T>();
    
    public void add(T element) {
	stack.push(element);
    }

    public T next() {
	return stack.pop();
    }

    public boolean hasNext() {
	return stack.isEmpty();
    }
}
