import java.util.*;

class Node{
    Node next;
    int data;

    Node(int data){
        this.data=data;
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
        
        System.out.println("Enter position to insert at: ");
        int pos = sc.nextInt();

        System.out.println("Enter value to be inserted: ");
        int val = sc.nextInt();

        Node head = convert(arr);

        print(head);
        System.out.println();

        head = insertAtPosition(head, pos, val);
        print(head);
        sc.close();
    }
    static Node convert(int arr[]){
        
        Node head= new Node(arr[0]);
        Node current = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            current.next= temp;
            current=temp;
        }
        return head;
    }

    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    static Node insertAtPosition(Node head, int pos, int val){
        if(head==null){
            if(pos==1){
                Node temp = new Node(val);
                temp.next=null;
                return temp;
            }
            else return null;
        }
        if(pos==1){
            Node temp = new Node(val);
            temp.next = head;
            return temp;
        }
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;

            if(count==pos-1){
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next=newNode;
                break;

            }
            else temp=temp.next;
            
        }
        return head;
    }
}