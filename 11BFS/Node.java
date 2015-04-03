public class Node{

    private int x,y;
    private Node last;

    public Node(int xi, int yi, Node lastN){
	x = xi;
	y = yi;
	last = lastN;
    }

    public int getx(){
	return x;
    }

    public int gety(){
	return y;
    }

    public Node getLast(){
	return last;
    }

}
