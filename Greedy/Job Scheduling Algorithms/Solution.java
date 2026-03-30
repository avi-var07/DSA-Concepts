/*Given an 2D array Jobs of size Nx3, where Jobs[i][0] represents JobID , Jobs[i][1] represents Deadline , Jobs[i][2] represents Profit associated with that job. Each Job takes 1 unit of time to complete and only one job can be scheduled at a time.



The profit associated with a job is earned only if it is completed by its deadline. Find the number of jobs and maximum profit.


Example 1

Input : Jobs = [ [1, 4, 20] , [2, 1, 10] , [3, 1, 40] , [4, 1, 30] ]

Output : 2 60

Explanation : Job with JobID 3 can be performed at time t=1 giving a profit of 40.

Job with JobID 1 can be performed at time t=2 giving a profit of 20.

No more jobs can be scheduled, So total Profit = 40 + 20 => 60.

Total number of jobs completed are two, JobID 1, JobID 3.

So answer is 2 60.

Example 2

Input : Jobs = [ [1, 2, 100] , [2, 1, 19] , [3, 2, 27] , [4, 1, 25] , [5, 1, 15] ]

Output : 2 127

Explanation : Job with JobID 1 can be performed at time time t=1 giving a profit of 100.

Job with JobID 3 can be performed at time t=2 giving a profit of 27.

No more jobs can be scheduled, So total Profit = 100 + 27 => 127.

Total number of jobs completed are two, JobID 1, JobID 3.

So answer is 2 127. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][3];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter Job id: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter Job deadline: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter Job profit: ");
            arr[i][2] = sc.nextInt();
        }

        int ans[] = JobScheduling(arr);

        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }
    public static int[] JobScheduling(int[][] Jobs) {
        //your code goes here
        Arrays.sort(Jobs, (a,b)->b[2]-a[2]);
        int n =Jobs.length;
        int maxDeadline = 0;
        for(int i=0;i<n;i++)if(Jobs[i][1]>maxDeadline)maxDeadline=Jobs[i][1];

        int ans=0, count=0;
        int completed[] = new int[maxDeadline+1];
        Arrays.fill(completed, -1);
        for(int i=0;i<n;i++){
            int deadline=Jobs[i][1];
            //need to check up all the days before the deadline:
            for(int j=deadline;j>0;j--){
                if(completed[j]==-1){
                    ans+=Jobs[i][2];
                    count++;
                    completed[j]=Jobs[i][0];
                    break;
                }
            }
        }
        return new int[]{count, ans};
    }
}