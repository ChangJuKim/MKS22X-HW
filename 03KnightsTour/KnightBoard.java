public class KnightBoard {
    private int[][] board;
    private int counter;
    private boolean DEBUGComp = true;
    private boolean DEBUG = true;

    //comprehensive debugging
    private void debugComp(String message) {
	if (DEBUGComp) {System.out.println(message);}
    }
    //basic debugging
    private void debug(String message) {
	if (DEBUGComp || DEBUG) {System.out.println(message);}
    }
    
    public KnightBoard(int size, int initx, int inity) {
	board = new int[size][size];
	//	knightx = initx;
	//	knighty = inity;
	counter = 1;
    }
    public KnightBoard(int size) {
	this(size, 0, 0);
    }
    public KnightBoard() {
	this(4);
    }

    //not working yet
    public boolean move(int knightx, int knighty, int counter) {
	if (board[knightx][knighty] == 1) {
	    debug("Returned true!!");
	    return true;
	}
	//can probably condense this by making an int array of deltax's and deltay's...
	if (canMoveThere(knightx, knighty, 2, 1)) {
	    board[knightx][knighty] = counter;
	    move(knightx+2, knighty+1, counter+1);
	}
	if (canMoveThere(knightx, knighty, 2, -1)) {
	    board[knightx][knighty] = counter;
	    move(knightx+2, knighty-1, counter+1);
	}
	if (canMoveThere(knightx, knighty, 1, 2)) {
	    board[knightx][knighty] = counter;
	    move(knightx+1, knighty+2, counter+1);
	}
	if (canMoveThere(knightx, knighty, 1, -2)) {
	    board[knightx][knighty] = counter;
	    move(knightx+1, knighty-2, counter+1);
	}
	if (canMoveThere(knightx, knighty, -1, 2)) {
	    board[knightx][knighty] = counter;
	    move(knightx-1, knighty+2, counter+1);
	}
	if (canMoveThere(knightx, knighty, -1, -2)) {
	    board[knightx][knighty] = counter;
	    move(knightx-1, knighty-2, counter+1);
	}
	if (canMoveThere(knightx, knighty, -2, 1)) {
	    board[knightx][knighty] = counter;
	    move(knightx-2, knighty+1, counter+1);
	}
	if (canMoveThere(knightx, knighty, -2, -1)) {
	    board[knightx][knighty] = counter;
	    move(knightx-2, knighty-1, counter+1);
	}
	debug("Returned false!!");
	return false;
    }

    //    private void updateBoard(int knightx, int knighty, int deltax, int deltay) {
    //	board[knightx][knighty] = counter;
    //    }

    private boolean canMoveThere(int knightx, int knighty, int deltax, int deltay) {
	debugComp(toString());
	int newx = knightx + deltax;
	int newy = knighty + deltay;
	if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) {
	    debugComp("Cannot move -- off the board!");
	    return false;
	}
	else if (board[newx][newy] > 0) {
	    debugComp("Cannot move -- already stepped: "+board[newx][newy]);
	    return false;
	}
	else if (board[newx][newy] == 0) {
	    return true;
	}
	else if (board[newx][newy] < 0) {
	    debugComp("Somehow got a negative number...");
	    return false;
	}
	return false;
    }

    //copied from my WordSearch(/NQueens) function last semester
    //creates a string that shows each value in a rectangular 2-d array
    public String toString(){
	String ans = "";
	for (int r = 0; r < board.length * 2; r++) { //*2 for dashes and chars
	    for (int c = 0; c < board[r/2].length * 2; c++) { //*2 for vertical lines
		if (r % 2 == 0) { //creates this: ---------
		    ans += "-";
		} else if (c % 2 == 0) {
		    ans += "|"; //creates this: | | | | | |
		} else {
		    ans += board[r/2][c/2];
		}
	    }
	    if (r % 2 == 0) {
		ans += "-"; //top right corner
	    } else {
		ans += "|"; //right column border
	    }
	    ans += "\n"; //new row
	}
	for (int c = 0; c < board[0].length; c++) {
	    ans += "--"; //bottom line
	}
	return ans + "-"; //bottom right corner
    }

    public static void main(String[]args) {
	KnightBoard b = new KnightBoard(6);
	b.move(0,0,1);
	
    }
}
