import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Vertices: ");
        int V = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        ArrayList<Integer>ans = topologicalSort(V, arr);
        for(int ele: ans)System.out.print(ele+ " ");
    
        sc.close();
    }
    static ArrayList<Integer> topologicalSort(int V, int edges[][]){

        int indegree[] = new int[V];

        ArrayList<ArrayList<Integer>>adj  = new ArrayList<>();

        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer>queue = new LinkedList<>();

        for(int i=0;i<V;i++)if(indegree[i]==0)queue.add(i);

        while(!queue.isEmpty()){
            int ele = queue.poll();
            ans.add(ele);

            for(int neighbor: adj.get(ele)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0)queue.add(neighbor);
            }
        }
        return ans;
    }
    
}