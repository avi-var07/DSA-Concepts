import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        System.out.println("Enter the size of the window:");
        int k = sc.nextInt();
        int result[] = firstNegativeinWindow(arr, k);
        System.out.println("First negative number in each window of size " + k + ":");
        for(int ele:result)System.out.println(ele+" ");
        sc.close();
    }
    public static int[] firstNegativeinWindow(int arr[], int k){
        int n = arr.length;
        int result[]=new int[n-k+1];
        int index=0;
        ArrayDeque<Integer>deque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!deque.isEmpty()&&deque.peekFirst()<i-k+1) deque.pollFirst();

            if(arr[i]<0)deque.offerLast(i);

            if(i>=k-1){
                if(!deque.isEmpty())result[index++]=arr[deque.peekFirst()];
                else result[index++]=0;
            }
        }
        return result;
    }
}