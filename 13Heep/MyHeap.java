public class MyHeap{

    private int[] heap;
    private int size, lvl;
    private boolean isMax;

    public String name(){
	return "lin ivan";
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
	    return ch < pa;
	}
    }

    public void add(int val){
	heap[size + 1] == val;
	int last = size + 1;
	int cur = last / 2;
	while (isParent(val, heap[cur]) && cur != 0){
	    
	    last = heap[cur];
	    cur = last / 2;
	}
	size++;
	if (size == heap.length){
	    heap = resize(heap, 2 * heap.length);
	}
    }

    private void resize(int[] ar, int newLength){
	int[]temp = new int[newLength];
	for (int i = 0; i < ar.length; i++){
	    temp[i] = ar[i];
	}
	return temp;
    }

    public String toString();

}