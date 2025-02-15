import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) 
        arr[i] = sc.nextInt();
        System.out.println("Array is: ");
        for(int i=0; i<n; i++) 
        System.out.print(arr[i]+" ");
        Arrays.sort(arr);   // Sorting the array
        System.out.println("\nFrequency of each element in the array: ");
        int count =1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                count++;
            }
            else{
                System.out.println(arr[i-1]+" occurs "+count+" times");
                count=1;
            }
        }
        sc.close();
    }
}