package Coursera.AlgorithmsPart1.Week2;

import java.util.Scanner;

public class LinkedQueueOfStrings<T> {
    private Node first, last;

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public void enqueue(T value) {     //add/push to the last
        Node oldLast = last;
        Node newNode = new Node(value);
        if(isEmpty()) {
            first = last = newNode;   //assign the value of first to the last!
        }
        else{
            oldLast.next = newNode;     //if the last is not equal to null
        }
        last = newNode;
        last.next = null;    //be consistent with the definition of last !
    }

    public T dequeue() {     //remove/pop from the first
        Node oldFirst = first;
        first = first.next;
        if(isEmpty()) last = null;
        T rtn = oldFirst.value;
        oldFirst = null;
        return rtn;
    }

    public boolean isEmpty() {
        return (first == null) && (last == null);     //FIXME last==null was not present in the solution.
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedQueueOfStrings<String> queue = new LinkedQueueOfStrings<>();

        while(in.hasNext()) {
            String s = in.next();
            if(s.equals("-")){
                System.out.println(queue.dequeue() + " has been dequeued.");
            }else{
                queue.enqueue(s);
                System.out.println(s + " has been enqueued.");
            }
        }
    }

}
