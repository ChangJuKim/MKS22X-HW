public class Bronze {
    int[][] field;
    int rows, cols, elevation, numDirections;

    public Bronze(String text) {
	String s = textToString(text);
	int[] firstLine = getFirstLine(s);
	rows = firstLine[0];
	cols = firstLine[1];
	elevation = firstLine[2];
	numDirections = firstLine[3];
    }
    
    public String textToString(String text) {
	String s = "";
	try {
	    Scanner in = new Scanner(new File(text));
	    while (in.hasNext()) {
		s += in.nextLine() + "\n";
	    }
	}
	catch (FileNotFoundException ex) {
	    System.out.println("File not found!");
	}
	return s;
    }

    //gives first line of string ( [rows, columns, elevation, #directions])
    public int[] getFirstLine(String s) {
	int i = 0;
	int arrayCounter = 0;
	int[] ans = new int[4]
	while (i < s.length()) {
	    if (s.getChar(i) != ' ') {
		ans[arrayCounter] = s.getChar(i);
		i += 1;
		arrayCounter += 1;
	    }
	}
	return ans;
    }
}
