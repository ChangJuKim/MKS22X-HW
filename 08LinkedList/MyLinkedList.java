public class MyLinkedList {
    public LNode head;
    public int size;

    public MyLinkedList() {
	head = new LNode();
    }
    
    private class LNode {
	public int data;
	public LNode next;
	
	public LNode() {}
	public LNode(int value) { data = value; }

	public int getData() { return data; }
	public LNode getNext() { return next; }
	public void setValue(int v) { value = v; }
	public void setNext(LNode n) { next = n; }
    }
    
    
    //cannot handle circle lists
    //cannot handle empty lists
    public String toString() {
	String ans = "["
	LNode current = head;
	
	while (current != null) {
	    ans += current.getData + ", ";
	    current = getNext;
	}
	return ans + "]";
    }

    //adds value to end
    public boolean add(int value) {
	LNode current = start;
	if (head == null) {
	    head = new LNode(value);
	}
	while (current.getNext() != null) {
	    current = next;
	}
	current.setNext(new LNode(value));
    }

    public boolean add(int index, int value) {
	LNode current = head;
	if (index == 0) {
	    //placeholder
	    current = head;
	    head = new LNode(value);
	    head.setNext(current);
	}
	//gets to the right location
	int counter = 0;
	while (counter < index - 1) {
	    current = current.getNext();
	    counter += 1;
	}
	//placeholder
	LNode tail = current.next();
	current.setNext(new LNode(value));
	current.getNext.setNext(tail);
	return true;
    }

    //gets the value at the index
    //assumes index is within bounds
    public int get(int index) {
	LNode current = head;
	int counter = 0;
	while (counter < index) {
	    current = getNext();
	    counter += 1;
	}
	return current.getData();
    }

    public boolean set(int index, int value) {
	LNode current = head;
	int counter = 0;
	while (counter < index) {
	    current = getNext();
	    counter += 1;
	}
	current.setData(value);
	return true;
    }

    //need to edit from below this!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public int remove(int index) {
	LNode current = head;
	if (index == 0) {
	    if (head != null) {
		head = head.getNext();
	    }
	    else {
		System.out.println("Removing a null object!");
	    }
	}
	int counter = 0;
	while (counter < index-1) {
	    current = current.getNext();
	    counter += 1;
	}
	
	int removedValue = next.data;
	next = next.next;
	return removedValue;
    }

    public int size() {
	LNode current = this;
	int counter = 1;
	while (next != null) {
	    counter += 1;
	}
	return counter;
    }

    public int indexOf(int value) {
	LNode current = this;
	int index = 0;
	while (next != null) {
	    current = current.next;
	    index += 1;
	    if (current.data == value) {
		return index;
	    }
	}
	return -1;
    }
        
    /*
      Tested:
      toString
      add(int)
      get
      set

      Need to test:
      add(int, int)
      size
      indexOf
      remove
    */
    public static void main(String[]args) {
	MyLinkedList m = new MyLinkedList();
	/*
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
	*/

	m.start.data = 1;
	m.start.add(2);
	m.start.add(3);
	m.start.add(4);
	m.start.add(5);
	m.start.add(6);
	m.start.add(7);
	System.out.println("initial: "+m.start.toString());
	//	m.start.add(0, 100);
	m.start.add(4, 200);
	System.out.println("add 0,100 -- 4,200\n"+m.start.toString());
    }
}
