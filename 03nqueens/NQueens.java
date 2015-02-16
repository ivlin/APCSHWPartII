import java.util.Arrays;
import java.io.*;
public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    int cnt = 0;
    //instance variable
    private char[][]board;


    private void clearTerminal(){
	System.out.println(clear);
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public NQueens(int n){
	board = new char[n][n];
	for (int i = 0; i < n; i++){
	    for (int t = 0; t < n; t++){
		board[i][t] = '.';
	    }
	}
    }

    public String toString(){
	String ans = "\n";
	for (int i = 0; i < board.length; i++){
	    for (int n = 0; n < board.length; n++){
		ans += board[i][n];
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }
    
    public boolean solve(){
	int[]current = new int[board.length];
	for (int i = 0; i < current.length; i++){
	    current[i] = -1;
	}
	return solve(0, 0, 0, current);
    }

    public boolean solve(int row, int col, int qcount, int[] current){
	if (qcount == board.length){
	    return true;
	}	
	if (row < 0 || row >= board.length || col < 0 || col >= board.length){	
	    return false;
	}
	board[row][col] = 'Q';
	current[row] = col;
	for (int i = 0; i < row; i++){
	    if (col == current[i] || (float)(col - current[i]) / (row - i) == 1 || (float)(col - current[i]) / (row - i) == -1){
		board[row][col] = '.';
		return solve(row, col + 1, qcount, current);
	    }
	}
	if (solve(row + 1, 0, qcount + 1, current)){
	    return true;
	}
	board[row][col] = '.';
	return solve(row, col + 1, qcount, current);
   }
}
