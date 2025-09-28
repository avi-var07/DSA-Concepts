
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
    public static void main(String[] args) {
        int arr[] = {2,1,3,4,8};

        Node head = convertToLinkedList(arr);

        System.out.println("Length of the Linked List is: "+lengthOfLinkedList(head));

        display(head);
    }
}