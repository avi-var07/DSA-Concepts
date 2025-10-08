import java.util.Scanner;

class Node{
    Node next;
    Node back;
    int data;

    Node(int data){
        this.data=data;
        this.back=null;
        this.next=null;
    }

}


class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        int headVal  =sc.nextInt();

        Node head = new Node(headVal);
        Node prev = head;
        for(int i=1;i<n;i++){
            int val = sc.nextInt();

            Node temp = new Node(val);
            temp.back = prev;
            prev.next=temp;
            prev= temp;
        }

        System.out.println("Original Linked List: ");
        print(head);

        System.out.println();
        System.out.println("Enter the element to delete: ");
        int k = sc.nextInt();

        deleteKthNode(head, k);
        System.out.println("After deletion: ");
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
    static Node deleteKthNode(Node head, int k){

        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==k)break;
            temp=temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;

        if(front==null){
            prev.next=null;
            temp.back=null;
            return head;
        }

        prev.next = front;
        front.back = prev;
        temp.next=null;
        temp.back=null;

        return head;
    }
}