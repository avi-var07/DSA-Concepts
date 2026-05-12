
/*You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Note:

Return the nodes from the leftmost node to the rightmost node.
If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view. 
Examples:

Input: root = [1, 2, 3]
Output: [2, 1, 3]
Explanation: The Green colored nodes represents the top view in the below Binary tree.
 
Input: root = [10, 20, 30, 40, 60, 90, 100]
Output: [40, 20, 10, 30, 100]
Explanation: The Green colored nodes represents the top view in the below Binary tree.


Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

 */
import java.util.*;

class Node {
    Node left;
    Node right;

    int data;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        Node root = null;

        System.out.println("Enter " + n + " Elements: ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = sol.insert(root, val);
        }

        ArrayList<Integer>ans = sol.topView(root);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }

    public Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (root.data < val)
            root.right = insert(root.right, val);
        else
            root.left = insert(root.left, val);

        return root;

    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }
    class Pair{
        Node node;
        int hd;
        
        Pair(Node node, int hd){
            this.hd = hd;
            this.node = node;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<Pair>queue = new LinkedList<>();
        
        queue.add(new Pair(root, 0));
        Map<Integer, Integer>map = new TreeMap<>(); //order important
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node curr = p.node;
            int hd = p.hd;
            if(!map.containsKey(hd))map.put(hd, curr.data);
            if(curr.left!=null)queue.add(new Pair(curr.left, hd-1));
            if(curr.right!=null)queue.add(new Pair(curr.right, hd+1));
            
            
        }
        
        for(int ele: map.values())ans.add(ele);
        
        return ans;
        
    }
}