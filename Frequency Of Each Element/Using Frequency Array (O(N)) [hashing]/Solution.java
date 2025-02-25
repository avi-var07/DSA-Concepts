import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        System.out.println("Array: ");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
        System.out.println("\nFrequency of each element in the array: ");
        int maxval=0;
        for(int i=0;i<n;i++){
            if(arr[i]>maxval)
            maxval=arr[i];
        }

        int[] freq = new int[maxval+1];

        for(int i=0;i<n;i++)
        freq[arr[i]]++;

        for(int i=0;i<=maxval;i++){
            if(freq[i]>0)
            System.out.println(i+" "+freq[i]);
        }
        sc.close();
    }
}