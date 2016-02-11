public class KnightBoard {
    private int[][] board;
    private boolean DEBUGComp = true;
    private boolean DEBUG = true;

    //for when you want comprehensive debug messages -- may overflood the board
    private void debugComp(String message) {
	if (DEBUGComp) {System.out.println(message);}
    }
    //for basic debugging tools
    private void debug(String message) {
	if (DEBUGComp || DEBUG) {System.out.println(message);}
    }
    
    public KnightBoard(int size) {
	board = new int[size][size];
    }
    public KnightBoard() {
	this(4);
    }

    private boolean canMoveThere(int xinit, int yinit, int deltax, int deltay) {
	int newx = xinit + deltax;
	int newy = yinit + deltay;
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
		    //ans += board[r/2][c/2];
		    if (board[r/2][c/2] == 1) {
			ans += "Q";
		    } else {
			ans += " ";
		    }
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
}
