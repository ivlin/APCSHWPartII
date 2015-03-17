public class MyLinkedList<T>{

    private LNode<T> first, last, current;
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

    public int indexOf(T val){
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

    public T get(int ind) throws IndexOutOfBoundsException{
	if (ind >= size() || ind < 0){
	    throw new IndexOutOfBoundsException();
	}
	current = first;
	for (int i = 0; i < ind; i++){
	    current = current.getNext();
	}
	return current.getData();
    }

    public boolean add(T val) throws IndexOutOfBoundsException{
	return add(size(), val);
    }

    public boolean add(int ind, T val) throws IndexOutOfBoundsException{
	if (ind > size() || ind < 0){
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0){
	    first = last = new LNode<T>(val);
	}else if (ind == size()){
	    last.setNext(new LNode<T>(val));
	    last = last.getNext();
	}else{
	    current = first;
	    for (int i = 0; i < ind - 1; i++){
		current = current.getNext();
	    }
	    current.setNext(new LNode<T>(val, current.getNext()));
	}	
	size++;
	return true;
    }

    public T set(int ind, T val) throws IndexOutOfBoundsException{
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
	if (size == 0){
	    first = null;
	}
	for (int i = 0; i < ind - 1; i++){
	    current = current.getNext();
	}
	//int temp = current.getNext().getData();
	if (ind < size - 1){
	    current.setNext(current.getNext().getNext());
	}else{
	    last = current;
	    current.setNext(null);
	}
	size--;
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

    public boolean isEmpty(){
	return size == 0;
    }
}
