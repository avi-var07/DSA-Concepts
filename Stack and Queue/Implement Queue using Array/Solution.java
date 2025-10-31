import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter capacity of queue: ");
        int n = sc.nextInt();
        int q[] = new int[n];

        System.out.print("Enter number of operations: ");
        int ops = sc.nextInt();
        sc.nextLine(); 
        int start = -1, end=-1, currSize = 0;
        for (int i = 0; i < ops; i++) {
            System.out.println("Available operations: enqueue, dequeue, peek, size");
            System.out.print("Enter operation: ");
            String op = sc.nextLine().toLowerCase();

            switch (op) {
                case "enqueue":
                    if(currSize==n){
                        System.out.println("Overflow");
                        break;
                    }
                    if(currSize==0){
                        start=0;
                        end=0;
                    }
                    else end = (end+1)%n;
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    sc.nextLine();
                    q[end]=val;
                    currSize++;
                    break;

                case "dequeue":
                    if (currSize==0){
                        System.out.println("Queue is empty");
                        break;
                    }
                    else if(currSize==1){
                        System.out.println("Element dequeued is: "+q[start]);
                        start=-1;
                        end=-1;
                    }
                    else start = (start+1)%n;
                    currSize--;
                    break;

                case "peek":
                    if (currSize==0)System.out.println("Queue is empty!");
                    else System.out.println("Peek element: " + q[start]);
                    break;

                case "size":
                    System.out.println("Current size: " + currSize);
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }
        }

        sc.close();
    }

}
