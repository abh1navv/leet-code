// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    List<Integer> list;
    int pointer = 0;
	public PeekingIterator(Iterator<Integer> iterator) {
        list = new LinkedList<>();
	    while(iterator.hasNext()) {
            list.add(iterator.next());
        }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.get(pointer);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return list.get(pointer++);
	}
	
	@Override
	public boolean hasNext() {
	    return pointer<list.size();
	}
}