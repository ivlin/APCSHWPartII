import java.util.Random;
public class Driver{

    public static void main(String[]args){
	/*
	MyDeque<String> a = new MyDeque<String>();
	Random r = new Random(0);
	int q;
	if (args.length == 0){
	    for (int i = 0; i < 500; i++){
		q = r.nextInt(50);
		a.add("" + q, q);
	    }
	    System.out.println(a);
	    for (int i = 0; i < 490; i++){
		a.removeSmallest();
	    }
	    }*/
	
	Maze m = new Maze(args[0]);
	
	if (Integer.parseInt(args[1]) == 0){
	    m.solveDFS(args.length == 3);
	}else if (Integer.parseInt(args[1]) == 1){
	    m.solveBFS(args.length == 3);
	}else if (Integer.parseInt(args[1]) == 2){
	    m.solveBest(args.length == 3);
	}else if (Integer.parseInt(args[1]) == 3){
	    m.solveAStar(args.length == 3);
	}
	System.out.println(m);

	
    }

}
