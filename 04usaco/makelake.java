import java.util.*;
import java.io.*;
public class makelake{

    File f;
    Scanner sc;
    int el, dir;
    int[][]lake;

    public makelake() throws Exception{
	f = new File("makelake.in");
	sc = new Scanner(f);
	lake = new int[Integer.parseInt(sc.next())][Integer.parseInt(sc.next())];
	el = Integer.parseInt(sc.next());
	dir = Integer.parseInt(sc.next());
	for (int r = 0; r < lake.length; r++){
	    for (int c = 0; c < lake[0].length; c++){
		lake[r][c] = Integer.parseInt(sc.next());
	    }
	}
	while (sc.hasNext()){
	    stomp(Integer.parseInt(sc.next()) - 1, Integer.parseInt(sc.next()) - 1, Integer.parseInt(sc.next()));
	    for (int i = 0; i < lake.length; i++){
		System.out.println(Arrays.toString(lake[i]));
	    }
	    System.out.println();
	}
	setDepth();
	    for (int i = 0; i < lake.length; i++){
		System.out.println(Arrays.toString(lake[i]));
	    }
	    System.out.println();
    }

    public void stomp(int row, int col, int newE){
	int max = lake[row][col];
	for (int r = 0; r < 3 && row + r < lake.length; r ++){
	    for (int c = 0; c < 3 && col + c < lake[0].length; c ++){
		if (lake[row + r][col + c] > max){
		    max = lake[row + r][col + c];
		}
	    }
	}
	max -= newE;
	for (int r = 0; r < 3 && row + r < lake.length; r ++){
	    for (int c = 0; c < 3 && col + c < lake[0].length; c ++){
		if (lake[row + r][col + c] > max){
		    lake[row + r][col + c] = max;
		}
	    }
	}
    }

    public void setDepth(){
	for (int r = 0; r < lake.length; r ++){
	    for (int c = 0; c < lake[0].length; c++){
		if (lake[r][c] < el){
		    lake[r][c] = el - lake[r][c];
		}else{
		    lake[r][c] = 0;
		}
	    }
	}
    }

    public int getVol(){
	int v = 0;
	for (int r = 0; r < lake.length; r++){
	    for (int c = 0; c < lake[0].length; c++){
		if (lake[r][c] < el){
		    v += lake[r][c] * 72 * 72;
		}
	    }
	}
	return v;
    }

    public static void main(String[]args) throws Exception{
	makelake l = new makelake();
	PrintWriter write = new PrintWriter("makelake.out");
	System.out.println(l.getVol());
	write.println(l.getVol());
	write.close();
    }

}
