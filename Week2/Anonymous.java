package Coursera.Week2;

import java.util.Scanner;

public class Anonymous {
    Node first;

    class Node {
        String value;
        Node next;

        Node(String value){
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String s) {
        Node oldFirst = first;
        Node newNode = new Node(s);
        first = newNode;
        first.next = oldFirst;
    }

    public String pop(){
        Node oldNode = first;
        first = first.next;
        String rtn = oldNode.value;
        oldNode = null;
        return rtn;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Anonymous stack = new Anonymous();

        while(in.hasNext()){
            String s = in.next();
            if(s.equals("-")){
                System.out.println(stack.pop());
            }else{
                stack.push(s);
            }
        }
    }
}
