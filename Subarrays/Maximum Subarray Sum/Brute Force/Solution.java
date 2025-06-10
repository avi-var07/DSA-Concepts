/*
Let the array is 3,-4,5,4,-1,7,-8 return the possible maximum subarray sum.
Brute Force Approach: Generate all subarrays and sum it, compare to maxSum and return the maxSum.
Optimized Brute Force: No need to generate sum again and again from start to end, just add the element at end position because the sum has already been calculated way before.

*/

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

        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int currentSum = 0;
            for(int j=i;j<n;j++){
                currentSum+=arr[j];
                if(currentSum>maxSum)
                maxSum=currentSum;
            }
        }
        //i represents start, j represents end
        
        System.out.println("Maximum Subarray sum is: "+maxSum);
        sc.close();
    }
}