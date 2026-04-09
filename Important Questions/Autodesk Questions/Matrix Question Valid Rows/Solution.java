/*🟦 Problem: Valid Row and Column Subsequences
🧩 Description

You are given a 2D grid of size m x n where each cell contains either:

an integer (represented as a string), or
a sign "+" or "-"

A row or column is considered valid if there exist three indices i < j < k such that:

grid[i] → integer  
grid[j] → "+" or "-"  
grid[k] → integer

The three elements do not need to be contiguous, but must follow the order integer → sign → integer.

Each row or column is counted at most once, even if multiple such subsequences exist.

📥 Input
grid: a 2D array of strings of size m x n
📤 Output
Return the total number of valid rows and columns
🧪 Example 1
Input
grid = [
  ["1", "+", "2"],
  ["+", "3", "-"],
  ["4", "-", "5"]
]
Output
4
Explanation

Rows:

Row 0 → 1 → + → 2 ✅
Row 1 → no valid sequence ❌
Row 2 → 4 → - → 5 ✅

👉 valid rows = 2

Columns:

Col 0 → 1, +, 4 → 1 → + → 4 ✅
Col 1 → +, 3, - ❌
Col 2 → 2, -, 5 → 2 → - → 5 ✅

👉 valid columns = 2

👉 Total = 4

🔒 Constraints
1 ≤ m, n ≤ 1000
Each grid[i][j] is either:
an integer string, or
"+" or "-"
💡 Hint

You just need to check:

Is there:
one integer → then a sign → then an integer (after it)? */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m =sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n =sc.nextInt();
        String arr[][] = new String[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[i][j]=sc.next();
        }

        System.out.println(valid(arr, m, n));
        sc.close();
    }
    static int valid(String arr[][], int m, int n){
        int cnt=0;
        String arr2[][] = new String[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)arr2[i][j]=arr[j][i];
        }
        
        for(int i=0;i<m;i++)cnt+=checkRow(arr[i]);
        for(int i=0;i<n;i++)cnt+=checkCol(arr[i]);
        return cnt;
    }
    static int checkRow(String arr[]){
        int n =arr.length;
        int cnt=0;
        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k=j+1;k<=n-1;k++){
                    if(Character.isDigit(arr[i].charAt(0))&&Character.isDigit(arr[k].charAt(0))&&(arr[j].equals("+")||arr[j].equals("-")))cnt++;
                }
            }
        }
        return cnt;
    }
    static int checkCol(String arr[]){
        int n =arr.length;
        int cnt=0;
        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k=j+1;k<=n-1;k++){
                    if(Character.isDigit(arr[i].charAt(0))&&Character.isDigit(arr[k].charAt(0))&&(arr[j].equals("+")||arr[j].equals("-")))cnt++;
                }
            }
        }
        return cnt;
    }
}
