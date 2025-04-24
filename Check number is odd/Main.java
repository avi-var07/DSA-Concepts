import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it is odd or not: ");
        int n = sc.nextInt(); 
        n&=1;
        if(n==1)System.out.println("Odd Number");
        else System.out.println("Even Number");
        sc.close();
    }
}