import java.util.Iterator;

public class Main{
    
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int peek;
    boolean hasNext ;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        hasNext=false;
        if(iterator.hasNext()) {
            hasNext = true;
            peek = iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return hasNext ? peek:null;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasNext()){
            int tmp=peek;
            if(iterator.hasNext()){
                peek=iterator.next();
            }else{
                hasNext=false;
            }
            return tmp;
        }else{
            return null;
        }
	}
	
	@Override
	public boolean hasNext() {
        return hasNext?true:false;
	    
	}
}