//Brute Force is: for each row using the nCr formula generte:

// List<Integer> list = new ArrayList<>();
// for(int i=1;i<=row;i++){
//     int ele = nCR(row-1, i-1);
//     list.add(ele);
// }
// static int nCR(int n, int r){
//     long ans = 1;
//     for(int i=0;i<r;i++){
//         ans = ans*(n-i);
//         ans = ans/(i+1);
//     }
//     return (int)ans;
// }

//TC of the above is O(n*r)

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row number to print of the pascal's triangle: ");
        int n = sc.nextInt();

        long ans= 1;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int col=1;col<n;col++){
            ans = ans*(n-col);
            ans = ans/col;
            result.add((int)ans);
        }
        
        for(int ele: result)
        System.out.print(ele+" ");
        sc.close();
    }
}
//above approach is : ans*(row-col)/col;