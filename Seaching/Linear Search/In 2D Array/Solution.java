import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // int matrix[][] = {{2,3,4,5},{6,7,8,9,10},{11,12,13,14,15,16,17}};
        // //Printing:

        // int rows = matrix.length;   //This gives total rows
        // for(int i=0;i<rows;i++){
        //     System.out.print("Row " + i + " has " + matrix[i].length + " columns"); //Column in each row
        //     System.out.println();
        //     System.out.println("Elements in the row: ");
        //     for(int j=0;j<matrix[i].length;j++)
        //     System.out.print(matrix[i][j]+" ");
            

        //     System.out.println();
        // }

        // //Using user input & printing matrix:
        // System.out.println("Enter number of rows: ");
        // int r = sc.nextInt();
        // System.out.println("Enter number of columns: ");
        // int c = sc.nextInt();

        // int arr1[][]=new int[r][c];
        // System.out.println("Enter elements: ");
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++)
        //     arr1[i][j]=sc.nextInt();
        // }
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++)
        //     System.out.print(arr1[i][j]+" ");

        //     System.out.println();
        // }


        // //For square matrix : r=n,c=n, n= size of square matrix

        // //If there is a matrix given, to find rows and columns:

        // //rows = matrix.length, columns k liye loop lagao, for(int i=0;i<rows;i++){for(int j=0;j<matrix[i].length;j++)}
        System.out.println("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int c = sc.nextInt();
        int matrix[][]=new int[r][c];
        System.out.println("Enter the elements: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            matrix[i][j]=sc.nextInt();
        }
        
        System.out.println("The matrix is: ");
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            System.out.print(matrix[i][j]+" ");

            System.out.println();
        }

        System.out.println();

        //Applying Linear Search:
        boolean found= false;
        System.out.println("Enter the element to search: ");
        int target = sc.nextInt();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==target){
                    found=true;
                    System.out.println("Element found at row "+i+" column "+j);
                }
            }
        }

        if(!found)
        System.out.println("Not present!");
        


        sc.close();
    }
}