public class Node{

    private int x,y,dist;
    private Node last;

    public Node(int xi, int yi, int distance, Node lastN){
	x = xi;
	y = yi;
	dist = distance;
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

    public int getDistance(){
	return dist;
    }

}
