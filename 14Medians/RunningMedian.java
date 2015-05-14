public class RunningMedian{
    
    private MyHeap first, last;

    public RunningMedian(){
	first = new MyHeap(true);
	last = new MyHeap(false);
    }

    public void add(int val){
	if (first.getSize() == last.getSize()){
	    first.add(val);
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
}