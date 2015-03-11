public class LNode{

    private Object data;
    private LNode next;

    public LNode(Object newData, LNode newNext){
	setData(newData);
	setNext(newNext);	
    }

    public void setData(Object newData){
	data = newData;
    }

    public void setNext(LNode newNext){
	next = newNext;
    }
}
