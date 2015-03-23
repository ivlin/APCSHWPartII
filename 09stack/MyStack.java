import java.util.*;
public class MyStack<T>{
    private LinkedList<T> stack;

    public MyStack(){
        stack = new LinkedList<T>();
    }

    public String name(){
	return "lin.ivan";
    }

    public T push(T value){
	stack.add(0, value);
	return value;
    }

    public T peek(){
	return stack.get(0);
    }

    public T pop(){
	return stack.remove(0);
    }

    public boolean isEmpty(){
	return stack.size() == 0;
    }

}
