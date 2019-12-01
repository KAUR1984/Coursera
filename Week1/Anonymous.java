package Coursera.Week1;

import java.util.Scanner;

public class Anonymous {

    public int search(int[] a, int key){
        int lo = 0;
        int hi = a.length-1;

        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(a[mid] < key) {
                lo = mid + 1;
            }else if(a[mid] > key){
                //search on the left hand side
                hi = mid-1;
            }else{   //if a[mid] == key
                return mid;    //return the mid index
            }
        }
        return -1;   //the key is not present
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = in.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the sorted array : ");
        for(int i =0; i <n; i++) {
            a[i] = in.nextInt();   //inputted the array
        }

        System.out.println("Enter the key :");
        int key = in.nextInt();

        Anonymous bs = new Anonymous();
        System.out.println("key found at index : " + (bs.search(a,key)));

    }

}
