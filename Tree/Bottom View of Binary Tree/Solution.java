import java.util.*;

class Node{
    Node left;
    Node right;

    int val;

    Node(int val){
        this.val=val;
    }
}
class Solution{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        Node root=null;

        System.out.println("Enter "+n+" Elements: ");
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            root=sol.insert(root, val);
        }

        ArrayList<Integer>ans = sol.bottomView(root);
        System.out.println(ans);
        sc.close();
    }
    public Node insert(Node root, int val){
        if(root==null)return new Node(val);

        if(root.val<val)root.right =insert(root.right, val);
        else root.left=insert(root.left, val);

        return root;

    }
    public void inorder(Node root){
        if(root==null)return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);

    }
    class Pair{
        Node node;
        int hd;
        
        Pair(Node node, int hd){
            
            this.hd=hd;
            this.node =node;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        Map<Integer, Integer>map = new TreeMap<>();
        
        Queue<Pair>queue = new LinkedList<>();
        
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node node = p.node;
            int hd = p.hd;
            
            map.put(hd, node.val);
            
            if(node.left!=null)queue.add(new Pair(node.left, hd-1));
            if(node.right!=null)queue.add(new Pair(node.right, hd+1));
        }
        for(int ele: map.values())ans.add(ele);
        
        return ans;
    }
}