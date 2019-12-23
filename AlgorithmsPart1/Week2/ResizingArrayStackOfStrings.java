package Coursera.AlgorithmsPart1.Week2;

import java.util.Scanner;

public class ResizingArrayStackOfStrings {
    String[] a;
    int pointer = 0;

    ResizingArrayStackOfStrings(){
        a = new String[1];      //lets start by creating the size of array as 1 initially.
    }                        //Better would have been 20! ;-P

    //Create the array of given size
    private void resize(int size){
        //create a new array
        String[] newArray = new String[size];   //make a new array of double to that of the initial one
        //copy all the elements of the previous array to the new array
        System.arraycopy(a,0,newArray,0,a.length);
        //point the passed array to this one
        a = newArray;

        //just print the new array and its size
        System.out.println("The size of the new array is " + size);
        for(String s : a) {
            System.out.print(s + " ");
        }
    }

    public void push(String s){
        //To account for array overFlowing
        if(pointer == a.length){    //that means the array is full upto entry at a[n-1]
            resize(2*a.length);
        }

        a[pointer] = s;   //lets put the string to that array entry
        pointer++;    //move the pointer ahead
    }

    public String pop(){
        //resize the array to half if it one quarter full to half
        pointer--;
        if(pointer < 0){
            throw new IndexOutOfBoundsException("The array is under-flowed; tried to access index less than 0");
        }
        String rtn = a[pointer];
        a[pointer] = null;   //To avoid loitering

        //if after popping the given element, the array is quarter-full
        //then resize it! Otherwise 1 more size would be made, if before popping, we resize
        if(pointer <= a.length/4){
            resize(a.length/2);    //resize to half
        }
        return rtn;
    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        while(in.hasNext()){
            String s = in.next();
            if(s.equals("-")){
                System.out.println(stack.pop()+ " has been popped!");
            }
            else{
                stack.push(s);
                System.out.println(s + " has been pushed into the resizable array stack!");
            }
        }
    }
}
