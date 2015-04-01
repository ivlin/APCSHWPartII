public class LNode{

    private int x,y;
    private LNode last;

    public LNode(int xi, int yi, LNode lastN){
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

    public LNode getLast(){
	return last;
    }
}
