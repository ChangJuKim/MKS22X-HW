import java.util.*;

public class FrontierQueue<Node> implements Frontier<Node>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    //java queue is an interface
    private LinkedList<Node> queue = new LinkedList<Node>();

    public void add(Node n) {
	queue.add(n);
    }

    public Node next() {
	return queue.remove();
    }

    public boolean hasNext() {
	return queue.size() != 0;
    }
}
