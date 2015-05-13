import java.util.Random;
public class MyHeap{

    private int[] heap;
    private int size, lvl;
    private boolean isMax;

    public String name(){
	return "lin ivan";
    }

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean max){
	heap = new int[10];
	isMax = max;
	size = 0;
    }

    private boolean isParent(int pa, int ch){
	if (isMax){
	    return pa > ch;
	}else{
	    return pa < ch;
	}
    }

    public void add(int val){
	heap[size] = val;
	int last = size;
	int cur = (last - 1) / 2;
	while (isParent(val, heap[cur]) && cur >= 0){
	    heap[last] = heap[cur];
	    heap[cur] = val;
	    last = cur;
	    cur = last / 2;
	}
	size++;
	if (size == heap.length){
	    heap = resize(heap, 2 * heap.length);
	}
    }

    private int[] resize(int[] ar, int newLength){
	int[]temp = new int[newLength];
	for (int i = 0; i < ar.length; i++){
	    temp[i] = ar[i];
	}
	return temp;
    }

    public int peek(){
	return heap[0];
    }

    public String toString(){
	String str = "[ ";
	for (int i = 0; i < size; i++){
	    str += heap[i] + ", ";
	}
	return str + "]";
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap(true);
	for (int i = 0; i < 5; i++){
	    h.add(i);
	    System.out.println(h);
	}
	h.add(10);
	h.add(2);
	h.add(5);
	h.add(11);
	System.out.println(h);
    }

}
