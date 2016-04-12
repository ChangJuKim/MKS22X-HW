import java.util.*;
import java.io.*;

public class BetterMaze{
    
    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

    /*
    public Maze(String filename, boolean ani){
	animate = ani;
        //COMPLETE CONSTRUCTOR
	try {
	    Scanner in = new Scanner(new File(filename));
	    String s = "";
	    //total rows/columns of the maze
	    int rows = 0;
	    int cols;
	    while (in.hasNext()) {
		rows += 1;
		s += in.nextLine() + "\n";
	    }
	    cols = s.length() / rows;

	    maze = new char[rows][cols];
	    //repurposed for maze indecies
	    rows = 0;
	    cols = 0;
	    for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) != '\n') {
		    maze[i / maze[0].length][i % maze[0].length] = s.charAt(i);
		}
	    }
	}
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
    }
    */

    
    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        int[] copy = new int[solution.length];
	for (int i = 0; i < solution.length; i++) {
	    copy[i] = solution[i];
	}
	return copy;
    }    
    

    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){
	placesToGo = new FrontierQueue<Node> ();
	return solve();
    }   
    
    
    /**initialize the frontier as a stack and call solve
     **/ 
    public boolean solveDFS(){
	placesToGo = new FrontierStack<Node> ();
        return solve(); 
    }

    private boolean canMoveThere(int x, int y, int deltax, int deltay) {
	if (maze[x+deltax][y+deltay] == '#' || maze[x+deltax][y+deltay] == '.' || maze[x+deltax][y+deltay] == '@') {
	    return false;
	} else if (maze[x+deltax][y+deltay] == ' ' || maze[x+deltax][y+deltay] == 'E') {
	    return true;
	} else {
	    System.out.println("We have some funky things in our maze!!");
	    //better not to test unknown features in our maze!!
	    return false;
	}
    }
    
    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    public boolean solve(){
	Node current;
	if (placesToGo.hasNext()) {
	    current = placesToGo.next();
	} else {
	    return false;
	}
	int x = current.getX();
	int y = current.getY();
	//base case
	if (maze[x][y] == 'E') {
	    getPath(current);
	    return true;
	}
	if (canMoveThere(x, y, 1, 0)) {
	    placesToGo.add(new Node(x+1, y));
	}
	if (canMoveThere(x, y, 0, 1)) {
	    placesToGo.add(new Node(x, y+1));
	}
	if (canMoveThere(x, y, -1, 0)) {
	    placesToGo.add(new Node(x-1, y));
	}
	if (canMoveThere(x, y, 0, -1)) {
	    placesToGo.add(new Node(x, y-1));
	}
	return solve();
    }

    public void getPath(Node n) {
	int index = 0;
	while (n.getPrev() != null) {
	    if (index == solution.length - 2) {
	        int[] newSolution = new int[solution.length * 4];
		for (int i = 0; i < solution.length; i++) {
		    newSolution[i] = solution[i];
		}
		solution = newSolution;
	    }
	    solution[index] = n.getX();
	    solution[index+1] = n.getY();
	    index += 2;
	}
    }
     
    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  animate = b; }    
    
    

}
