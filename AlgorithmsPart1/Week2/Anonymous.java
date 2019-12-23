package Coursera.AlgorithmsPart1.Week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Anonymous {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Double[] a = new Double[n];
        for(int i = 0; i < n; i++) {
            Random r = new Random();
            a[i] = r.nextDouble();
        }
        //sort them
        Collections.sort(Arrays.asList(a));
        for(Double elem : a){
            System.out.print(elem + " ");
        }
    }
}
