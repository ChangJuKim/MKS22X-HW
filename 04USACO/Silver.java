import java.util.*;
import java.io.*;
import java.lang.*;

public class Silver {
    int[][] board;
    int steps;
    int startx, starty, endx, endy;

    boolean debug = false;

    public Silver(String text) {
	try {
	    Scanner in = new Scanner(new File(text));
	    Scanner line = new Scanner(in.nextLine());
	    int rows = line.nextInt();
	    int cols = line.nextInt();
	    
	    board = new int[rows][cols];
	    steps = line.nextInt();

	    getBoard(in);
	    //-1 for board indecies
	    startx = in.nextInt() - 1;
	    starty = in.nextInt() - 1;
	    endx = in.nextInt() - 1;
	    endy = in.nextInt() - 1;
	    board[startx][starty] = 1;
	    debug("steps: "+steps);
	    debug("board dimensions: "+board.length+", "+board[0].length);
	    debug(toString());
	    
	    solve();
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

    public void solve() {
	//steps gets reduced in updateBoard
	while (steps > 0) {
	    debug(""+steps);
	    updateBoard();
	}
	System.out.println(""+board[endx][endy] + ", 6, Kim, ChangJu");
    }

    //reduces steps by one and sees next part of tree
    public void updateBoard() {
	//makes sure everythings updated at once
	int[][] nextBoard = new int[board.length][board[0].length];
	steps -= 1;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		nextBoard[i][j] = getNextStep(i, j);
	    }
	}
	
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = nextBoard[i][j];	
	    }
	}
	debug(toString());
    }

    //gets the next step for one spot on the board
    public int getNextStep(int r, int c) {
	int totalSum = 0;
	if (r != 0) {
	    //trees
       	    if (board[r-1][c] >= 0) {
		totalSum += board[r-1][c];
	    }
	}
	
	if (c != 0) {
	    if (board[r][c-1] >= 0) {
		totalSum += board[r][c-1];
	    }
	}
	
	if (r != board.length - 1) {
	    if (board[r+1][c] >= 0) {
		totalSum += board[r+1][c];
	    }
	}
	
	if (c != board[r].length - 1) {
	    if (board[r][c+1] >= 0) {
		totalSum += board[r][c+1];
	    }
	}

	if (board[r][c] < 0) {
	    totalSum = -1;
	}
	return totalSum;
    }

    public String toString() {
	String ans = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		ans += board[i][j] + "\t     ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public void debug(String message) {
	if (debug) {
	    System.out.println(message);
	}
    }
    
    public static void main(String[]args) {
	Silver medal = new Silver("ctravel.in");
    }
}
