public class Node {
    private int[] coor = new int[2];
    private Node prev;

    public Node() {
	coor[0] = 0;
	coor[1] = 0;
    }

    public void setCoor(int x, int y) {
	coor[0] = x;
	coor[1] = y;
    }
    public void setX(int x) {coor[0] = x;}
    public void setY(int y) {coor[1] = y;}
    public void setPrev(Node n) {
	prev = n;
    }

    public int getX() {return coor[0];}
    public int getY() {return coor[1];}
    public int[] getXY() {return coor;}
}
