import java.util.*;

class Main {
    public static String conversion(long n){
        if (n == 0) return "0";
        StringBuilder res = new StringBuilder();
        while(n>0){
            res.append(n % 2);
            n = n / 2;
        }
        res.reverse();
        return res.toString();

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        long n = sc.nextLong();
        System.out.println("Decimal to binary conversion of " + n + " is: " + conversion(n));
        sc.close();
    }
}