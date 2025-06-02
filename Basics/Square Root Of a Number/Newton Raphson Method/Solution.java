import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        double n = sc.nextDouble();
        double num =n;
        double epsilon = 1e-6;
        while(Math.abs(num*num-n)>epsilon)num=(num+n/num)/2;

        System.out.println("Square root is: "+num);
        sc.close();
    }
}