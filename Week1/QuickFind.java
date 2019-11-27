package Coursera.Week1;

import java.util.Scanner;

public class QuickFind {
    private int[] id;

    public QuickFind(int numOfObjects){
        id = new int[numOfObjects];    //create an array of the number of objects

        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    //check if connected
    public boolean connected(int p, int q){
       return (id[p] == id[q]);
    }

    //union or connect the two
    public void union(int p, int q){
        int pid = id[p];   //this is the value at index p
        int qid = id[q];   //this is the value at index q

        if(pid != qid) {   //this if block is redundant as we are checking this condn in the main func itself.
            for(int i = 0; i < id.length; i++) {
                if(id[i] == pid) {   //if the entry is equal to the value of the first one, then
                    id[i] = qid;    //change that value to the value of the second one!
                }
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {

            //first take the input from the user of how many objects to work upon?
            Scanner in = new Scanner(System.in);
            System.out.println("Enter number of objects : ");
            int n = in.nextInt();     // just check here for the sake of memory constraints!

            QuickFind qf = new QuickFind(n);

            //then take the union inputs!
            while(in.hasNext()){    //while the input is being given, just take it!
                int p = in.nextInt();
                int q = in.nextInt();

                if(!qf.connected(p,q)){
                    qf.union(p,q);
                    System.out.println(p + " " + q + " connected !");
                }else{
                    System.out.println(p + " " + q + " are already connected !");
                }
            }
        }
    }
}
