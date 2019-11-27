package Coursera.Week1;

import java.util.Scanner;

public class Anonymous {

    int[] id;
    int[] size;
    public Anonymous(int n){  //n is no of objects
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        for(int i = 0; i < size.length; i++) {
            size[i] = i;
        }
    }

    //find the root. id represents the parent
    private int root(int i) {
        while(id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return (root(p) == root(q));
    }

    //assume not connected initially, ie the roots are not same
    public void union(int p, int q){
        //make the parent of the root of the second one, with that of the root of the first one
        if(size[p] < size[q]) {
            id[root(p)] = root(q);
            size[q] += size[p];
        }else{
            id[root(q)] = root(p);
            size[p] += size[q];
        }
    }

    //DYNAMIC CONNECTIVITY CLIENT
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);   //number of objs are inputted
        int noOfObjects = in.nextInt();

        Anonymous uf = new Anonymous(noOfObjects);

        while(in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();

            if(!uf.connected(p,q)) {
                uf.union(p,q);
                System.out.println(p + " " + q + " are now connected!");
            }
            else{
                System.out.println(p + " " + q + " are already connected!");
            }
        }
    }
}
