public class Driver{

    public static void main(String[]args){
	Maze m = new Maze(args[0]);
	if (args[1] == 0){
	    m.solveDFS(args.length == 3);
	}else if (args[1] == 1){
	    m.solveBFS(args.length == 3);
	}else if (args[1] == 2){
	    m.solveBest(args.length == 3);
	}else if (args[1] == 3){
	    m.solveAStar(args.length == 3);
	}
    }

}