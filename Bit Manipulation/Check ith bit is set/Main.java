import java.util.*;

class Main {
    public static boolean checkByLeftShift(int n, int i){
        return (n&(1<<i))!=0;
    }
    public static boolean checkByRightShift(int n, int i){
        return ((n>>i)&1)!=0;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check: ");
        int n = sc.nextInt();
        System.out.println("Enter the bit position to check: ");
        int i = sc.nextInt();
        if(checkByLeftShift(n, i))System.out.println("Bit is set");
        else System.out.println("Bit is not set");
        if(checkByRightShift(n, i))System.out.println("True");
        else System.out.println("False");
        sc.close();
    }
}