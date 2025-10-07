import java.util.*;

class Node{
    int data;
    Node next;
    Node back;

    Node(int data){
        this.data=data;
        this.next = null;
        this.back=null;
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

        System.out.println("Enter the position to delete: ");
        int k = sc.nextInt();

        head = deleteAtPosition(head, k);
        print(head);
        
        sc.close();
    }
    static Node convertToLinkedList(int arr[]){
        Node head = new Node(arr[0]);

        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.back = prev;
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
    static Node deleteAtPosition(Node head, int k){

        if(head==null) return null;

        if(head.next==null&&k==1)return null;

        int len =0;
        Node temp=head;
        while(temp!=null){
            len++;
            if(len==k) break;
            temp=temp.next;
        }

        Node prev = temp.back;
        Node front = temp.next;

        if(prev==null&&front==null) return null; //single element
        else if(prev==null) {   //delete head
            head=head.next;
            head.back=null;
            temp.next=null;
            return head;
        }
        else if( front==null){  //delete tail
            temp.back=null;
            prev.next=null;
            return head;
        }
        else{
            prev.next=front;
            front.back=prev;
            temp.next=null;
            temp.back = null;
            
        }

        return head;

    }
}