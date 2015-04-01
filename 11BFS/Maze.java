public class Maze{

    private class Node{
    }

    private MyDeque<Node> moves = new MyDeque<Node>();
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

}
