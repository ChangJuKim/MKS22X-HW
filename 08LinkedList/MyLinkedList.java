public class MyLinkedList {
    public LNode head;
    public int size;

    public MyLinkedList() {
	head = new LNode();
    }
    
    private class LNode {
	public int data;
	public LNode next;
	
	public LNode() {
	    
	}
	public LNode(int value) { data = value; }

	public int getData() { return data; }
	public LNode getNext() { return next; }
	public void setData(int v) { data = v; }
	public void setNext(LNode n) { next = n; }
    }

    public int size() {	return size; }
    
    //cannot handle circle lists
    //cannot handle empty lists
    public String toString() {
	String ans = "[";
	LNode current = head;
	int index = 0;
	
	while (index < size) {
	    ans += current.getData() + ", ";
	    current = current.getNext();
	    index += 1;
	}
	return ans + "]";
    }

    //adds value to end
    public boolean add(int value) {
	LNode current = head;
	if (head == null) {
	    head = new LNode(value);
	}
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	current.setNext(new LNode(value));
	size += 1;
	return true;
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
	LNode tail = current.getNext();
	current.setNext(new LNode(value));
	current.getNext().setNext(tail);
	size += 1;
	return true;
    }

    //gets the value at the index
    //assumes index is within bounds
    public int get(int index) {
	LNode current = head;
	int counter = 0;
	while (counter < index) {
	    current = current.getNext();
	    counter += 1;
	}
	return current.getData();
    }

    public boolean set(int index, int value) {
	LNode current = head;
	int counter = 0;
	while (counter < index) {
	    current = current.getNext();
	    counter += 1;
	}
	current.setData(value);
	return true;
    }

    public int remove(int index) {
	if (index >= size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	if (index == 0) {
	    head = head.getNext();
	    size -= 1;
	    return current.getData();
	}
	int counter = 0;
	//makes current immediately before the list to be removed
	while (counter < index-1) {
	    if (current != null) {
		current = current.getNext();
		counter += 1;
	    }
	}
	
	int removedValue = current.getNext().getData();
	//skips over next list
	current.setNext(current.getNext().getNext());
	size -= 1;
	return removedValue;
    }

    /*
      public int remove(int index) {
	if (index >= size() || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	else {
	    LNode current = head;
	    int counter = 0;
	    while (counter < index-1) {
		counter += 1;
		current = current.getNext();
		
	    }
	}
    }
    */

    public int indexOf(int value) {
	LNode current = head;
	int index = 0;
	while (current != null) {
	    if (current.getData() == value) {
		return index;
	    }
	    index += 1;
	}
	return -1;
    }
        
    /*
      Tested:

      toString
      add(int)
      get
      size
      set
      remove

      Need to test:

      indexOf

      Errors:

      add(int, int);
    */
    public static void main(String[]args) {
	MyLinkedList m = new MyLinkedList();
	System.out.println("~~~~~~~~~~~~~~~Creating list~~~~~~~~~~~~~~~\n");
	for (int i = 0; i < 5; i++) {
	    m.add(i);
	    System.out.println(i+" List: "+m.toString());
	}
	
	System.out.println("\n\n~~~~~~~~~~~Getting values~~~~~~~~~~~~~~\n");
	for (int i = 0; i < m.size(); i++) {
	    System.out.println(m.get(i));
	}
	System.out.println("\n\n~~~~~~~~~~~Setting values~~~~~~~~~~~~~~\n");
	for (int i = 0; i < m.size(); i++) {
	    m.set(m.size()-i-1, i);
	    System.out.println(m.toString());
	}

	/*
	System.out.println("\n\n~~~~~~~~~~~Adding values at index~~~~~~\n");
        
	m.add(0, 30);
	System.out.println(m.toString());
	m.add(2, 40);
	System.out.println(m.toString());
	m.add(6, 50);
	System.out.println(m.toString());

	*/

	System.out.println("\n\n~~~~~~~~~~~Getting Index of values~~~~\n");

	System.out.println(m.toString());
	for (int i = 0; i < m.size(); i++) {
	    System.out.println(m.indexOf(i));
	}
	
	System.out.println("\n\nSize: "+m.size());
	System.out.println("\n~~~~~~~~~~~Removing values~~~~~~~~~~~~\n");
	for (int i = 0; i < m.size();) {
	    m.remove(m.size()-1);
	    System.out.println(m.toString());
	}
	
	/*
	System.out.println("Start: "+m.toString());
	m.add(1);
	System.out.println("One list");
	System.out.println(m.toString()+"\n");
	
	m.add(2);
	System.out.println("Two list");
	System.out.println(m.toString()+"\n");
	
	System.out.println("get0: "+m.start.get(0));
	System.out.println("get1: "+m.start.get(1));
	m.start.set(1, 3);
	System.out.println("get1 after set1: "+m.start.get(1));
	*/
    }
}
