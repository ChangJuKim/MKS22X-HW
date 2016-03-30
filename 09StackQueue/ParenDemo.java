import java.util.Random;

public class ParenDemo extends MyStack<Character> {
    private static final char[] open = new char[]{'(', '[', '<', '{'};
    private static final char[] close = new char[]{')', ']', '>', '}'};
    private static MyStack<Character> stack = new MyStack<Character>();

    public static boolean isMatching(String s) {
	for (int i = 0; i < s.length(); i++) {
	    if (isOpen(s.charAt(i))) {
		stack.push(s.charAt(i));
	    }
	    if (isClose(s.charAt(i))) {
		if (stack.isEmpty() || !isMatches(stack.pop(), s.charAt(i))) {
		    badMessage(""+s.charAt(i));
		    return false;
		}
	    }
	}
	if (stack.size() == 0) {
	    return true;
	}
	String message = "";
	for (int i = 0; i < stack.size();) {
	    message += stack.remove(stack.size-1);
	}
	badMessage(message);
	return false;
    }

    private static boolean isOpen(char c) {
	//System.out.println("Testing if "+c+" is open");
	for (int i = 0; i < open.length; i++) {
	    if (c == open[i]) {
		//System.out.println("It was...");
		return true;
	    }
	}
	//System.out.println("It was not...");
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
	//System.out.println("Open, Close: "+openChar+" "+closeChar);
	for (int i = 0; i < open.length; i++) {
	    //System.out.println(open[i]+" -- "+(openChar == open[i]));
	    //System.out.println(close[i]+" -- "+(closeChar == close[i]));
	    if (open[i] == openChar && close[i] == closeChar) {
		return true;
	    }
	}
	return false;
    }

    private static void badMessage(String s) {
	System.out.println("No matching parens for "+s);
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}
