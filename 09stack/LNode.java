public class LNode<T>{

    private T data;
    private LNode<T> next;

    public LNode(T newData){
	this(newData, null);
    }

    public LNode(T newData, LNode<T> newNext){
	setData(newData);
	setNext(newNext);
    }

    public void setData(T newData){
	data = newData;
    }

    public T getData(){
	return data;
    }

    public void setNext(LNode<T> newNext){
	next = newNext;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return "" + data;
    }
}
