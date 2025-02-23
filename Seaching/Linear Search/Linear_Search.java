import java.util.Scanner;

class Linear_Search {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of array: ");
        int n = sc.nextInt();

        int arr[] =new int[n];

        System.out.println("Enter the elements: ");

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        for(int i=0;i<n;i++){
            if(arr[i]==target)
            System.out.println("Found at: "+i);

        }

        sc.close();
    }
}