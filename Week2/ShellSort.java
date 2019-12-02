package Coursera.Week2;

public class ShellSort {

    public void sort(Comparable[] a){
        //first make the knuth series
        int n = a.length;
        int h = 1;
        while(h < n/3){
            h = 3*h+1;     //1,4,10...
        }

        //now lets iterate after the highest h and then check the previous insertion sorts
        while(h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; (j >= h) && (less(a[j], a[j - h])); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h/=3;
        }
    }

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;    //if v is less than w or w is greater than v
    }

    public void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Comparable<Integer>[] a = new Comparable[]{7,6,4,3,67,45,467,8,4527,68,9,0,-19349,0,-10};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(a);

        for(Comparable<Integer> elem : a){
            System.out.print(elem + " ");
        }
    }
}
