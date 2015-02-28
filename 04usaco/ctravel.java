import java.util.*;
import java.io.*;
public class ctravel{
    File file;
    Scanner sc;
    String[][]pasture;
    int time, startx, starty, endx, endy;

    public ctravel() throws Exception{
	file = new File("ctravel.txt");
	sc = new Scanner(file);
	pasture = new String[Integer.parseInt(sc.next())][Integer.parseInt(sc.next())];
	time = Integer.parseInt(sc.next()); 
	for (int i = 0; i < pasture.length; i++){
	    String l = sc.next();
	    for (int x = 0; x < pasture[0].length; x++){
		pasture[i][x] = l.substring(x, x + 1);
	    }
	}
	startx = Integer.parseInt(sc.next()) - 1;
	starty = Integer.parseInt(sc.next()) - 1;
	endx = Integer.parseInt(sc.next()) - 1;
	endy = Integer.parseInt(sc.next()) - 1;
   }

    public int solve(){
	return solve(startx, starty, 0);
    }

public int solve(int x, int y, int t){
    if (x < 0 || x >= pasture[0].length || y < 0 || y >= pasture.length || pasture[x][y] == "*" || t >= time){
	return 0;
    }
    if (x == endx && y == endy){
	return 1;
    }
    return  solve(x + 1, y, t + 1) + solve(x - 1, y, t + 1) + solve(x, y + 1, t + 1) + solve(x, y - 1, t + 1);
}

    public static void main(String[]args) throws Exception{
	ctravel x = new ctravel();
	System.out.println(x.solve());
    }
    
}
