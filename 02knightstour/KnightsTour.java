import java.util.*;
import java.io.*;

public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    public String name(){
	return "Lin,Ivan";
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

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	for (int i = 0; i < board.length; i++){
	    for (int n = 0; n < board.length; n++){
		if (board[i][n] < 10){
		    ans += " ";
		}
		ans += board[i][n] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	for (int i = 0; i < size; i++){
	    for (int n = 0; n < size; n++){
		board[i][n] = -1;
	    }
	}			
    }
    
    
    public boolean solve(){
	return solve(0,0);				
    }

    public boolean solve(int startx, int starty){
	return solve(startx,starty,0);		
    }
       
    public boolean solve(int x,int y,int currentMoveNumber){
	if (currentMoveNumber == board.length * board.length){
	    return true;
	}	
      	if (x < 0 || x >= board.length || y < 0 || y >=	board.length){
	    return false;
	}
	if (board[x][y] == -1){
	    board[x][y] = currentMoveNumber;	
	    if (solve(x + 2, y + 1, currentMoveNumber + 1) || solve(x + 2, y - 1, currentMoveNumber + 1) ||
		solve(x - 2, y + 1, currentMoveNumber + 1) || solve(x - 2, y - 1, currentMoveNumber + 1) ||
		solve(x + 1, y + 2, currentMoveNumber + 1) || solve(x + 1, y - 2, currentMoveNumber + 1) ||
		solve(x - 1, y + 2, currentMoveNumber + 1) || solve(x - 1, y - 2, currentMoveNumber + 1)){
		return true;
	    }
	    board[x][y] = -1;
	}
	return false;
    }
}
