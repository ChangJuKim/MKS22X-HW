public class ParenDemo extends MyStack<Character> {
    private static final char[] open = new char[]{'(', '[', '<', '{'};
    private static final char[] close = new char[]{')', ']', '>', '}'};
    private static MyStack<Character> stack = new MyStack<Character>();

    public static boolean isMatching(String s) {
	for (int i = 0; i < s.length(); i++) {
	    if (isOpen(s.charAt(i))) {
		System.out.println("Stack: "+stack);
		System.out.println("The character i'm pushing: "+s.charAt(i));
		stack.push(s.charAt(i));
		System.out.println("After opening: "+stack);
	    }
	    if (isClose(s.charAt(i))) {
		System.out.println(stack);
		System.out.println("Is the stack empty? "+stack.isEmpty());
		System.out.println("Is the closing matching? "+stack.peek());
		if (stack.isEmpty() || isMatches(stack.pop(), s.charAt(i))) {
		    badMessage(s.charAt(i));
		    return false;
		}
	    }
	}
	return true;
    }

    private static boolean isOpen(char c) {
	System.out.println("Testing if "+c+" is open");
	for (int i = 0; i < open.length; i++) {
	    if (c == open[i]) {
		System.out.println("It was...");
		return true;
	    }
	}
	System.out.println("It was not...");
	return false;
    }

    private static boolean isClose(char c) {
	for (int i = 0; i < close.length; i++) {
	    if (c == close[i]) {
		return true;
	    }
	}
	return false;
    }

    private static boolean isMatches(char openChar, char closeChar) {
	for (int i = 0; i < open.length; i++) {
	    if (open[i] == openChar && close[i] == closeChar) {
		return true;
	    }
	}
	return false;
    }

    private static void badMessage(char c) {
	System.out.println("No matching parens for "+c);
    }

    public static void main(String[]args) {
	String input = "()()()";
	if (args.length > 0) {
	    input = args[0];
	}
	System.out.println(isMatching(input));
    }
}
