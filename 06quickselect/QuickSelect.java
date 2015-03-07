import java.util.Arrays;
public class QuickSelect{

    public static void oldPartition(int[]ary, int si, int ei){
	int[]d = new int[ary.length];
	int pivot = si;
        for (int i = 0; i < si; i++){
	    d[i] = ary[i];
	}
	for (int i = ei + 1; i < ary.length; i++){
	    d[i] = ary[i];
	}
	for (int i = si; si != ei; i++){
	    if (i != pivot){
		if (ary[i] < ary[pivot]){
		    d[si] = ary[i];
		    si ++;
		}else{
		    d[ei] = ary[i];
		    ei --;
		}
	    }
	}
	d[si] = ary[pivot];
	ary = d;
    }

    public static int quickSelect(int[]ary, int n){
	int pivot;
	int max = ary.length - 1;
	int min = 0;
	do{
	    pivot = partition(ary, min, max);
	    System.out.println(pivot);
	    System.out.println(Arrays.toString(ary));
	    if (pivot > n){
		max = pivot;
	    }else{
		min = pivot;
	    }
	} while (pivot != n);
	return ary[pivot];
    }

    public static int partition(int[]ary, int si, int ei){
	int ri = ary[si + (int)(Math.random() * (ei - si))];
	int trace = si;
	int temp;
	while (si != ei){
	    if (ary[trace] > ri){
		temp = ary[ei];
		ary[ei] = ary[trace];
		ary[si] = temp;
		ei--;
	    }
	    if (ary[trace] < ri){
		si ++;
		trace ++;
	    }
	    if (ary[trace] == ri){
		trace++;
	    }
	}
	ary[si] = ri;
	return si;
    }

    public static void main(String[]args){
	int[]ar = new int[10];
	for (int i = 0; i < ar.length; i++){
	    ar[i] = i;
	}
	int temp;
	int newi;
	for (int i = 0; i < ar.length; i++){
	    newi = (int)(Math.random() * ar.length);
	    temp = ar[newi];
	    ar[newi] = ar[i];
	    ar[i] = temp; 
	}
	System.out.println(Arrays.toString(ar));
        System.out.println(quickSelect(ar, Integer.parseInt(args[0])));
	System.out.println(Arrays.toString(ar));
    }
}
