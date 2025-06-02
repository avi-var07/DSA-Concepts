import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();

        int start = 1, end = n, ans = 0;

        if (n == 0 || n == 1) {
            System.out.println("Square Root is: " + n);
            System.exit(0);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((long)mid * mid == n) {
                ans = mid;
                break;
            } else if ((long)mid * mid < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("Square root is: " + ans);
        sc.close();
    }
}
