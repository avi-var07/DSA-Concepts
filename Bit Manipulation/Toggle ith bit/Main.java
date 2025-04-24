import java.util.*;

class Main {
    public static int ToggleTheBit(int n, int i){
        return n ^(1<<i);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        System.out.println("Enter the bit position to toggle:");
        int i = sc.nextInt();
        System.out.println("Number after setting toggling: " + ToggleTheBit(n, i));
        sc.close();
    }
}