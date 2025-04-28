import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        System.out.println("Enter the size of the sliding window:");
        int k = sc.nextInt();
        int result[] = slidingMaximum(arr, k);
        System.out.println("Maximum elements in each sliding window:");
        for(int ele:result)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] slidingMaximum(int arr[], int k){
        int n=arr.length;
        int result[] = new int[n-k+1];
        int index=0;
        ArrayDeque<Integer>deque =  new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(!deque.isEmpty()&&deque.peekFirst()<i-k+1)deque.pollFirst();

            while(!deque.isEmpty()&&arr[i]>arr[deque.peekLast()])deque.pollLast();

            deque.offerLast(i);

            if(i>=k-1)result[index++]=arr[deque.peekFirst()];

        }
        return result;
    }
}