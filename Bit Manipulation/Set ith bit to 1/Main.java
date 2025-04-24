import java.util.*;

class Main {
    public static int setToOne(int n, int i){
        return n | (1<<i);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be set:");
        int n = sc.nextInt();
        System.out.println("Enter the bit position to be set:");
        int i = sc.nextInt();
        System.out.println("Number after setting the bit: " + setToOne(n, i));
        sc.close();
    }
}