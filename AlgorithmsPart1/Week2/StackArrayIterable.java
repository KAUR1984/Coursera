package Coursera.AlgorithmsPart1.Week2;

//TODO uncomment the comments - just to avoid errors
import java.util.Iterator;

public class StackArrayIterable<T> implements Iterable<T> {

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();    //this is the iterator type
    }

    public class ReverseArrayIterator<T> implements Iterator<T>{
//        private int i = N;
        public boolean hasNext() {
            return false;
//            return i > 0;
        }

        public T next() {
            return null;
//            return s[--i];    //return the ith pointer
        }
    }

}
