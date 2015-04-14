import java.util.*;
public class MyDeque<T>{

    Object[]deque;
    int[]priorities;
    int first, last;
    //[first -- > [][][][] < --last]

    public MyDeque(){
	deque = new Object[10];
	priorities = new int[deque.length];
	first = 0;
	last = deque.length - 1;
    }

    public T getFirst(){
	if (first != (last + 1) % deque.length){
	    if (first > 0){
		return (T)deque[(first - 1) % deque.length];
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
	if (first == last){
	    resize(2 * deque.length);
	}
    }

    public void addLast(T value){
	add(last, value);
	last--;	
	if (first == last){
	    resize(2 * deque.length);
	}
    }

    public void add(int ind, T value){
	if (ind < 0){
	    deque[deque.length - 1] = value;
	}else{
	    deque[ind % deque.length] = value;
	}
    }

    //priorityadd
    public void add(T value, int priority){
	deque.addLast(value);
	priorities[(last + 1) % deque.size] = priority;
    }

    public void resize(int newLength){
	Object[] temp = new Object[newLength];
	int cnt = 0;
	do {
	    temp[cnt] = deque[(last + 1 + cnt) % deque.length];
	    cnt ++;
	}
	while((last + cnt) % deque.length != first % deque.length);
	first = cnt - 1;
	deque = temp;
	last = deque.length - 1;
    }

    public T removeFirst(){
	T removed = getFirst();
	first --;
	add(first, null);
	if (deque.length > 10 && Math.abs(first - last) >= 3 * deque.length / 4){
	    resize(deque.length / 2);
	}
	return removed;
    }

    public T removeLast(){
	T removed = getLast();	
	last++;
	add(last, null);
	if (deque.length > 10 && Math.abs(first - last) >= 3 * deque.length / 4){
	    resize(deque.length / 2);
	}	
	return removed;
    }

    public T removeSmallest(){
	int smallestInd;
	smallestInd = priorities[(tail + 1) % deque.size];
	for (int i = (tail + 1) % deque.size; i != head; i++){
	    if (priorities[smallestInd] > priorities[i]){
		smallestInd = i;
	    }
	}
	
    }

   public String toString(){
	String str = "[ ";
	for (int i = 0; i < deque.length; i++){
	    str += deque[i] + ",";
	}
	return str + " ]";
    }
}
