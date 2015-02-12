public class Driver{
    public static void main(String[]args){
	KnightsTour f = new KnightsTour(Integer.parseInt(args[0]));
	f.clear();
	if (f.solve()){
	    System.out.println(f);
	}else{
	    System.out.println("No luck");
	}
    }   
}
