import java.util.ArrayList;
import java.util.Scanner;

class MergeSort {
    static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;

      ArrayList<Integer> temp = new ArrayList<>();
        
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        
        for(int i=low;i<=high;i++)
        arr[i]= temp.get(i-low);
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
        else return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of the array: ");
        for (int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Before applying Merge Sort: ");
        for (int i = 0; i < n; i++) 
        System.out.print(arr[i] + " ");


        System.out.println();
        mergeSort(arr, 0, n - 1);

        System.out.println("After applying Merge Sort: ");
        for (int i = 0; i < n; i++) 
        System.out.print(arr[i] + " ");

        sc.close();
    }
}
