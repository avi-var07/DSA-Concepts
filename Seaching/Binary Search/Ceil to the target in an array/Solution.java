/*next greater or equal element!! */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter target to find its ceil: ");
        int target = sc.nextInt();
        target=(int)(Math.ceil(target));
        int start=0, end=n-1,ans=0;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target)ans=mid;
            else if (target>arr[mid])start=mid+1;
            else end=mid-1;

        }
        System.out.println(arr[start]);
        sc.close();
    }
}