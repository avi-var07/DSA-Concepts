import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("How many times do you wanna rotate?");
        int k=sc.nextInt();
        //Left rotate
        int result[] = leftRotate(arr.clone(), k);
        System.out.println("After left rotation: ");
        for(int ele: result)System.out.print(ele+" ");

        System.out.println();
        //right rotate
        int ans[]=rightRotate(arr.clone(),k);
        System.out.println("After right rotation: ");
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
     public static void reverse(int arr[], int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }
    public static int[] leftRotate(int[] arr, int k) {
        int n  = arr.length;
        k%=n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);

        return arr;
    }
     public static int[] rightRotate(int[] arr, int k) {
        int n  = arr.length;
        k%=n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        return arr;
    }
}
