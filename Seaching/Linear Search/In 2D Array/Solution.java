import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int matrix[][] = {{2,3,4,5},{6,7,8,9,10},{11,12,13,14,15,16,17}};
        //Printing:

        int rows = matrix.length;   //This gives total rows
        for(int i=0;i<rows;i++){
            System.out.print("Row " + i + " has " + matrix[i].length + " columns");
            System.out.println();
            System.out.println("Elements in the row: ");
            for(int j=0;j<matrix[i].length;j++)
            System.out.print(matrix[i][j]+" ");
            

            System.out.println();
        }

        sc.close();
    }
}