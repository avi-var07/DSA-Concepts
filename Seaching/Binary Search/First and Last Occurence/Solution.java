import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter the target: ");
        int target  =sc.nextInt();
        int ans[]={-1,-1};
        ans[0]=findOccurence(arr, target, true);
        ans[1]=findOccurence(arr, target, false);

        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }
    public static int findOccurence(int arr[], int target, boolean firstOccurence){
        int start = 0, end=arr.length-1, index=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                index=mid;
                if(firstOccurence)end=mid-1;
                else start=mid+1;

            }
            else if(target>arr[mid]) start=mid+1;
            else end=mid-1;
        }
        return index;

    }
}