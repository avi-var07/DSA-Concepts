/*You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertices u and v.

Your task is to find the shortest path distance from a given source vertex src to all other vertices in the graph.
If a vertex is not reachable from the source, return -1 for that vertex.


Note: All edges have unit weight (1).

Examples :

Input: V = 9, E = 10, 
edges[][] = [[0, 1], [0, 3], [1, 2], [3, 4], [4, 5], [2, 6], [5, 6], [6, 7], [6, 8], [7, 8]], src = 0
Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]

Input: V = 4, E = 2,
edges[][]= [[0, 3], [1, 3]], src = 3
Output: [1, 1, -1, 0]

Constraints:
1 ≤ V ≤ 104
0 ≤ E ≤ V*(V-1)/2
0 ≤ edges[i][0], edges[i][1] < V

 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V = sc.nextInt();
        System.out.println("Enter E: ");
        int E= sc.nextInt();
        
        int edges[][] = new int[E][2];

        for(int i=0;i<E;i++){
            System.out.println("Enter u: ");
            int u=sc.nextInt();
            System.out.println("Enter v: ");
            int v=sc.nextInt();
            
            edges[i][0]=u;
            edges[i][1]=v;
        }

        int ans[] = shortestPath(V, edges, E);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        int dist[] = new int[V];
        Arrays.fill(dist, -1);
        dist[src]=0;
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            int initial = dist[node];
            for(int ele: adj.get(node)){
                int wt=1;
                if(dist[ele]==-1||dist[ele]>initial+1){
                    dist[ele]=initial+wt;
                    queue.add(ele);
                }
            }
        }
        
        
        return dist;
    }
}