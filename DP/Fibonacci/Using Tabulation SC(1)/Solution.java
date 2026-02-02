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
        int prev1=1, prev2=0;

        for(int i=2;i<=n;i++){
            int curr = prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}   