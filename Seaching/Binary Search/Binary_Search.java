import java.util.Scanner;

class Binary_Search {
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

        int low = 0, high =n-1;

        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid]==target){
                System.out.println("Found at: "+mid);
                break;
            }
            else if(arr[mid]<target)
            low=mid+1;

            else
            high=mid-1;
        }

        sc.close();
    }
}