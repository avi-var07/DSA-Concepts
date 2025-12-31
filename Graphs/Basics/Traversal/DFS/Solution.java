import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        
        System.out.println("Enter number of edges: ");
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
    /*Printing Adjacency List

        for(int i=1;i<=n;i++){
            System.out.print(i+" ->");
            for(int j=0;j<adj.get(i).size();j++)System.out.print(adj.get(i).get(j)+" ");

            System.out.println();
        }

    */

        ArrayList<Integer>bfs = DFS(adj);

        for(var ele: bfs)System.out.print(ele+" ");
        sc.close();
    }
    static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>>adj){

        int V = adj.size(); //no of nodes nikalne ka trika
        boolean visited[] = new boolean[V];
        visited[1]=true;

        ArrayList<Integer>list = new ArrayList<>();
        dfs(1,list,visited,adj);
        
        return list;
    }
    static void dfs(int node, ArrayList<Integer>list, boolean visited[], ArrayList<ArrayList<Integer>>adj){
        visited[node]=true;
        list.add(node);

        for(var ele: adj.get(node)){
            if(!visited[ele])dfs(ele,list, visited,adj);
        }
    }
}