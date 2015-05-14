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

    public int getSize(){
	return size;
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
	String str = "";
	for (int i = 0; i < size; i++){
	    str += heap[i] + ", ";
	}
	return str.substring(0,str.length() - 2);
    }

    public int remove(){
	int root = heap[0];
	int cur = 0;
	int hold = heap[cur];
	while ((cur + 1) * 2 < size){
	    if (isParent(heap[(cur + 1) * 2], heap[(cur + 1) * 2 - 1])){
		hold = (cur + 1) * 2;
		heap[cur] = heap[hold];
		cur = hold;
	    }else{
		hold = (cur + 1) * 2 - 1;
		heap[cur] = heap[hold];
		cur = hold;
	    }
	}
	size --;
	heap[cur] = heap[size];
	return root;
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap(true);
	for (int i = 1; i < 6; i++){
	    h.add(i);
	    System.out.println(h);
	}
	h.add(10);
	h.add(2);
	h.add(5);
	h.add(11);
	System.out.println(h);
	h.remove();
	//	h.remove();
	//	h.remove();
	System.out.println(h);

    }

}
