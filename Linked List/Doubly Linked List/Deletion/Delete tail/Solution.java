import java.util.*;

class Node{
    int data;
    Node next;
    Node back;

    Node(int data){
        this.data=data;
        this.next = null;
        this.back = null;
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
        
        Node head = convertToLinkedList(arr);

        print(head);
        System.out.println();

        head = deleteTail(head);
        print(head);
        
        sc.close();
    }
    static Node convertToLinkedList(int arr[]){
        Node head = new Node(arr[0]);

        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.back=prev;
            prev.next=temp;
            prev = temp;
        }
        return head;
    }
    static void print(Node head){
        Node temp  = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static Node deleteTail(Node head){
        
        if(head==null||head.next==null)return null;

        Node tail = head;
        while(tail.next!=null)tail=tail.next;

        Node prev = tail.back;
        prev.next=null;
        tail.back=null;
        
        return head;
    }
}