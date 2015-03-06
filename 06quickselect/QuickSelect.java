import java.util.Arrays;
public class QuickSelect{

    public static void partition(int[]ary, int si, int ei){
	int[]d = new int[ary.length];
	int pivot = si;
	int cnt = 0;
        for (int i = 0; i < si; i++){
	    d[i] = ary[i];
	    cnt ++;
	}
	for (int i = ei + 1; i < ary.length; i++){
	    d[i] = ary[i];
	    cnt ++;
	}
	System.out.println(cnt);
	System.out.println(si + " " + ei);
	for (int i = si; si != ei; i++){
	    if (i != pivot){
		if (ary[i] < ary[pivot]){
		    d[si] = ary[i];
		    si ++;
		}else{
		    d[ei] = ary[i];
		    ei --;
		}
	    }else{
		System.out.println("A");
	    }
	    cnt ++;
	}
	System.out.println(cnt);
	System.out.println("SI at index " + si + " or "+ ary[pivot]);
	d[si] = ary[pivot];
	ary = d;
	System.out.println(Arrays.toString(d));
    }

    public static void main(String[]args){
	int[]ar = new int[50];
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
	partition(ar, 0, ar.length - 1);
    }
}
