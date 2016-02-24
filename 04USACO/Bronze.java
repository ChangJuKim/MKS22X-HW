import java.util.*;
import java.io.*;
import java.lang.*;

/*
  checklist:
    read file          done!!
    stomp using data   done!!
    volume using data  
 */

public class Bronze {
    private boolean debug = false;
    
    private int[][] field;
    private int[][] directions;
    private int rows, cols, elevation, numDirections;

    public Bronze(String text) {
	try {
	    Scanner in = new Scanner(new File(text));
	    Scanner line = new Scanner(in.nextLine());
	    rows = line.nextInt();
	    cols = line.nextInt();
	    elevation = line.nextInt();
	    numDirections = line.nextInt();
	    field = new int[rows][cols];
	    directions = new int[numDirections][3];
	    
	    getField(in);
	    getDirections(in);
	}
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
    }

    public void getField(Scanner in) {
	for (int r = 0; r < rows; r++) {
	    Scanner line = new Scanner(in.nextLine());
	    //printScannerContents(line);
	    for (int c = 0; c < cols; c++) {
		field[r][c] = line.nextInt();
	    }
	}
    }

    public void getDirections(Scanner in) {
	for (int i = 0; i < numDirections; i++) {
	    Scanner line = new Scanner(in.nextLine());
	    directions[i][0] = line.nextInt();
	    directions[i][1] = line.nextInt();
	    directions[i][2] = line.nextInt();
	}
    }

    public int[][] getNextStomp(int r, int c) {
	int max = -1;
	int ans[][] = new int[9][2];
	int ansCounter = 0;

	//fills unnecessary spots with negative values
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 2; j++) {
		ans[i][j] = -1;
	    }
	}
	//finds the max
	for (int i = r; i < r+3; i++) {
	    for (int j = c; j < c+3; j++) {
		if (field[i][j] > max) {
		    max = field[i][j];
		}
	    }
	}
	//finds the coordinates that are the max
	for (int i = r; i < r+3; i++) {
	    for (int j = c; j < c+3; j++) {
		if (field[i][j] == max) {
		    ans[ansCounter][0] = i;
		    ans[ansCounter][1] = j;
		    ansCounter += 1;
		}
	    }
	}
	return ans;
    }
    
    //row, column, depth
    public void stompH(int r, int c, int d) {
	int counter;
	int[][] nextStomp;
	int x, y;
	while(d > 0) {
	    counter = 0;
	    nextStomp = getNextStomp(r, c);
	    x = nextStomp[counter][0];
	    y = nextStomp[counter][1];
	    //while there is a legitimate location to stomp
	    while (counter < 9 && nextStomp[counter][0] >= 0) {
		x = nextStomp[counter][0];
		y = nextStomp[counter][1];
		field[x][y] -= 1;
		counter += 1;
	    }
	    d -= 1;
	}
    }

    public void stomp() {
	for (int i = 0; i < directions.length; i++) {
	    //-1 to accomodate for rows/cols starting at 0
	    stompH(directions[i][0]-1, directions[i][1]-1, directions[i][2]);
	    if (debug) {printAll();}
	}
    }

    public void getWaterElevation() {
	for (int r = 0; r < field.length; r++) {
	    for (int i = 0; i < field[r].length; i++) {
		field[r][i] = elevation - field[r][i];
		if (field[r][i] < 0) {
		    field[r][i] = 0;
		}
	    }
	}
    }

    public int getVolume() {
	int totalDepth = 0;
	for (int r = 0; r < field.length; r++) {
	    for (int i = 0; i < field[r].length; i++) {
		totalDepth += field[r][i];
	    }
	}
	return totalDepth * 72 * 72;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~Prints~~~~~~~~~~~~~~~~~~~~~

    private void printScannerContents(Scanner s) {
	while (s.hasNext()) {
	    System.out.println(s.nextInt());
	}
    }

    private void print2DArray(int[][] ary) {
	System.out.print("[\n");
	for (int i = 0; i < ary.length; i++) {
	    System.out.print("[");
	    for (int j = 0; j < ary[i].length; j++) {
		System.out.print(ary[i][j]+", ");
	    }
	    System.out.print("]\n");
	}
    }

    public void printAll() {
	System.out.println("" + rows+" "+cols+" "+elevation+" "+numDirections);
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		System.out.print(field[i][j] + " ");
	    }
	    System.out.print("\n");
	}
	for (int i = 0; i < directions.length; i++) {
	    System.out.println(directions[i][0]+" "+directions[i][1]+" "+directions[i][2]);
	}
    }

    public static void main(String[]args) {
	Bronze medal = new Bronze("makelake.in");
	medal.stomp();
	medal.getWaterElevation();
	if (medal.debug) {medal.printAll();}
	System.out.println(medal.getVolume() + ",6,Kim,Chang Ju");
	
    }
}
