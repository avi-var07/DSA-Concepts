import java.util.*;

class Node{
    int data;
    Node next;
    Node back;

    Node(int data){
        this.data=data;
        this.next=null;
        this.back =null;
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

        printLL(head);
        
        System.out.println();
        System.out.println("Enter value to insert at head : ");
        int value = sc.nextInt();

        head = insertAtHead(head, value);

        printLL(head);

        sc.close();
    }
    static Node convert(int arr[]){
        Node head = new Node(arr[0]);

        Node prev = head;
        for(int i =1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.back=prev;
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    static void printLL(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static Node insertAtHead(Node head, int value){
        Node temp = new Node(value);
    
        temp.next = head;
        head.back=temp;
        temp.back=null;

        return temp;
    }
    
}