/*

Kadane's Algorithm ye kehta hai ki ek hi loop chalao aur sum nikalte jao, jaha bhi tumahara currentSum -ve hojaye currentSum 0 krdo aur usse pehle wale elements ko bhool hi jao,
yaad rkhna ki current sum nikalne baad maxSum se compare krlena wrna 0 hojayega hr baar

logic -ve+-ve=-ve and +ve + large -ve = -ve

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

        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currentSum+=arr[i];
            if(maxSum<currentSum)maxSum=currentSum;
            if(currentSum<0)currentSum=0;   //ye reset wala chiz last mei isliye likh rhe taaki kam se kam ek baar to maxSum calculate ho

        }

        System.out.println("Maximum subarray sum is: "+maxSum);
        sc.close();
    }
}