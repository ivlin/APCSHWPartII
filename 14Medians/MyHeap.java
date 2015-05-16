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
	int lvls = (int)(Math.log(size + 1) / Math.log(2)) + 1;
	int width = (int)Math.pow(2, lvls) - 1;
	String str = "";
	int ind = 0;
	for (int i = 0; i < lvls; i++){
	    for (int x = 0; x < Math.pow(2, i); x++){
		str += getLevel(ind, width) + " ";
		ind ++;
	    }
	    str += "\n";
	    width = (width - 1) / 2;
	}
	return str;
    }

    public String getLevel(int ind, int width){
	String str = "";
	for (int i = 0; i < width; i++){
	    if (ind < size){
		if (i == width / 2){
		    str += heap[ind];
		}else{
		    str += " ";
		}
	    }
	}
	return str;
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

    public int getSize(){
	return size;
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap(true);
	for (int i = 0; i < 9; i++){
	    h.add(i);
	}
	System.out.println(h);
    }
}
