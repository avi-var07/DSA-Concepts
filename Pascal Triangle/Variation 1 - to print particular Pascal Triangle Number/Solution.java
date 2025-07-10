//Brute Force is nCr is n!/r!*(n-r)! where n and r will be n-1 and r-1 which is the row-1Ccol-1;
//Optimal is: 10C3 = 10*9*8/1*2*3;

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row number of the element to fetch: ");
        int row = sc.nextInt();

        System.out.println("Enter the column number of the element to fetch: ");
        int col = sc.nextInt();

        long res = generateElement(row-1, col-1);
        System.out.println(res);
        sc.close();
    }
    static long generateElement(int n, int r){
        long res= 1;
        for(int i=0;i<r;i++){
            res = res*(n-i);
            res = res/(i+1);

        }
        return res;
    }
}