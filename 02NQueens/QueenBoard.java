public class QueenBoard {
    int[][] board;

    public QueenBoard(int size) {
	board = new int[size][size];
    }
    public QueenBoard() {
	this(5);
    }

    public boolean placeQueens(int j) {
	if (j >= board.length) {
	    return false;
	}
	for (int i = 0; i < board.length; i++) {
	    //if you can put a queen
	    if (board[i][j] >= 0) {
		modifyQueen(i, j, true);
		System.out.println(toString());
		if (j == board.length - 1 && board[i][j] == 1) {
		    return true;
		    //System.out.println("~~~~~~~~~~~~~~Was True~~~~~~~~~~~~~~~~~~~");
		}
		//recursive call
		if (placeQueens(j + 1) == true) {
		    return true;
		}
		else {
		    System.out.println("~~~~~~~~~~~~~~Was False~~~~~~~~~~~~~~~~~~");
		    modifyQueen(i, j, false);
		}
		return false;
	    }
	}
	return false;
    }
    
    //marks where the queen can attack
    public void modifyQueen(int i, int j, boolean place) {
	//preserves original values;
	int x = i;
	int y = j;
	int offset;
	if (place) {
	    //adds a queen
	    board[i][j] = 1;
	    offset = -1;
	} else {
	    //removes a queen
	    board[i][j] = 0;
	    offset = 1;
	}
	//horizontal
	for (j = j+1; j < board.length; j++) {
	    board[i][j] += offset;
	}
	//diagonal up
	i = x - 1; //prevents queen's location from being marked
	j = y + 1;
	while (i >= 0 && j < board[i].length) {
	    board[i][j] += offset;
	    i--;
	    j++;
	}
	//diagonal down
	i = x + 1; //prevents queen's location from being marked
	j = y + 1;
	while (i < board.length && j < board[i].length) {
	    board[i][j] += offset;
	    i++;
	    j++;
	}
    }

    //copied from my WordSearch function last semester
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
	QueenBoard test1 = new QueenBoard();
	System.out.println(test1.toString());
	test1.placeQueens(0);
	System.out.println(test1.toString());
    }
}
