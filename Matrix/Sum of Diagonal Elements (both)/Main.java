import java.util.*;

class Main {
    public static int calculateDiagonalSum(ArrayList<ArrayList<Integer>> matrix) {
        int sum1 = 0, sum2=0;
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            sum1 += matrix.get(i).get(i); // Primary diagonal
            sum2 += matrix.get(i).get(n - i - 1); // Secondary diagonal
        }
        return sum1+sum2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the order of square matrix:");
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(n);
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }
        System.out.println("The matrix is:");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
        int diagonalSum = calculateDiagonalSum(matrix);
        System.out.println("Sum of the diagonal elements: " + diagonalSum);
        System.out.println("Sum removing the common element coming twice: " + (diagonalSum - matrix.get(n / 2).get(n / 2)));
        sc.close();
        
    }
}
