/*You are given array consisting of n integers. Your task is to find the maximum length of an increasing subarray of the given array.

A subarray is the sequence of consecutive elements of the array. Subarray is called increasing if each element of this subarray strictly greater than previous.

Input
The first line contains single positive integer n (1 ≤ n ≤ 105) — the number of integers.

The second line contains n positive integers a1, a2, ..., an (1 ≤ ai ≤ 109).

Output
Print the maximum length of an increasing subarray of the given array. */
import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();

        int arr[] = new int[n];
    
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(maximumIncrease(arr, n));
        sc.close();
    }
    static int maximumIncrease(int arr[], int n){
        int count = 1, ans=1;
        for(int i=0;i<n-1;i++){
            if(arr[i]<arr[i+1])count++;
            else count=1;
            ans=Math.max(ans, count);
        }
        return ans;
    }
}