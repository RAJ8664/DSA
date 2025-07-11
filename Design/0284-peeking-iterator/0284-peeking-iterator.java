import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it = null;
    Integer prev = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (it.hasNext())
            prev = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return prev;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = prev;
        if (it.hasNext())
            prev = it.next();
        else
            prev = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return prev != null || it.hasNext();
    }
}