public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private char[][]board;

    private void clearTerminal(){
	System.out.println("clear");
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
	int [] col = new int[board.length];
	for (int c = 0; c < col.length; c++){
	    col[c] = -1;
	}
	solve(0, 0, 0, col);			
    }

    public boolean solve(int x, int y, int qcount, int[]col){
	System.out.println(this);
wait(10);
	if (qcount == board.length + 1){
	    return true;
	}
	if (x < 0 || x >= board.length || y < 0 || y >= board.length){
	    return false;
	}
      	for (int i = 0; i < col.length; i++){
	    if (y - x == col[i] - i || y + board.length - x == col[i] + col.length - i){
		return false;
	    }
	}

    }
}