//Approach is Transpose and then reverse column wise

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n = sc.nextInt();
        System.out.println("Enter " + (n*n) + " elements:");
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }

        inplaceRotate(arr, n);

        System.out.println("After Rotating the Matrix by 90 degrees anticlockwise: ");

        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++)
            System.out.print(arr[i][j]+" ");

            System.out.println();
        }


        
        sc.close();
    }
   public static void inplaceRotate(int[][] arr, int n) {
		// Write your code here.
		for(int i=0;i<n;i++){
			for(int j = i+1;j<n;j++){
				int temp =arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
		for(int j=0;j<n;j++){
			int left = 0, right = n-1;
			while(left<right){
				int temp = arr[left][j];
				arr[left][j]=arr[right][j];
				arr[right][j]=temp;
				left++;
				right--;
			}
		}
	}
}