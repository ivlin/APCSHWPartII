import java.util.*;
public class MyStack<T>{
    //    private ArrayList<T> al;
    private LinkedList<T> ll;

    public MyStack(){
	// al = new ArrayList<T>();
	ll = new LinkedList<T>();
    }

    public T push(T value){
	//al.add(value);
	ll.add(0, value);
	return value;
    }

    public T peek(){
        //return al.get(al.size() - 1);
	return ll.get(0);
    }

    public T pop(){
	//return al.remove(al.size() - 1);
	return ll.remove(0);
    }

    public boolean isEmpty(){
    //	return al.size() == 0;
	return ll.size() == 0;
    }

}
