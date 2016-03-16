public class MyLinkedList {
    public LNode start;
    public int size;

    public MyLinkedList() {
	start = new LNode();
    }

    private class LNode {
	public int data;
	public LNode next;

	public LNode() {}

	//cannot handle circle lists
	//cannot handle empty lists
	public String toString() {
	    String ans = "["+data+", ";
	    LNode current = this;

	    while (current.next != null) {
		current = next;
		ans += current.data + ", ";
	    }
	    return ans + "]";
	}

	//adds value to end
	public boolean add(int value) {
	    LNode current = this;
	    while (current.next != null) {
		current = next;
	    }
	    next = new LNode();
	    next.data = value;
	    next.next = null;
	    return true;
	}

	public boolean add(int index, int value) {
	    LNode current = this;
	    int counter = 0;
	    while (counter < index - 1) {
		current = next;
		counter += 1;
	    }
	    LNode tail = current.next;
	    current.next = new LNode();
	    current.next.next = tail;
	    current.data = value;
	    return true;
	}

	//gets the value at the index
	//assumes index is within bounds
	public int get(int index) {
	    LNode current = this;
	    int counter = 0;
	    while (counter < index) {
		current = next;
		counter += 1;
	    }
	    return current.data;
	}

	public boolean set(int index, int value) {
	    LNode current = this;
	    int counter = 0;
	    while (counter < index) {
		current = next;
		counter += 1;
	    }
	    current.data = value;
	    return true;
	}

	public int remove(int index) {
	    LNode current = this;
	    int counter = 0;
	    while (counter < index-1) {
		current = next;
		counter += 1;
	    }
	    int removedValue = next.data;
	    next = next.next;
	    return removedValue;
	}

    }
    
    

    public static void main(String[]args) {
	MyLinkedList m = new MyLinkedList();
	m.start.data = 1;
	System.out.println("One list");
	System.out.println(m.start.toString()+"\n");

	m.start.add(2);
	System.out.println("Two list");
	System.out.println(m.start.toString()+"\n");
	
	System.out.println("get0: "+m.start.get(0));
	System.out.println("get1: "+m.start.get(1));
	m.start.set(1, 3);
	System.out.println("get1 after set1: "+m.start.get(1));
    }
}
