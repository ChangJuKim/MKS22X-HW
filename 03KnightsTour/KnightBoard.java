public class KnightBoard {
    final int[][] knightMoves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    private boolean closedTour = false;
    
    private int[][] board;
    private int counter;
    private boolean DEBUGComp = false;
    private boolean DEBUG = false;

    //comprehensive debugging
    private void debugComp(String message) {
	if (DEBUGComp) {System.out.println(message);}
    }
    //basic debugging
    private void debug(String message) {
	if (DEBUGComp || DEBUG) {System.out.println(message);}
    }
    
    public KnightBoard(int sizex, int sizey, int initx, int inity) {
	board = new int[sizex][sizey];
	//	knightx = initx;
	//	knighty = inity;
	counter = 1;
    }
    public KnightBoard(int sizex, int sizey) {
	this(sizex, sizey, 0, 0);
    }
    public KnightBoard(int size) {
	this(size, size, 0, 0);
    }
    public KnightBoard() {
	this(4);
    }
    
    public boolean solve() {
	return move(0, 0, 1);
    }

    public void printSolution() {
	System.out.println(toString());
    }

    //not working yet
    public boolean move(int knightx, int knighty, int counter) {
	//moves the knight
	board[knightx][knighty] = counter;
	debug(toString());
	if (closedTour) {
	    if (board[knightx][knighty] == 1) {
		debug("Returned true!!");
		return true;
	    }
	} else {
	    if (counter == board.length * board[0].length) {
		debug("Returned true!!");
		return true;
	    }
	}
	for (int i = 0; i < knightMoves.length; i++) {
	    if (canMoveThere(knightx, knighty, knightMoves[i][0], knightMoves[i][1])) {
		if (move(knightx + knightMoves[i][0], knighty + knightMoves[i][1], counter+1)) {
		    return true;
		}
	    }
	}
	board[knightx][knighty] = 0;
	return false;
    }

    private boolean canMoveThere(int knightx, int knighty, int deltax, int deltay) {
	int newx = knightx + deltax;
	int newy = knighty + deltay;
	if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) {
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
		    if (board[r/2][c/2] >= 10 || board[r/2][c/2] <= -10) {
			//if it's a 2-digit number
			ans += board[r/2][c/2];
		    }
		    else {
			//if it's a 1-digit number
			ans += " " + board[r/2][c/2];
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

    public static void main(String[]args) {
	KnightBoard b = new KnightBoard(3, 4);
        b.solve();
	b.printSolution();
    }
}
