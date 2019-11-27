package Coursera.Week1;

import java.util.Scanner;

public class WeightedQuickUnion_Improve1 {
    int[] id;
    int[] size;

    public WeightedQuickUnion_Improve1(int n) {
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < id.length; i++){
            id[i] = i;
            size[i] = 1;   //initialise every size entry with 1
        }
    }

    //find the root of the i th entry
    private int root(int i) {
        while(id[i] != i){
            i = id[i];  //change the current with its parent!
        }
        return i;
    }

    //connected?
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    //union
    //Simple - Change the parent of the root of the first one to the root of the second one
    //Now - Change the parent of the root of the smaller one to the root of the larger one
    public void union(int p, int q){
        int rootp = root(p);
        int rootq = root(q);

        if(rootp != rootq){     //if the roots are not equal
            if(size[p] <= size[q]) {    //if equal, by default execute the first one!
                id[rootp] = rootq;    //make the parent of the root of the smaller one, to the bigger one!
                size[q] += size[p];
            }else if(size[p] > size[q]){
                id[rootq] = rootp;
                size[p] += size[q];
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of objects :");
        int n = in.nextInt();

        WeightedQuickUnion_Improve1 wqu = new WeightedQuickUnion_Improve1(n);

        while(in.hasNext()){  //take until next input token is there
            int i = in.nextInt();
            int j = in.nextInt();

            if(!wqu.connected(i,j)){
                wqu.union(i,j);
                System.out.println(i + " " + j + " now connected");
            }
            else{
                System.out.println(i + " " + j + " already connected");
            }
        }
    }
}
