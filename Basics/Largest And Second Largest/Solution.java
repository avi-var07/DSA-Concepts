import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            System.out.println("Enter "+n+" elements: ");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int maxi = 0, secondMaxi = 0;

            for (int num : a) {
                if (num > maxi) {
                    secondMaxi = maxi;
                    maxi = num;
                } 
                else if (num > secondMaxi && num != maxi) secondMaxi = num;
                
            }

            System.out.println("Sum of maximum and second maximum unique element in the array is: "+(maxi+secondMaxi));
        }

        sc.close();
    }
}
