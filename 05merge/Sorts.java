import java.util.Arrays;
public class Sorts{

    public static void mergesort(int[]a){
	mergesort(a, 0, a.length);
    }

    public static void mergesort(int[]a, int min, int max){
	if (max - min > 1){
	    mergesort(a, min, min + (max - min) / 2);
	    mergesort(a, min + (max - min) / 2, max);
	    order(a, min, min + (max - min) / 2, max);
	}
    }

    public static void order(int[]a, int min, int med, int max){
	int first = min;
	int second = med;
	int[]temp = new int[max - min];
	for (int i = 0; i < temp.length; i++){
	    //	    System.out.println(Arrays.toString(temp) + " . " + a[first] + a[second]);
	    if (first >= med){
		temp[i] = a[second];
		second++;
	    }else if (second >= max){
		temp[i] = a[first];
		first++;
	    }else{
		if (a[first] > a[second]){
		    temp[i] = a[second];
		    second++;
		}else{
		    temp[i] = a[first];
		    first++;
		}
	    }
	}
	for (int i = 0; i < temp.length; i++){
	    a[min + i] = temp[i];
	}
    }
				
}
