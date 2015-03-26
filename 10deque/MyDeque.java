public class MyDeque<T>{

    Object[]deque;
    int first, last;

    public MyDeque(){
	deque = new Object[10];
	first = 0;
	last = deque.length - 1;
    }

    public T getFirst(){
	if (first > 0){
	    return (T)deque[first - 1];  
	}
	return null;
    }

    public T getLast(){
	return (T)deque[(last + 1) % deque.length];
    }


    public void addFirst(T value){
	deque[first] = value;
	first++;
    }

    public void addLast(T value){
	deque[last] = value;
	last--;
    }

   public String toString(){
	String str = "";
	for (int i = 0; i < deque.length; i++){
	    str += deque[i];
	}
	return str;
    }

    public static void main(String[]args){
	MyDeque<Integer> m = new MyDeque<Integer>();
	m.addFirst(2);
	m.addFirst(4);
	m.addLast(3);
	m.addLast(5);
	System.out.println(m);
    }


}
