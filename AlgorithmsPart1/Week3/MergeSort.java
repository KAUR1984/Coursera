package Coursera.AlgorithmsPart1.Week3;

public class MergeSort {

    public boolean less(Comparable v, Comparable w){
        return w.compareTo(v) < 0;
    }

    public void merge(Comparable[] a, Comparable[] aux,int lo, int hi, int mid){
        //copy the elements of a array to the auxiliary one
        System.arraycopy(a,0,aux,0,a.length);

        //Merge the two sorted halves
        int i = lo;
        int j = mid+1;

        for(int k = lo; k <= hi; k++){     //iterate over the main array
            if(i > mid) a[k] = aux[j++];         //if i has been exhausted
            else if(j > hi) a[k] = aux[i++];     // if j has been exhausted
            else if(less(a[i],a[j])) a[k] = aux[i++];    //if 'i' is less, then assign the kth entry with ith one
            else a[k] = aux[j++];      //if j is less, then assign the kth entry with jth one.
        }
    }

    public void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        //base case
        if(lo >= hi) return;    //as one-element array is already sorted
        //step case
        int mid = lo + (hi-lo) / 2;      //length/2 and then shift according to lo
        sort(a,aux,lo,mid);     //sort the first half
        sort(a,aux,mid+1,hi);   //sort the second half
        merge(a,aux,lo,hi,mid);    //merge the two halves
    }

    public void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    public static void main(String[] args) {
        Comparable<Integer>[] a = new Comparable[]{2, 3, 5, 23, 5, 64, 3545, 56, 75, -758, 0, -783};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);

        for(Comparable<Integer> elem : a){
            System.out.print(elem + " ");
        }
    }
}
