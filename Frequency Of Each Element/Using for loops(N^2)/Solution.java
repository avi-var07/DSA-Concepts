import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Array: ");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
        System.out.println("\nFrequency of each element in the array: ");

        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==true) continue;
            int count=1;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                    visited[j]=true;
                }
            }
            System.out.println(arr[i]+"occurs"+count);
        }
        
        sc.close();
    }
}