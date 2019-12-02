package Coursera.Week2;

public class SelectionSort {      //this is the generic selection sort

    public void sort(Comparable[] a) {    //the selection sort itself doesnot implement the Comparable interface
                                          //as it is not a thing to be compared instead it uses the elements which are comparable themselves.
        int i = 0;     //lets start from the initial pointer of the array
        while(i < a.length) {    //until the last entry of the array
            int min = i;    //lets assume the current minimum to be i itself
            int j = i+1;       //for every i, start with i+1 ; compare with the minimum of the rest
            while(j < a.length) {
                if(less(a[j],min)){        //if the less than the minimum one then update
                    min = j;
                }
                j++;
            }
            exch(a,min,i);    //since you have initialised the min with i that has to be small anyway !
            i++;
        }
    }

    //Compare two objects
    public boolean less(Comparable v, Comparable w){
        return (v.compareTo(w) < 0);
    }

    //Got an array and swap the mentioned indexes
    public void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
