import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<Integer> ds = new ArrayList<>();
        System.out.println("The subsequences are: ");
        printAllSubsequence(0, arr, ds, n);
        sc.close();
    }
    static void printAllSubsequence(int index, int arr[], List<Integer>ds, int n){

        if(index>=n){
            for(int ele: ds)System.out.print(ele+" ");
            System.out.println();
            return;
        }
        ds.add(arr[index]);
        printAllSubsequence(index+1, arr, ds, n);
        ds.remove(ds.size()-1);
        printAllSubsequence(index+1, arr, ds, n);

    }
}