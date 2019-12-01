package Coursera.Week2;

import java.util.Scanner;

public class StackLinkedList {
    Node first;      //this is a pointer with no instantiation

    public class Node {
        String value;
        Node next;   //pointer to the next node

        Node(String value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    //push to the top
    public void push(String item){
        //store the old node
        Node oldNode = first;
        //create a new Node
        Node newNode = new Node(item);
        first = newNode;
        first.next = oldNode;
    }

    //pop from the top
    public String pop() {
        Node oldNode = first;   //get the old first node
        first = first.next;     //point the first to the next one
        String rtn = oldNode.value;    //this is the value of the old one to be printed
//        oldNode = null;
        return rtn;
    }

    //DRIVER METHOD
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StackLinkedList stack = new StackLinkedList();

        while(in.hasNext()){
            String inputString = in.next();
            if(inputString.equals("-")){
                System.out.println(stack.pop());
            }else{
                stack.push(inputString);
            }
        }
    }
}
