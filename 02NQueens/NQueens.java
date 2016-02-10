public class NQueens {
    int[][] board;

    public NQueens(int size) {
	board = new int[size][size];
    }
    public NQueens() {
	this(5);
    }
    
    //marks where the queen can attack
    public void markNegatives(int i, int j) {
	//preserves original values;
	int x = i;
	int y = j;
	//horizontal
	for (j = j+1; j < board.length; j++) {
	    board[i][j] -= 1;
	}
	//diagonal up
	i = x - 1; //prevents queen's location from being marked
	j = y + 1;
	while (i >= 0 && j < board[i].length) {
	    board[i][j] -= 1;
	    i--;
	    j++;
	}
	//diagonal down
	i = x + 1; //prevents queen's location from being marked
	j = y + 1;
	while (i < board.length && j < board[i].length) {
	    board[i][j] -= 1;
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
	NQueens test1 = new NQueens();
	System.out.println(test1.toString());
	test1.markNegatives(2, 2);
	System.out.println(test1.toString());
    }
}
