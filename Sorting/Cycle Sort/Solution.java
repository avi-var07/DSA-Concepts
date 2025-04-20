import java.util.*;

class Solution {
    static void cycleSort(int arr[], int n) {
        int i = 0;
        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                // Swap arr[i] and arr[correct]
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++ ) arr[i] = sc.nextInt();
        System.out.println("Array before sorting:");
        for(int i=0;i<n;i++ ) System.out.print(arr[i]+" ");
        System.out.println();
        cycleSort(arr, n);
        System.out.println("Array after sorting:");
        for(int i=0;i<n;i++ ) System.out.print(arr[i]+" ");

        sc.close();
    }
}