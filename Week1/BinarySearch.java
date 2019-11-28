package Coursera.Week1;

import java.util.Scanner;

public class BinarySearch {
    public int search(int[] a, int key) {     //the key you wanna find in an array; return index
        int low = 0;
        int hi = a.length - 1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;

            if (key < a[mid]) {     //on the left of a[mid]
                hi = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {    //if the key is equal to a[mid]
                return mid;
            }
        }
        return -1;   //if not found !
    }

    public static void main(String[] args) {
        int[] a;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int size = in.nextInt();
        a = new int[size];

        for(int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }

        System.out.println("this is the array which u have inputted !!");
        for(int elem : a) {
            System.out.print(elem + " ");
        }
        System.out.println();

        System.out.print("Enter the key you wanna search :");
        int key = in.nextInt();

        BinarySearch bs = new BinarySearch();
        int found = bs.search(a,key);
        System.out.println("key found at index :" + found);
    }
}
