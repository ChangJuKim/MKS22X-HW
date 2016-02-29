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
	    
	    board = new board[rows][cols];
	    steps = line.nextInt();

	    getBoard(in);
	    startx = in.nextInt();
	    starty = in.nextInt();
	    endx = in.nextInt();
	    endy = in.nextInt();
	}
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
    }

    public void getBoard(Scanner in) {
	char toAdd;
	for (int i = 0; i < board.length; i++) {
	    Scanner line = new Scanner(in.nextLine());
	    for (int j = 0; j < board[i].length; j++) {
		toAdd = line.nextChar();
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
}
