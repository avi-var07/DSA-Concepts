class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Solution{
    public static void main(String[] args) {
        int arr[] = {2,1,3,4,8};
        Node head = new Node(arr[0]);   //first element(head)
        Node current = head;    //mover, taaki head pe koi directly chedkhani na ho, head ka secretary hai jo saara samaan smbhalega head ka
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]); //element add hogya
            current.next = temp;    //head ka secretary ab naye element ka address store krega
            current = temp;         //ab ye naye element ka secretary ban gaya aur wps se same kaam krega:  naya element add hoga, current uska secretary bnega
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}