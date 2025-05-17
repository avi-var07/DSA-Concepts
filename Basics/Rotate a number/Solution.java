import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        System.out.println("How many times to rotate? ");
        int k = sc.nextInt();
        int count = (int)(Math.log10(num))+1;
        k=k%count;
        if(k<0)k+=count;
        int division  = (int)(Math.pow(10,k));
        int multi  = (int)(Math.pow(10,count-k));
        int remainder = num%division;
        int quotient = num/division;
        int result = remainder*multi+quotient;
        System.out.println("Rotated number is: "+result); 
        sc.close();
    }
}