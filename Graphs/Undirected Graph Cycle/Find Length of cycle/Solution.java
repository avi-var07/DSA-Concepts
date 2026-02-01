import java.util.*;

class Solution{
    static int len = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Nodes: ");
        int V = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();

        List<List<Integer>>adj = new ArrayList<>();

        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            System.out.println("Enter u: ");
            int u = sc.nextInt();
            System.out.println("Enter v: ");
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        findCycleLength(V, adj);
        if(len==-1)System.out.println("No cycle");
        else System.out.println(len);
        sc.close();
    }
    static void findCycleLength(int V, List<List<Integer>>adj ){
        boolean visited[] = new boolean[V];

        int level[] = new int[V];
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i, -1, visited, adj, 0, level);
        }

    }
    static void dfs(int node, int parent, boolean visited[], List<List<Integer>>adj, int depth, int level[]){
        visited[node]=true;
        level[node]=depth;
        for(int ele: adj.get(node)){
            if(!visited[ele])dfs(ele, node, visited, adj, depth+1, level);
            else if(parent!=ele&&len==-1)len = level[node]-level[ele]+1;
        }
    }
}