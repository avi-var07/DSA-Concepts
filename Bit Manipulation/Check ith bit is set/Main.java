import java.util.*;

class Main {
    public static boolean check(int n, int i){
        return (n&(1<<i))!=0;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check: ");
        int n = sc.nextInt();
        System.out.println("Enter the bit position to check: ");
        int i = sc.nextInt();
        if(check(n, i))System.out.println("Bit is set");
        else System.out.println("Bit is not set");
        sc.close();
    }
}