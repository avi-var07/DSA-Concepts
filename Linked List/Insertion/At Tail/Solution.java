import java.util.*;

class Node{
    Node next;
    int data;

    Node(int data){
        this.data= data;
        this.next=null;
    }
}

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        Node head = convert(arr);

        print(head);
        System.out.println();

        System.out.println("Enter value to insert: ");
        int val = sc.nextInt();

        insertAtTail(head, val);

        print(head);
        
        sc.close();
    }
    static Node convert(int arr[]){
        Node head = new Node(arr[0]);
        Node temp= head;

        for(int i=1;i<arr.length;i++){
            Node current = new Node(arr[i]);
            temp.next = current;
            temp = current;
        }
        return head;
    }
    static void print(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    static Node insertAtTail(Node head, int val){
        if(head == null){
            Node temp = new Node(val);
            temp.next=null;
            return temp;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.next=null;

        return head;
    }
}