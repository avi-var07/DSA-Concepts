import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of elements: ");
        int n =sc.nextInt();
        System.out.println("Enter the elements: ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int start=0,end=n-1;
        System.out.println("Original: ");
        for(int i:arr)
        System.out.print(i+" ");
        System.out.println();
        while (start<end) {
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.println("Reversed: ");
        for(int i:arr)
        System.out.print(i+" ");
        sc.close();
    }
}