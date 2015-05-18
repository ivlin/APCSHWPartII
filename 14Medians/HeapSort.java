import java.util.*;
public class HeapSort{

    public static void heapsort(int[] a){
	//	System.out.println(Arrays.toString(a));
	MyHeap h = new MyHeap(false);
	for (int i = 0; i < a.length; i++){
	    h.add(a[i]);
	}
	for (int i = 0; i < a.length; i++){
	    a[i] = h.remove();
	}
	//	System.out.println(Arrays.toString(a));
    }

    public static void main(String[]args){
	int[] a = {1,8,4,7,3,12,22,11,0};
	heapsort(a);
    }
}
