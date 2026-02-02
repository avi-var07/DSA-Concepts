import java.util.*;

class Solution{
    static Integer dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        dp = new Integer[n+1];

        System.out.println(fibo(n));
        sc.close();
    }
    static int fibo(int n){
        if(n<=1)return n;

        if(dp[n]!=null)return dp[n];

        return dp[n] = fibo(n-1)+fibo(n-2);
    }
}   