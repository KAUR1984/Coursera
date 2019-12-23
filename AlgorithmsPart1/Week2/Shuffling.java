package Coursera.AlgorithmsPart1.Week2;

import java.util.Random;

public class Shuffling {

    public void shuffle(int[] a){
        Random r = new Random();
        for(int i = 0; i < a.length; i++){
            int randomIndex = r.nextInt(i+1);
            exch(a,randomIndex,i);
        }
    }

    public void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        Shuffling shuffling = new Shuffling();
        shuffling.shuffle(a);
        for(int elem : a){
            System.out.print(elem + " ");
        }
    }
}
