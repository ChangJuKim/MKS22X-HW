public class RunningMedian extends MyHeap {
    boolean isEven;

    public RunningMedian() {
	super();
    }

    public double getMedian() {
        if (size == 0) {
	    throw new NoSuchElementException();
	}
	if (size % 2 == 1) {
	    return (double)data[1];
	} else {
	    return (data[2] + data[3]) / 2.0;
	}
    }

    public void add(Integer x) {
	if (size % 2 == 1) {
	    if (
	}
    }
}
