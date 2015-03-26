import java.util.*;
public class MyDeque<T>{

    Object[]deque;
    int first, last;

    public MyDeque(){
	deque = new Object[10];
	first = 0;
	last = deque.length - 1;
    }

    public T getFirst(){
	if (first != (last + 1) % deque.length){
	    if (first > 0){
		return (T)deque[first - 1];
	    }else{
		return (T)deque[deque.length - 1];
	    }
	}
	return null;
    }

    public T getLast(){
	if (first != (last + 1) % deque.length){
	    return (T)deque[(last + 1) % deque.length];
	}
	return null;
    }

    public void addFirst(T value){
	add(first, value);
	first++;
    }

    public void addLast(T value){
	add(last, value);
	last--;
    }

    public void add(int ind, T value){
	if (ind < 0){
	    deque[deque.length - 1] = value;
	}else{
	    deque[ind % deque.length] = value;
	}
	if (first == last){
	    resize();
	}
    }

    public void resize(){
	Object[] temp = new Object[deque.length * 2];
	for (int i = 0; i < deque.length; i ++){
	    temp[i] = deque[(last + i) % deque.length];	
	}
	first = deque.length;
	deque = temp;
	last = deque.length;
    }

    public T removeFirst(){
	T removed = getFirst();
	first--;
	add(first, null);
	return removed;
    }

    public T removeLast(){
	    System.out.println(last);
	T removed = getLast();	
	last++;
	add(last, null);
	return removed;
    }

   public String toString(){
	String str = "[ ";
	for (int i = 0; i < deque.length; i++){
	    str += deque[i] + ",";
	}
	return str + " ]";
    }

}
