/*You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        System.out.println(canJump(arr));
        sc.close();
    }
    //Boolean dp[];
    public static boolean canJump(int[] nums) {
        int n =nums.length;
        // dp =new Boolean[n];
        // return solve(nums, 0, n);

        int maxIndReached = 0;
        for(int i=0;i<n;i++){
            if(i>maxIndReached)return false; //Kya main current position tak pahunch bhi sakta hoon ya nahi?
            maxIndReached = Math.max(maxIndReached, i+nums[i]);
            if(maxIndReached>=n-1)return true;
        }
        return true;
    }
    // boolean solve(int arr[], int index, int n){
    //     if(index>=n-1)return dp[index]=true;
    //     if(dp[index]!=null)return dp[index];
    //     for(int i=1;i<=arr[index];i++){
    //         if(index+i<=n){
    //             if(solve(arr, index+i,n))return dp[index]=true;
    //         }

    //     }

    //     return dp[index]=false;
    
    // }
}