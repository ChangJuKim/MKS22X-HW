public class BSTree <T extends Comparable<T>> {

    private Node root;
    
    private class Node {
	Node left, right;
	T data;

	public Node(T value) {
	    data = value;
	}

	public void add(T value) {
	    if (isEmpty()) {
		data = value;
	    } else {
		if (data.compareTo(value) > 0) {
		    if (right.isEmpty()) {
			right = new Node(value);
		    } else {
			right.add(value);
		    }
		} else {
		    if (left.isEmpty()) {
			left = new Node(value);
		    } else {
			left.add(value);
		    }
		}
	    }
	}
    }
}
