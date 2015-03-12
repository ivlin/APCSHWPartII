public class MyLinkedList{

    private LNode first;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    public void add(int val){
	if (size == 0){
	    first = new LNode(val);
	}else{
	    LNode current = first;
	    while (current.getNext() != null){
		current = current.getNext();
	    }
	    current.setNext(new LNode(val));
	}
	size++;
    }

    public String toString(){
	String str = "[";
	LNode current = first;
	while (current.getNext() != null){
	    str += current.getData() + ",";
	    current = current.getNext();
	}
	return str.substring(0, str.length() - 1) + "]";
    }

    public static void main (String[]args){
	MyLinkedList l = new MyLinkedList();
	l.add(1);
	l.add(4);
	l.add(7);
	l.add(11);
	System.out.println(l);
    }
}