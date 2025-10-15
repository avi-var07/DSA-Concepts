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
        List<Integer> ds = new ArrayList<>();
        printAllSubsequences(0, arr, ds, n, k, 0);
        sc.close();
    }
    static void printAllSubsequences(int index, int arr[], List<Integer>ds, int n, int k, int sum){
        if(index>=n){
            if(sum==k){
                for(int ele: ds)System.out.print(ele+" ");
                System.out.println();
            }
            return;
        }

        ds.add(arr[index]);
        sum+=arr[index];
        printAllSubsequences(index+1, arr, ds, n, k, sum);
        ds.remove(ds.size()-1);
        sum-=arr[index];
        printAllSubsequences(index+1, arr, ds, n, k, sum);
    }
}