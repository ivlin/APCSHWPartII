public class Recursion implements hw1{

    public String name(){
	return "Lin,Ivan";
    }

    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}else if (n <= 1){
	    return 1;
	}
	return n * fact(n - 1);
    }

    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
        return fibHelp(n, 0, 0, 0);
    }

    public int fibHelp(int n, int current, int lastSum, int sum){
	if (current <= n){
	    if (current == 1){
		return (fibHelp(n, current + 1, 1, sum + lastSum));
	    }
	    return fibHelp(n, current + 1, sum, sum + lastSum);
	}
	return sum + lastSum;
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelp(n, 1);
    }

    public double sqrtHelp(double n, double guess){
	if (n == 0){
	    return 0;
	}else if (guess * guess == n){
	    return guess;
	}else{
	    return sqrtHelp(n, (n / guess + guess) / 2);
	}
    }
}
