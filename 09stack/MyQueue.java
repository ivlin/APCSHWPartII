import java.util.*;
public class MyQueue<T>{
    LinkedList<T> queue;

    public String name(){
	return "lin.ivan";
    }

    public MyQueue(){
	queue = new LinkedList<T>();
    }

    public void enqueue(T n){
	queue.add(n);
    }

    public T dequeue(){
	return queue.remove(0);
    }
}