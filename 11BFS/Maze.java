import java.io.*;
import java.util.*;
public class Maze{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private Frontier front;

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
	return "";//("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		ans += maze[r][c];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public String toStringAnimated(){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(32,40)+c;
	    }
	}
	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }
    

    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }

    public boolean solveDFS(){
	front = new Frontier(true);
	front.add(startx, starty, null);
	Node current;
	int cnt = 0;
	while (front.hasNext()){
	    wait(30);
	    clearTerminal();
	    System.out.println(this.toStringAnimated());
	    current = front.next();	    
	    if (maze[current.getx()][current.gety()] == 'E'){
		return true;
	    }
	    if (maze[current.getx()][current.gety()] == ' ' ||
		maze[current.getx()][current.gety()] == 'S'){
		front.add(current.getx() + 1, current.gety(), current);
		front.add(current.getx() - 1, current.gety(), current);
		front.add(current.getx(), current.gety() + 1, current);
		front.add(current.getx(), current.gety() - 1, current);
		maze[current.getx()][current.gety()] = '.';
	    }	
	}
	return false;
    }

    public boolean solveBFS(){
	front = new Frontier(false);
	front.add(startx, starty, null);
	Node current;
	int cnt = 0;
	while (front.hasNext()){
	    wait(30);
	    clearTerminal();
	    System.out.println(this.toStringAnimated());
	    current = front.next();	    
	    if (maze[current.getx()][current.gety()] == 'E'){
		return true;
	    }
	    if (maze[current.getx()][current.gety()] == ' ' ||
		maze[current.getx()][current.gety()] == 'S'){
		front.add(current.getx() + 1, current.gety(), current);
		front.add(current.getx() - 1, current.gety(), current);
		front.add(current.getx(), current.gety() + 1, current);
		front.add(current.getx(), current.gety() - 1, current);
		maze[current.getx()][current.gety()] = '.';
	    }	
	}
	return false;
    }

    public static void main(String[]args){
	Maze m = new Maze(args[0]);
	System.out.println(m.solveBFS());
    }

    private class Frontier{
	MyDeque<Node> moves;
	boolean DFS;

	public Frontier(boolean setDFS){
	    moves = new MyDeque<Node>();
	    DFS = setDFS;
	}

	public boolean hasNext(){
	    return moves.getFirst() != null;
	}

	public Node next(){
	    return moves.removeLast();
	}

	public void add(int x, int y, Node last){
	    if (DFS){
		moves.addLast(new Node(x, y, last));
	    }else{
		moves.addFirst(new Node(x, y, last));
	    }
	}
    }
}
