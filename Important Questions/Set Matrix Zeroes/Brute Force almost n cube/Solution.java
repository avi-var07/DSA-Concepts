/*Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution? */


//whenever you find 0, mark the row and column with -1, then traverse again and wherever find -1, mark 0;

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int n = sc.nextInt();
        System.out.println("Enter elements of the matrix:");
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }
        
        setZeroes(arr);
        
        for(int i = 0; i < m; i++) {
            for(int j=0;j<n;j++)
            System.out.print(arr[i][j]+" ");

            System.out.println();
        }

        
        sc.close();
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    markRow(i,matrix, n);
                    markColumn(j,matrix, m);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)matrix[i][j]=0;
            }
        }
    }
    static void markRow(int row, int matrix[][], int cols){
        for(int j=0;j<cols;j++){
            if(matrix[row][j]!=0)matrix[row][j]=-1;
        }
    }
    static void markColumn(int col, int matrix[][], int rows){
        for(int i=0;i<rows;i++){
            if(matrix[i][col]!=0)matrix[i][col]=-1;
        }
    }
}