import java.util.Scanner;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next=null;
    }
}
class Solution{
    static Node convertToLinkedList(int arr[]){
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            current.next = temp;
            current=temp;
        }
        return head;
    }
    static int lengthOfLinkedList(Node head){
        Node temp = head;
        int len =0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        
        
    }
    static boolean search(Node head, int val){
        Node temp = head;
        while(temp!=null){
            if(temp.data==val)return true;
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {2,1,3,4,8};

        Node head = convertToLinkedList(arr);

        System.out.println("Length of the Linked List is: "+lengthOfLinkedList(head));

        display(head);

        System.out.println();
        System.out.println("Enter Value to search: ");
        int val = sc.nextInt();

        System.out.println(search(head, val));

        sc.close();
    }
}