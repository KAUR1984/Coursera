package Coursera.AlgorithmsPart1.Week2;
//TODO uncomment the comments !
import java.util.Iterator;
//Just add this new piece of code to the Linked List implementation of stack!
//This is the stack in the form of Linked List implementing the Iterable interface
public class StackLLIterable<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();    //this is an iterator being returned
    }

    public class ListIterator<T> implements Iterator<T>{
//        Node current = first;
        @Override
        public boolean hasNext() {
            return false;
//            return current != null;
        }

        @Override
        public T next() {     //otherwise it would have returned Object class
            return null;
//            T rtn = current.value;
//            current = current.next;
//            return rtn;      //move the pointer ahead by one!
        }
    }
}
