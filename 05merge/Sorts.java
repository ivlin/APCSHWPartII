import java.util.Arrays;
public class Sorts{

    public static void mergesort(int[]a){
	mergesort(a, 0, a.length / 2);
    }

    public static void mergesort(int[]a, int min, int max){
	if (max - min > 1){
	    mergesort(a, min, min + max / 2);
	    mergesort(a, min + max / 2, max);
	}
	int[]first = new int[(max - min) / 2];
	for (int i = 0; i < first.length; i++){
first[i] = a[min + i]
	}
	int[]second = new int[max - min - first.length];
	for (int i = 0; i < second.length; i++){
second[i] = 
	}
	int[]newa = new int[max - min];
    }

    public static void mergehelp(int[]a, int[]b){
	if (a
    }

    public static void order(int[] array, int astart, int aend, int bstart, int bend){
	int temp;
	while (astart < bstart && bstart < bend){
	    System.out.println(Arrays.toString(array) + astart + " , " + aend + " , " + bstart);
	    if (array[astart] > array[bstart]){
		if (array[aend] != bstart - 1 && array[bstart] > array[aend + 1]){
		    temp = array[aend + 1];
		    array[aend + 1] = array[astart];
		    array[astart] = temp;
		}else{
		    temp = array[astart];
		    array[astart] = array[bstart];
		    array[bstart] = temp;
		    bstart++;
		}
	    }else{
		if (aend != bstart - 1){
		    temp = array[astart];
		    array[astart] = array[aend + 1];
		    array[aend + 1] = temp;
		    aend++;
		}
	    }
	    astart++;
	}
    }

    public static void main(String[]args){
	int[]a = {1,2,3,4,5,6,7,8,9};
	int[]b = {9,8,7,6,5,4,3,2,1};
	int[]c = {0,2,5,6,1,3,4,7};
	order(c, 0, c.length / 2 - 1, c.length / 2, c.length);
	System.out.println(Arrays.toString(c));
    }
}
