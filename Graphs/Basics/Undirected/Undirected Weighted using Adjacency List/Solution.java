import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int m = sc.nextInt();
        System.out.println("Enter "+m+" edges: ");
        ArrayList<ArrayList<Pair>>arr = new ArrayList<>();

        for(int i = 0;i<=n;i++)arr.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr.get(u).add(new Pair(v, w));
            arr.get(v).add(new Pair(u, w));
        }

        System.out.println("Graph is: ");
        for(int i=1;i<=n;i++){
            System.out.print(i+"->");
            for(int j=0;j<arr.get(i).size();j++)System.out.print(arr.get(i).get(j)+" ");
            System.out.println();
        }
        sc.close();
    }
}
class Pair{
    int node;
    int weight;

    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

