import java.util.Scanner;
class DLLNode{
    DLLNode next;
    DLLNode prev;
    int data;

    DLLNode(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        int headVal = sc.nextInt();

        DLLNode head = new DLLNode(headVal);
        DLLNode current = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            DLLNode temp = new DLLNode(ele);
            current.next=temp;
            temp.prev = current;

            current = temp;

        }

        System.out.println("Original: ");
        print(head);

        System.out.println();

        head=sortDoubly(head);
        print(head);
        sc.close();
    }
    static void print(DLLNode head){
        DLLNode temp = head;
        while(temp!=null){

            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static DLLNode sortDoubly(DLLNode node){
        if(node==null||node.next==null)return node;
        DLLNode middle = tortoiseHare(node);
        DLLNode rightHead = middle.next;
        DLLNode leftHead = node;
        middle.next=null;
        rightHead.prev = null;

        leftHead = sortDoubly(leftHead);
        rightHead = sortDoubly(rightHead);

        return merge(leftHead, rightHead);
    }
    static DLLNode tortoiseHare(DLLNode head){
        DLLNode slow =head;
        DLLNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static DLLNode merge(DLLNode head1, DLLNode head2){
        DLLNode dummyNode = new DLLNode(-1);
        DLLNode temp  = dummyNode;

        DLLNode t1=head1;
        DLLNode t2 = head2;

        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                DLLNode newNode  = new DLLNode(t1.data);
                newNode.prev = temp;
                temp.next=newNode;
                temp=newNode;
                t1=t1.next;
                
            }
            else{
                DLLNode newNode  = new DLLNode(t2.data);
                newNode.prev = temp;
                temp.next=newNode;
                temp=newNode;
                t2=t2.next;

            }
        }
        if(t1!=null){
            temp.next=t1;
            t1.prev=temp;
        }
        else{
            temp.next=t2;
            t2.prev=temp;
        }

        DLLNode front = dummyNode.next;
        front.prev=null;
        dummyNode.next=null;

        return front;
    }

}