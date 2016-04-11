import java.util.*;

public class FrontierStack<Node> implements Frontier<Node>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    private Stack<Node> stack = new Stack<Node>();
    
    public void add(Node element) {
	stack.push(element);
    }

    public Node next() {
	return stack.pop();
    }

    public boolean hasNext() {
	return !stack.isEmpty();
    }
}
