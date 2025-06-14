import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start range: ");
        int start = sc.nextInt();
        System.out.println("Enter end range: ");
        int end = sc.nextInt();
        System.out.println("Prime Numbers in the range are: ");
        for(int i=start; i<=end;i++){
            int count=0;
            for(int j=2;j*j<=i;j++)if(i%j==0){
                count++;
                break;
            }
            if(count==0)
            System.out.print(i+" ");
        }
        sc.close();
    }
}