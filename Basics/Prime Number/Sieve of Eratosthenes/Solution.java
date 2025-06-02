import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the end range: ");
        int n  = sc.nextInt();
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=1;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i)
                isPrime[j]=false;

            }
        }

        for(int i=2;i<=n;i++)
        if(isPrime[i])System.out.print(i+" ");
        sc.close();
    }
}