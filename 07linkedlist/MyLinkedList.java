public class MyLinkedList<T>{

    private LNode first, last, current;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

    public String name(){
	return "lin, ivan";
    }

    public int size(){
	return size;
    }

    public int indexOf(int val){
	current = first;
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

    public int get(int ind) throws IndexOutOfBoundsException{
	if (ind >= size() || ind < 0){
	    throw new IndexOutOfBoundsException();
	}
	current = first;
	for (int i = 0; i < ind; i++){
	    current = current.getNext();
	}
	return current.getData();
    }

    public boolean add(int val) throws IndexOutOfBoundsException{
	return add(size(), val);
    }

    public boolean add(int ind, int val) throws IndexOutOfBoundsException{
	if (ind > size() || ind < 0){
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0){
	    first = last = new LNode(val);
	}else if (ind == size){
	    last.setNext(new LNode(val));
	}else{
	    current = first;
	    for (int i = 0; i < ind - 1; i++){
		current = current.getNext();
	    }
	    current.setNext(new LNode(val, current.getNext()));
	}	
	size++;
	return true;
    }

    public T set(int ind, int val) throws IndexOutOfBoundsException{
	if (ind >= size() || ind < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(ind == size){
	    last.setData(val);
	}
	current = first;
	for (int i = 0; i < ind; i++){
	    current = current.getNext();
	}
	T data = current.getData();
	current.setData(val);
	return data;
    }

    public boolean remove(int ind) throws IndexOutOfBoundsException{
	if (ind >= size() || ind < 0){
	    throw new IndexOutOfBoundsException();
	}
	current = first;
	if (ind == 0){
	    first = first.getNext();
	}
	for (int i = 0; i < ind - 1; i++){
	    current = current.getNext();
	}
	//int temp = current.getNext().getData();
	current.setNext(current.getNext().getNext());
	return true;    
    }

    public String toString(){
	String str = "[";
	current = first;
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
	l.remove(20);
	l.set(1,15);
	System.out.println(l);
    }
}
