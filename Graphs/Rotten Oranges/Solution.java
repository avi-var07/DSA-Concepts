/*Medium
Topics
premium lock icon
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2. */


import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of col: ");
        int n = sc.nextInt();
        int arr[][] = new int[m][n];

        System.out.println("Enter "+(n*m)+" elements");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        System.out.println(orangesRotting(arr));
        sc.close();
    }
    static class Pair{
        int row, col, time;
        Pair(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time = time;
        }
    }
    public static int orangesRotting(int[][] grid) {
        int countFresh = 0;
        int m = grid.length;
        int n= grid[0].length;

        int vis[][] = new int[m][n];
        Queue<Pair>queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    queue.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1)countFresh++;
                else vis[i][j]=0;
            }
        }
        int ans = 0;
        
        int drow[] = {-1,0,1,0};    //up right down left
        int dcol[] = {0,1,0,-1}; //up right down left
        int cntFreshVis = 0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r = p.row;
            int c= p.col;
            int t = p.time;
            ans = Math.max(ans, t);
            
            for(int i=0;i<4;i++){
                int row = r+drow[i]; //initial row+delta row, similiar to arr[r-1][c] for up
                int col = c+dcol[i];
                if(row>=0&&row<m&&col>=0&&col<n&&vis[row][col]!=2&&grid[row][col]==1){
                    queue.add(new Pair(row, col, t+1));
                    vis[row][col] = 2;
                    cntFreshVis++;
                }
            }
        }
        if(cntFreshVis!=countFresh)return -1;
            
        return ans;
    }
}