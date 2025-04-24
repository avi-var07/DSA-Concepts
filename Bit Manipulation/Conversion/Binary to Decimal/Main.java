import java.util.*;

class Main {
    public static int conversion(String n){
        int len = n.length();
        int num=0, p=1;
        for(int i=len-1;i>=0;i--){
            if(n.charAt(i)=='1')num+=p;
            p*=2;
        }
        return num;

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        String n = sc.nextLine();
        System.out.println("Binary to decimal conversion of " + n + " is: " + conversion(n));
        sc.close();
    }
}