public class LNode{

    private int data;
    private LNode next;

    public LNode(int newData){
	this(newData, null);
    }

    public LNode(int newData, LNode newNext){
	setData(newData);
	setNext(newNext);	
    }

    public void setData(int newData){
	data = newData;
    }

    public int getData(){
	return data;
    }

    public void setNext(LNode newNext){
	next = newNext;
    }

    public LNode getNext(){
	return next;
    }

    public String toString(){
	return "" + data;
    }
}
