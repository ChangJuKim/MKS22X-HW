import java.util.*;
import java.io.*;
import java.lang.*;

public class Silver {
    int[][] board;
    int steps;
    int startx, starty, endx, endy;

    public Silver(String text) {
	try {
	    Scanner in = new Scanner(new File(text));
	    Scanner line = new Scanner(in.nextLine());
	    int rows = line.nextInt();
	    int cols = line.nextInt();
	    
	    board = new int[rows][cols];
	    steps = line.nextInt();

	    getBoard(in);
	    startx = in.nextInt();
	    endx = in.nextInt();
	    starty = in.nextInt();
	    endy = in.nextInt();
	}
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
    }

    public void getBoard(Scanner in) {
	String nextLine;
	char toAdd;
	for (int i = 0; i < board.length; i++) {
	    Scanner line = new Scanner(in.nextLine());
	    nextLine = line.next();
	    for (int j = 0; j < board[i].length; j++) {
	        toAdd = nextLine.charAt(j);
		if (toAdd == '.') {
		    board[i][j] = 0;
		}
		else if (toAdd == '*') {
		    board[i][j] = -1;
		}
		else {
		    System.out.println("The board has a funky character--newLine?");
		    board[i][j] = -2;
		}
	    }
	}
    }

    public String toString() {
	String ans = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		ans += board[i][j];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args) {
	Silver medal = new Silver("ctravel.in");
	System.out.println(medal.toString());
	System.out.println(medal.startx+", "+medal.endx+", "+medal.starty+", "+medal.endy);
    }
}
