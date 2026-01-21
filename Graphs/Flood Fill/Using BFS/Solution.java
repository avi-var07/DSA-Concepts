/*You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

 

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation:



From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

Output: [[0,0,0],[0,0,0]]

Explanation:

The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.

 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter "+n*m+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println("Enter starting row: ");
        int srow = sc.nextInt();
        System.out.println("Enter starting column: ");
        int scol = sc.nextInt();
        System.out.println("Enter new color you want: ");
        int color = sc.nextInt();

        int ans[][] = floodFill(arr, srow, scol, color);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)System.out.print(ans[i][j]+" ");
            System.out.println();
        }
        sc.close();
    }
    static class Pair{
        int row, col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
     public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        if(prevColor==newColor)return image;
        bfs(image, sr, sc,newColor, image.length, image[0].length, prevColor);
        return image;
    }
    static void bfs(int arr[][], int sr, int sc, int newColor, int m, int n, int prevColor){
        
        Queue<Pair>queue = new LinkedList<>();
        arr[sr][sc] = newColor;
        queue.add(new Pair(sr, sc));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r = p.row;
            int c = p.col;        
            if(r-1>=0&&arr[r-1][c]==prevColor){
                arr[r-1][c] = newColor;
                queue.add(new Pair(r-1,c));
            }
            
            if(r+1<m&&arr[r+1][c]==prevColor){
                arr[r+1][c] = newColor;
                queue.add(new Pair(r+1,c));
            }
            
            if(c-1>=0&&arr[r][c-1]==prevColor){
                arr[r][c-1] = newColor;
                queue.add(new Pair(r,c-1));
            }
            
            if(c+1<n&&arr[r][c+1]==prevColor){
                arr[r][c+1] = newColor;
                queue.add(new Pair(r,c+1));
            }
            
        }
        
    }
}
