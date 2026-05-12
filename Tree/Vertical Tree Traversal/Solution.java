import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;

    int val;

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=null;
        this.right=null;
    }
    TreeNode(int val){
        this.val=val;
    }
}
class Solution{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        TreeNode root=null;

        System.out.println("Enter "+n+" Elements: ");
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            root=sol.insert(root, val);
        }

        List<List<Integer>>ans = sol.verticalTraversal(root);
        for(List<Integer>ele: ans)System.out.println(ele+" ");
        sc.close();
    }
    public TreeNode insert(TreeNode root, int val){
        if(root==null)return new TreeNode(val);

        if(root.val<val)root.right =insert(root.right, val);
        else root.left=insert(root.left, val);

        return root;

    }
    public void inorder(TreeNode root){
        if(root==null)return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);

    }
    class Pair{
        TreeNode  node;
        int hd;
        Pair(TreeNode node, int hd){
            this.node=node;
            this.hd = hd;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        Map<Integer, List<Integer>>map = new TreeMap<>();
        Queue<Pair>queue= new LinkedList<>(); 
         
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair  p =queue.poll();
            TreeNode node =p.node;
            int hd = p.hd;

            if(!map.containsKey(hd))map.put(hd, new ArrayList<>());
            map.get(hd).add(node.val);

            if(node.left!=null)queue.add(new Pair(node.left, hd-1));
            if(node.right!=null)queue.add(new Pair(node.right, hd+1));


        }
        for(List<Integer>ele: map.values())ans.add(ele);

        return ans;
    }
}