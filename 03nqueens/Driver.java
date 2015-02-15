import java.io.*;
public class Driver{

    public static void main(String[]args){
	NQueens n = new NQueens(Integer.parseInt(args[0]));

	if (n.solve()){
	    System.out.println(n);
	}else{
	    System.out.println("NOPE");
	}
    }

}
