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
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++)dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }
}   