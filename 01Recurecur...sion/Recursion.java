import java.lang.*;

public class Recursion {
    public String name() {
	return "Kim,Chang Ju";
    }

    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 0;
	}
	return sqrt(n, n / 30);
    }
    
    public double sqrt(double n, double guess) {
	if (isClose(n, guess)) {
	    return guess;
	}
	return sqrt(n, ((n / guess) + guess) / 2);
    }

    public boolean isClose(double n, double guess) {
	return (Math.abs((guess * guess) - n) / n < .000000001);
    }

    public static void main(String[]args) {
	Recursion r = new Recursion();
	System.out.println(r.sqrt(0));
	System.out.println(r.sqrt(10));
	System.out.println(r.sqrt(20));
	System.out.println(r.sqrt(5));
	System.out.println(r.sqrt(-3));
    }
}

