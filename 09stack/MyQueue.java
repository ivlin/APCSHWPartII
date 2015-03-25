import java.util.*;
public class MyQueue<T>{
    MyLinkedList<T> queue;

    public String name(){
	return "lin.ivan";
    }

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public boolean enqueue(T n){
	queue.add(n);
	return true;
    }

    public T dequeue(){
	return queue.remove(0);
    }
}
