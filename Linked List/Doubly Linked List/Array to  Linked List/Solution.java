class Node{
    int data;
    Node next;
    Node back;

    Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}
class Solution{
    public static void main(String[] args) {
        int arr[] = {2,1,3,4,8};
        Node head = convertToLinkedList(arr);
        print(head);
    }
    static Node convertToLinkedList(int arr[]){
        
        Node head = new Node(arr[0]);   //first element(head)
        Node prev = head;   
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]); //element add hogya
            temp.back=prev; //iska back prev se connect hogya
            prev.next=temp; //aage se connect
            prev=temp;  //prev temp pe aagya cycle repeat kroge n
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
}