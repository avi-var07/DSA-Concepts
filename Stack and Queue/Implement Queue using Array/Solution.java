import java.util.*;

class Solution {

    static int front = -1, rear = -1, size = 0;
    static int[] q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter capacity of queue: ");
        int n = sc.nextInt();
        q = new int[n];

        System.out.print("Enter number of operations: ");
        int ops = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Available operations: enqueue, dequeue, peek, size");
        for (int i = 0; i < ops; i++) {
            System.out.print("Enter operation: ");
            String op = sc.nextLine().toLowerCase();

            switch (op) {
                case "enqueue":
                    if (rear == n - 1) {
                        System.out.println("Queue overflow!");
                        break;
                    }
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    sc.nextLine();
                    enqueue(val);
                    break;

                case "dequeue":
                    if (front == -1 || front > rear)
                        System.out.println("Queue underflow!");
                    else
                        System.out.println("Dequeued element: " + dequeue());
                    break;

                case "peek":
                    if (front == -1 || front > rear)
                        System.out.println("Queue is empty!");
                    else
                        System.out.println("Front element: " + peek());
                    break;

                case "size":
                    System.out.println("Current size: " + size());
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }
        }

        sc.close();
    }

    static void enqueue(int x) {
        if (front == -1) front = 0;
        rear++;
        q[rear] = x;
        size++;
        System.out.println(x + " added to queue");
    }

    static int dequeue() {
        int val = q[front];
        front++;
        size--;
        return val;
    }

    static int peek() {
        return q[front];
    }

    static int size() {
        return size;
    }
}
