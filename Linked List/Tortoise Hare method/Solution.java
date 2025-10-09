/*
slow pointer moves by 1, fast by 2;
 */
import java.util.Scanner;
class Node{
    Node next;
    Node prev;
    int data;

    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        int headVal = sc.nextInt();

        Node head = new Node(headVal);
        Node current = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            Node temp = new Node(ele);
            current.next=temp;
            temp.prev = current;

            current = temp;

        }

        System.out.println("Original: ");
        print(head);

        System.out.println();

        head = tortoiseHareAlgo(head);
        System.out.println("Middle: ");
        print(head);

        sc.close();
    }
    static void print(Node head){
        Node temp = head;
        while(temp!=null){

            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static Node tortoiseHareAlgo(Node head){
        
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}