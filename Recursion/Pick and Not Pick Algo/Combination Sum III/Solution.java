/*Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Enter k: ");
        int k  =sc.nextInt();
        List<List<Integer>>ans = combinationSum3(k, n);
        for(var ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();

        solve(1,k,n,ds,ans);
        return ans;
    }
    static void solve(int i, int k, int n, List<Integer>ds, List<List<Integer>>ans){
        if(n==0&&k==0){
            ans.add(new ArrayList<>(ds));
            return;

        }
        if(i>9)return;
        if(n<0||k<0)return;

        ds.add(i);
        solve(i+1, k-1,n-i,ds,ans);
        ds.remove(ds.size()-1);
        solve(i+1, k,n,ds,ans);
        
    }
}