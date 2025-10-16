import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter value of k: ");
        int k = sc.nextInt();
        System.out.println("Subsequences whose sum is equal to "+k+" is: ");
        
        System.out.println(printAllSubsequences(0, arr, n, k, 0));
        sc.close();
    }
    static int printAllSubsequences(int index, int arr[], int n, int k, int sum){
        if(index>=n){
            if(sum==k) return 1;
            
            return 0;
        }
      
 
        sum+=arr[index];
        int l=printAllSubsequences(index+1, arr, n, k, sum);
  
        sum-=arr[index];
        int r=printAllSubsequences(index+1, arr, n, k, sum);

        return l+r;
    }
}