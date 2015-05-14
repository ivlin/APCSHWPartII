public class RunningMedian{
    
    public MyHeap first, last;

    public RunningMedian(){
	first = new MyHeap(true);
	last = new MyHeap(false);
    }

    public void add(int val){
	if (first.getSize() == last.getSize()){
	    first.add(val);
	}
	else if (last.getSize() == 0){
	    last.add(val);
	}
	else if (first.getSize() != last.getSize()){
	    last.add(first.remove());
	}
    }

    public double getMedian(){
	if (first.getSize() == last.getSize()){
	    return (double)(first.peek() + last.peek()) / 2.0; 
	}
	return (double)(first.peek());
    }

    public static void main(String[]args){
	RunningMedian m = new RunningMedian();
	for (int i = 0; i < 20; i++){
	    m.add((int)(Math.random() * 100));
	}
	System.out.println(m.first + " " + m.last);
	System.out.println(m.getMedian());
    }
}