import java.util.*;

class Node{

    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Solution{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes: (-1 for stop)");
        Node root = buildTree(sc);
        sc.close();
    }
    static Node buildTree(Scanner sc){
        int val = sc.nextInt();

        if(val==-1)return null;

        Node root= new Node(val);

        root.left=buildTree(sc);
        root.right=buildTree(sc);

        return root;
    }
    
}