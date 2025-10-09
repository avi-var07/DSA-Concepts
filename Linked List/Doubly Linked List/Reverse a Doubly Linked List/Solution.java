import java.util.Scanner;
class Node{
    Node next;
    Node back;
    int data;

    Node(int data){
        this.data=data;
        this.next=null;
        this.back=null;
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
            temp.back = current;

            current = temp;

        }

        System.out.println("Original: ");
        print(head);

        System.out.println();

        head = reversal(head);
        System.out.println("Reversed: ");
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

    static Node reversal(Node head){

        if(head==null||head.next==null)return head;
        Node current = head;
        Node last = null;
        while(current!=null){
            last = current.back;
            current.back = current.next;
            current.next = last;

            current = current.back;
        }

        return last.back;
    }
}