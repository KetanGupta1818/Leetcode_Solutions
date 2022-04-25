
class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> iter;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        next = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int cur = next;
        next = iter.hasNext()? iter.next() : null;
        return cur;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }
}
