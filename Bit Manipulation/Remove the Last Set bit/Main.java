import java.util.*;

class Main {
    public static int removeLastSetBit(int n){
        return n&(n-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        System.out.println("Number after unsetting the last set bit (rightmost): " + removeLastSetBit(n));
        sc.close();
    }
}