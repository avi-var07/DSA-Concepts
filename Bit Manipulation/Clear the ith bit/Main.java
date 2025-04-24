import java.util.*;

class Main {
    public static int clearTheBit(int n, int i){
        return n & ~(1<<i);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        System.out.println("Enter the bit position to clear (set the ith bit to 0):");
        int i = sc.nextInt();
        System.out.println("Number after clear the bit: " + clearTheBit(n, i));
        sc.close();
    }
}