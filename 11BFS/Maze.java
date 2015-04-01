import java.io.*;
public class Maze{

    private int startx, starty;
    private char[][] maze;
    private MyDeque<Node> moves = new MyDeque<Node>();
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		ans += maze[r][c];
	    }
	    ans += "/n";
	}
	return ans;
    }

    public Maze(String filename){

    }

}
