import java.util.*;
public class Sorts{

    public String name(){
	return "lin.ivan";
    }

    public static int quickSelect(int[]ary, int n){
	int pivot;
	int max = ary.length - 1;
	int min = 0;
	do{
	    pivot = partition(ary, min, max);
	     if (pivot > n){
		max = pivot;
	    }else{
		min = pivot;
	    }
	} while (pivot != n);
	return ary[pivot];
    }

    public static void quickSort(int[]ary){
	quickSort(ary, 0, ary.length - 1);
    }

    public static void quickSort(int[]ary, int si, int ei){
	if (ei - si > 1){
	    int n = partition(ary, si, ei);
	    quickSort(ary, si, n - 1);
	    
	    quickSort(ary, n + 1, ei);
	}
    }

    public static int partition(int[]ary, int si, int ei){
	int oldS = ary[si];
	int temp = si + (int)(Math.random() * (ei - si + 1));
	ary[si] = ary[temp];
	ary[temp] = oldS;
	oldS = si;
	si++;
	int mids = si;
	while (si <= ei){
	    if (ary[si] > ary[oldS]){
		temp = ary[ei];
		ary[ei] = ary[si];
		ary[si] = temp;
		ei--;
	    }else if (ary[si] < ary[oldS]){
		if (mids != si){
		    ary[mids] = ary[si];
		    ary[si] = ary[oldS];
		}
		mids ++;
		si ++;  	
	    }else{
		si ++;
	    }
	}
	si = mids - 1;
	temp = ary[oldS];
	ary[oldS] = ary[si];
	ary[si] = temp;
	return si;
    }
}
