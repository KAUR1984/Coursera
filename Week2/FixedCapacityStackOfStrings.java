package Coursera.Week2;

import java.util.Scanner;

public class FixedCapacityStackOfStrings {
    private String[] a;
    int pointer = 0;    //the pointer or array entry at which we are currently pointing ! or the one which has been most recently added
    FixedCapacityStackOfStrings(int capacity) {      //TODO a cheat - stay tuned
        a = new String[capacity];
    }

    public boolean isEmpty(){
        return pointer == 0;      //if the pointer is currently pointing to 0, that means nothing has been
    }                             // added to it so that it could at the 1th index

    public void push(String s) {
        a[pointer] = s;
        pointer++;
    }

    public String pop() {
        pointer--;   //first you need to decrement the pointer as when have added something it must have incremented.
        String rtn = a[pointer];   //or can write it as <String rtn = a[--pointer]>...
        a[pointer] = null;   //in order to avoid loitering in java
        return rtn;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the capacity of the array stack : ");
        int capacity = in.nextInt();

        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(capacity);
        while(in.hasNext()){
            String s = in.next();
            if(s.equals("-")){
                System.out.println(stack.pop() + " has been popped!");
            }else{
                stack.push(s);
                System.out.println(s + " has been pushed to the array stack!");
            }
        }

    }
}
