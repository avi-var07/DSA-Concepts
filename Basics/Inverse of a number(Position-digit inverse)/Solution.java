import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int inverse = 0;
        int originalPosition =1;
        while(n!=0){
            int originalDigit = n%10;
            int inversePosition = originalDigit;
            int inverseDigit  = originalPosition;
            inverse+=inverseDigit*(int)(Math.pow(10, inversePosition-1));
            n/=10;
            originalPosition++;
        }
        System.out.println("Inverse of the number based on position and digit inversion is: "+inverse);
        sc.close();
    }
}