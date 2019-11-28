package Coursera.Week1;

import java.util.Scanner;

public class QuickUnion {
    int[] id;

    //initialise the array in the constructor
    public QuickUnion(int n) {
        id = new int[n];
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    //find the root of the given point
    private int root(int p) {
        while(id[p] != p) {
            p = id[p];  //change the
        }
        return p;  //as we are changing this point.
    }

    //are connected ?
    public boolean connected(int p, int q){
        return (root(p) == root(q));
    }

    //union : join the two
    public void union(int p, int q) {
        //change the parent of the root of the first one
        //to the root of the second one.
        if(root(p) != root(q)) {
            id[root(p)] = root(q);
            System.out.println(p + " " + q + " are connected !");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        QuickUnion qu = new QuickUnion(n);

        while(in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();

            if(!qu.connected(p,q)) {
                qu.union(p,q);
            }
            else{
                System.out.println(p + " "+ q + " are already connected!");
            }
        }
    }
}
