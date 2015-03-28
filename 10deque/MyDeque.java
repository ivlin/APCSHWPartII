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
	if (first == last){
	    resize(2 * deque.length);
	}
	first++;
    }

    public void addLast(T value){
	add(last, value);
	if (first == last){
	    resize(2 * deque.length);
	}	
	last--;
    }

    public void add(int ind, T value){
	if (ind < 0){
	    deque[deque.length - 1] = value;
	}else{
	    deque[ind % deque.length] = value;
	}
    }

    public void resize(int newLength){
	System.out.println(this + " last" + deque[last % deque.length] + " first:" + deque[first]);
	Object[] temp = new Object[newLength];
	int cnt = 0;
	do {
	    temp[cnt] = deque[(last + cnt) % deque.length];
	    cnt ++;	
	}while((last + cnt) % deque.length != first);
	first = cnt - 1;
	deque = temp;
	last = deque.length;
	System.out.println(this + " last:" + deque[last % deque.length] + " first:" + deque[first]);
    }

    public T removeFirst(){
	T removed = getFirst();
	first--;
	add(first, null);
	
	if (deque.length > 10 && Math.abs(first - last) >= 3 * deque.length / 4){
	    first --;
	    resize(deque.length / 2);
	}
	return removed;
    }

    public T removeLast(){
	T removed = getLast();	
	last++;
	add(last, null);
	if (deque.length > 10 && Math.abs(first - last) >= 3 * deque.length / 4){
	    last++;
	    resize(deque.length / 2);
	}	
	return removed;
    }

   public String toString(){
	String str = "[ ";
	for (int i = 0; i < deque.length; i++){
	    str += deque[i] + ",";
	}
	return str + " ] last: " + last + " first:" + first;
    }

   public static void main(String[]args){
       MyDeque<Integer> m = new MyDeque<Integer>();
       for (int i = 0; i < 10; i++){
	   m.addFirst(i);
	   m.addLast(-i);
	   //	   System.out.println(m);
       }
       System.out.println(m);
       for (int i = 0; i < 15; i++){
	   m.removeLast(); 
       }
       System.out.println(m + " " + m.last + m.first); 
       for (int i = 0; i < 50; i++){
	   m.addFirst(1);
	   m.addLast(2);
       }  
       System.out.println(m);
}

}
