public class MyLinkedList<T> {
    public LNode head;
    public int size;
    private LNode end;

    public MyLinkedList() {
	head = new LNode();
	end = head;
    }

    private class LNode {
	public T data;
	public LNode next;
	
	public LNode() {
	    
	}
	public LNode(T value) { data = value; }

	public T getData() { return data; }
	public LNode getNext() { return next; }
	public void setData(T v) { data = v; }
	public void setNext(LNode n) { next = n; }
    }

    public int size() {	return size; }
    
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

    public String toString(boolean b) {
	String ans = "[";
	LNode current = head;
	int index = 0;
	
	while (index < size) {
	    ans += current.getData() + ", ";
	    current = current.getNext();
	    index += 1;
	}
	if (b) {
	    return ans + "] -- (head, tail): ("+head.getData()+", "+end.getData()+")";
	}
	return ans + "]";
    }

    //adds value to end
    public boolean add(T value) {
	/*
	LNode current = head;
	if (head == null) {
	    head = new LNode(value);
	}
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	current.setNext(new LNode(value));
	end = current.getNext();
	*/
	end.setNext(new LNode(value));
	end = end.getNext();
	size += 1;
	return true;
    }

    public boolean add(int index, T value) {
	LNode current = head;
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0) {
	    head = new LNode(value);
	    head.setNext(current);
	    size += 1;
	    return true;
	}
	//moves current to immediately before insertion point
	int counter = 0;
	while (counter < index - 1) {
	    current = current.getNext();
	    counter += 1;
	}
	//placeholder
	LNode tail = current.getNext();
	current.setNext(new LNode(value));
	current.getNext().setNext(tail);
	if (current == end) {
	    end = current.getNext();
	}
	size += 1;
	return true;
    }

    //gets the value at the index
    public T get(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int counter = 0;
	while (counter < index) {
	    current = current.getNext();
	    counter += 1;
	}
	return current.getData();
    }

    public boolean set(int index, T value) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int counter = 0;
	while (counter < index) {
	    current = current.getNext();
	    counter += 1;
	}
	current.setData(value);
	return true;
    }

    public T remove(int index) {
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
	
	T removedValue = current.getNext().getData();
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
	    if (current.getData().equals(value)) {
		return index;
	    }
	    index += 1;
	    current = current.getNext();
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
      indexOf
      add(int, int);

    */
    public static void main(String[]args) {
	MyLinkedList<Integer> m = new MyLinkedList<Integer>();
	System.out.println("~~~~~~~~~~~~~~~Creating list~~~~~~~~~~~~~~~\n");
	for (int i = 0; i < 20; i++) {
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
	System.out.println("\n\n~~~~~~~~~~~Adding values at index~~~~~~\n");

	System.out.println(m.toString());
	m.add(0, 10);
	System.out.println(m.toString());
	
	m.add(0, 30);
	System.out.println(m.toString());
	m.add(2, 40);
	System.out.println(m.toString());
	m.add(6, 50);
	System.out.println(m.toString());


	System.out.println("\n\n~~~~~~~~~~~Getting Index of values~~~~\n");

	System.out.println(m.toString());
	for (int i = 0; i < m.size(); i++) {
	    System.out.println("The index of "+i+": "+m.indexOf(i));
	}
	
	System.out.println("\n\nSize: "+m.size());
	System.out.println("\n~~~~~~~~~~~Removing values~~~~~~~~~~~~\n");
	for (int i = 0; i < m.size();) {
	    m.remove(m.size()-1);
	    System.out.println(m.toString());
	}
    }
}
