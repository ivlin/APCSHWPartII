import java.util.*;
public class MyStack<T>{
    private ArrayList<T> stack;

    public MyStack(){
	stack = new ArrayList<T>();

    }

    public T push(T value){
	stack.add(value);
	return value;
    }

    public T peek(){
	return stack.get(stack.size() - 1);
    }

    public T pop(){
	return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty(){
	return stack.size() == 0;
    }

}
