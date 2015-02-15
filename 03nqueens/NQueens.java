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
	    current[i] = -9;
	}
	return solve(0, 1, 0);
    }

    public boolean solve(int row, int col, int qcount){
	cnt++;
	System.out.println(this);
	wait(50);
	System.out.println(cnt);
	if (row == board.length - 1){
	    return true;
	}	
	if (row < 0 || row >= board.length || col < 0 || col >= board.length){	
	    return false;
	}
	int temp;
	if (row < board.length - 1){
	    for (int i = 0; i < board.length; i++){
		temp = Character.getNumericValue(board[row][i]);
		if (temp >= 0 && col - 1 + temp >= 0 && col - 1 + temp < board.length){
		    board[row + 1][col - 1 + temp] = board[row][col];
		}
	    }
	}
	if (board[row][col] == '.'){	 
	    board[row][col] = 'Q';
	    if (col > 0){
		board[row + 1][col - 1] = '0';
	    }
	    if (col < board.length - 1){
		board[row + 1][col + 1] = '2';
	    }
	    board[row + 1][col] = '1';
	    if (solve(row + 1, 0, qcount + 1)){
		return true;
	    }
	    board[row][col] = '.';
	}
	return solve(row, col + 1, qcount);
    }
}
