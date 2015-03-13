public class MyLinkedList{

    private LNode first;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    public int size(){
	return size;
    }

    public int indexOf(int val){
	LNode current = first;
	int ind = 0;
	while (current.getNext() != null){
	    if (current.getData() == val){
		return ind;
	    }else{
		current = current.getNext();
	    }
	}
	return -1;
    }

    public int get(int ind){
	LNode current = first;
	for (int i = 0; i < ind; i++){
	    current = current.getNext();
	}
	return current.getData();
    }

    public boolean add(int val){
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
	return true;
    }

    public boolean add(int ind, int val){
	LNode current = first;
	for (int i = 0; i < ind - 1; i++){
	    current = current.getNext();
	}
	current.setNext(new LNode(val, current.getNext()));
	return true;
    }

    public int set(int ind, int val){
	LNode current = first;
	for (int i = 0; i < ind; i++){
	    current = current.getNext();
	}
	int data = current.getData();
	current.setData(val);
	return data;
    }

    public int remove(int ind){
	LNode current = first;
	for (int i = 0; i < ind - 1; i++){
	    current = current.getNext();
	}
	int temp = current.getNext().getData();
	current.setNext(current.getNext().getNext());
	return temp;    
    }

    public String toString(){
	String str = "[";
	LNode current = first;
	while (current != null){
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
	l.remove(2);
	l.set(1,15);
	System.out.println(l);
    }
}
