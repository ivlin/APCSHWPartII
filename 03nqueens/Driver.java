import java.io.*;
public class Driver{

    public static void main(String[]args){
	NQueens n = new NQueens(Integer.parseInt(args[0]));

	n.solve(6);
	System.out.println(n);
    }

}
