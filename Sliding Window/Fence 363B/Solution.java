import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int[n];
      
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        fence(arr, n, k);
        sc.close();
    }
    static void fence(int arr[], int n, int k){
        int ans = 0;
        int sum = 0;
        for(int i=0;i<k;i++)sum+=arr[i];
        int mini = sum;

        for(int i=k;i<n;i++){
            sum=sum-arr[i-k]+arr[i];
            
            if(sum<mini){
                ans=i-k+1;
                mini=sum;
            }
        }

        System.out.println(ans+1);
        

    }
}