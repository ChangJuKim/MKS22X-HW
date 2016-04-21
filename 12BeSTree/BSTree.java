public class BSTree <T extends Comparable<T>> {

    private Node root;
    
    private class Node {
	Node left, right;
	T data;

	public Node(T value) {
	    data = value;
	}

	private boolean isEmpty() {
	    return data == null;
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

	public String toString() {
	    String ans = "";
	    if (isEmpty()) {
		ans += "_";
	    } else {
		ans += ""+data+" "+left.toString()+" "+" "+right.toString();
	    }
	    return ans;
	}
    }
}
