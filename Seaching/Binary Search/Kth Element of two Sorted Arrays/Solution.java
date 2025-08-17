/*Problem statement
Ninja wants to serve food to needy people. So, he bought Ladoos from a sweet shop and placed them on plates. There can be any number of Ladoos present in a plate.

Plates containing Ladoos are placed in two rows. Each row is sorted in increasing order by the number of Ladoos in a plate.

For example :
‘ROW1’ :  [2, 5, 8, 17] and  ‘ROW2’ :  [1, 4, 8, 13, 20]
Now people come one by one in a line to take plates of Ladoos from Ninja. Ninja picks the two plates in front, one from each row and gives that plate to people in which the number of ladoos is the smallest (if both plates contain equal numbers of ladoos then he serves any plate from the two plates) and places the other plate back to its position.

For Example :
If ‘ROW1’ is [2, 5, 8, 17] and ‘ROW2’ is [1, 4, 8, 13, 20], then Ninja picks the first plates from each rows, plate containing 2 ladoos from ‘ROW1’ and a plate containing 1 ladoo from ‘ROW2’. 
Then he gives the plate with 1 Ladoo to the first person in line and places the other plate back to its position.
Can you tell how many ladoos the ‘K'th’ person will get?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 100
1 <= N, M, K <= 10^5
K <= (N + M)
0 <= ROW1[i], ROW2[i] <= 10^5

where ROW1[i] and ROW2[i] denote the number of Ladoos in i’th plates of ROW1 and ROW2 respectively.

Time Limit: 1 second
Sample Input 1 :
2
5 4 3
3 11 23 45 52
4 12 14 18
1 1 2
1
2
Sample Output 1 :
11
 2
Explanation for Sample Output 1 :
For sample test case 1: 
1’st person will get 3 ladoos i.e a minimum of 3 and 4. Now  ‘ROW1’ :  [11, 23, 45, 52] and  ‘ROW2’ :  [4, 12, 14, 18].
2’nd person will get 4 ladoos i.e minimum of 11 and 4. Now  ‘ROW1’ :  [11, 23, 45, 52] and  ‘ROW2’ :  [12, 14, 18].
3’rd person will get 11 ladoos i.e minimum of 11 and 12. 

 For sample test case 2: 
1’st person will get 1 ladoos i.e a minimum of 1 and 2. Now  ‘ROW1’ :  [ ] and  ‘ROW2’ :  [2].
2’st person will get 2 ladoos because we have only one element left in ROW2 . Now  ‘ROW1’ :  [] and  ‘ROW2’ :  [].
Sample Input 2 :
2
5 3
1 3 6 7 10
3 5 5 7
3 3 2
10 20 20
1 2 3 
Sample Output 2 :
3 
2
Explanation for Sample Output 2 :
For sample test case 1: 
1’st person will get 1 ladoo i.e minimum of 1 and 3. Now  ‘ROW1’ :  [3, 7, 10] and  ‘ROW2’ :  [3, 5, 5, 7].
2’nd person will get 3 ladoos i.e now from both rows we will get a plate of 3 ladoos so Ninja can give any one plate containing ladoos from each row. Let us assume Ninja give a plate from ‘ROW2’. Now  ‘ROW1’ :  [3, 7, 10] and  ‘ROW2’ :  [5, 5, 7].
3’rd person will get 3 ladoos i.e minimum of 3 and 5. Now  ‘ROW1’ :  [7, 10] and  ‘ROW2’ :  [5, 5, 7].

For sample test case 2: 
1’st person will get 1 ladoo i.e minimum of 10 and 1. Now  ‘ROW1’ :  [10, 20, 30] and  ‘ROW2’ :  [ 2, 3].
2’nd person will get 2 ladoos i.e  minimum of 10 and 2. Now  ‘ROW1’ :  [10, 20, 30] and  ‘ROW2’ :  [3].
 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of first array: ");
        int m = sc.nextInt();
        System.out.println("Enter " + m + " elements:");
        int arr1[] = new int[m];
        for(int i = 0; i < m; i++) 
        arr1[i] = sc.nextInt();
        System.out.println("Enter number of elements of second array: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr2[] = new int[m];
        for(int i = 0; i < n; i++) 
        arr2[i] = sc.nextInt();

        System.out.println("Enter the value of k: ");
        System.out.println("Kth element is: "+ninjaAndLadoos(arr1, arr2, m, n, n));
        
        
        sc.close();
    }
    public static int ninjaAndLadoos(int nums1[], int nums2[], int m, int n, int k) {
        // Write your code here.
        if(m>n)return ninjaAndLadoos(nums2, nums1, n , m, k);
        int low = Math.max(0, k-n);
        int high = Math.min(k,m);
        int left = k;
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1=(mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<m)?nums1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n)?nums2[mid2]:Integer.MAX_VALUE;
            if(l1<=r2&&l2<=r1)return Math.max(l1, l2);
            else if(l1>r2)high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}