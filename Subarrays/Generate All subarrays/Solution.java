//subarrays are contiguous part of an array.
//no of subarrays =  n(n+1)/2
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int arr[]= new int[n];

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("All Subarrays of the array are: ");

        for(int start = 0;start<n;start++){
            for(int end = start; end<n;end++){
                for(int i=start; i<=end;i++)
                System.out.print(arr[i]);

                System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }
}