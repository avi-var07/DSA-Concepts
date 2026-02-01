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

        }

        findCycleLength(V, adj);
        if(len==-1)System.out.println("No cycle");
        else System.out.println(len);
        sc.close();
    }
    static void findCycleLength(int V, List<List<Integer>>adj ){
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];

        int level[] = new int[V];
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i,visited, adj, 0, level, path);
        }

    }
    static void dfs(int node, boolean visited[], List<List<Integer>>adj, int depth, int level[], boolean path[]){
        visited[node]=true;
        path[node]=true;
        level[node]=depth;
        for(int ele: adj.get(node)){
            if(!visited[ele])dfs(ele, visited, adj, depth+1, level, path);
            else if(path[ele]&&len==-1)len = level[node]-level[ele]+1;
        }
        path[node]=false;
    }
}