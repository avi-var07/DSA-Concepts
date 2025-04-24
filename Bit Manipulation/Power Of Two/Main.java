import java.util.*;

class Main {
    public static boolean checkPowerOfTwo(int n){
        return (n&(n-1))==0;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check:");
        int n = sc.nextInt();
        if(checkPowerOfTwo(n))System.out.println("True");
        else System.out.println("False");
        sc.close();
    }
}