import java.util.Scanner;

class Node {
    Node next;
    Node back;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of the LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of the LinkedList: ");
        int val = sc.nextInt();
        Node head = new Node(val);
        Node current = head;
        for (int i = 1; i < n; i++) {
            int ele = sc.nextInt();
            Node newNode = new Node(ele);
            newNode.back=current;
            current.next = newNode;
            current = newNode;
        }
        print(head);

        System.out.println();
        System.out.println("Enter the key to delete occurrence: ");
        int key = sc.nextInt();
        head = dltAllOccurence(head, key);
        print(head);
        sc.close();
    }
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }
    static Node dltAllOccurence(Node head, int key){
        Node temp = head;
        while(temp!=null){
            if(temp.data==key){
                Node prev = temp.back;
                Node front = temp.next;
                if(prev!=null&&front!=null){
                    front.back = prev;
                    prev.next=front;
                    temp.next=null;
                    temp.back=null;
                }
                else if(prev==null){
                    head=front;
                    head.back=null;
                    temp.next=null;
                    temp=head;
                }
                else{
                    prev.next=null;
                    temp.back=null;
                }
                temp=front;
            }
            else temp=temp.next;
        }
        return head;
    }
}