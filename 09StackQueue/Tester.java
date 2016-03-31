import java.util.*;

public class Tester {
    public static void main(String[]args) {
	// testing stack
	MyStack<Integer> stackTest = new MyStack<Integer>();
	Stack<Integer> stackJava = new Stack<Integer>();
	Random rand = new Random();
	int initialPushes = rand.nextInt(30)+150;
	int next;
	for (int i = 0; i < initialPushes; i++) {
	    next = rand.nextInt(1000);
	    //System.out.println(next);
	    stackTest.push(next);
	    //System.out.println(next);
	    stackJava.push(next);
	    
	}
	System.out.println(stackTest);
	System.out.println(stackJava);
	int repeats = rand.nextInt(20)+100;
	for (int i = 0; i < repeats; i++) {
	    if (rand.nextInt(2) == 1) {
		if (stackTest.pop() != stackJava.pop()) {
		    System.out.println("Stacks not equal!");
		}
	    } else {
		next = rand.nextInt(1000)+1000;
		//stackTest.push(next);
		//stackJava.push(next);
	    }
	}
	//System.out.println(stackTest);
	//System.out.println(stackJava);
	while (!stackTest.isEmpty() || !stackJava.isEmpty()) {
	    if (stackTest.pop() != stackJava.pop()) {
		System.out.println("Stacks not equal");
	    }
	}
	System.out.println(stackTest.isEmpty() && stackJava.isEmpty());
    }
}
