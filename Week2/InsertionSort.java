package Coursera.Week2;

public class InsertionSort {

    public void sort(Comparable[] a){
        for(int i = 0; i < a.length-1; i++) {
            //check the current with the left hand side of the counter
            //if it is less then exchange that
            //if i = 0, that means it is already sorted
            for(int j = i+1; j > 0; j--){
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }else break;
            }
        }
    }

    public boolean less(Comparable v, Comparable w){
        return w.compareTo(v) < 0;
    }

    public void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Comparable<Integer>[] a = new Comparable[]{7,6,4,3,67,45,467,8,4527,68,9,0,-19349,0,-10};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        for(Comparable<Integer> elem : a){
            System.out.print(elem + " ");
        }
    }

}
