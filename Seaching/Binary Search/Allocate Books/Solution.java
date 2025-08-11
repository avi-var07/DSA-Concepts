/*Problem statement
Ayush is studying for ninjatest which will be held after 'N' days, And to score good marks he has to study 'M' chapters and the ith chapter requires TIME[i] seconds to study. The day in Ayush’s world has 100^100 seconds. There are some rules that are followed by Ayush while studying.

1. He reads the chapter in a sequential order, i.e. he studies i+1th chapter only after he studies ith chapter.

2. If he starts some chapter on a particular day he completes it that day itself.

3. He wants to distribute his workload over 'N' days, so he wants to minimize the maximum amount of time he studies in a day.

Your task is to find out the minimal value of the maximum amount of time for which Ayush studies in a day, in order to complete all the 'M' chapters in no more than 'N' days.

For example

if Ayush want to study 6 chapters in 3 days and the time that each chapter requires is as follows:
Chapter 1 = 30
Chapter 2 = 20
Chapter 3 = 10
Chapter 4 = 40
Chapter 5 = 5
Chapter 6 = 45

Then he will study the chapters in the following order 

| day 1 : 1 , 2 | day 2 : 3 , 4 | day 3 : 5 , 6 |
Here we can see that he study chapters in sequential order and the maximum time to study on a day is 50, which is the minimum possible in this case.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N , M <= 10 ^ 4
1 <= TIME[i] <= 10 ^ 9 
It is considered that there are infinite seconds in a day, on the planet where Ayush lives.

Time limit: 1 sec.
Sample Input 1:
1
3 5
1 2 2 3 1
Sample Output 1:
4
Explanation of sample input 1:
The ayush will read the chapter as follows,
Day 1 : 1 , 2         Time required : 3
Day 2 : 3             Time required : 2
Day 3 : 4 , 5         Time required : 4
So the maximum time in a day is 4.
Sample Input 2:
1
4 7
2 2 3 3 4 4 1 
Sample Output 2:
6
Explanation of sample input 2:
The ayush will read the chapter as follows,
Day 1 : 1 , 2          Time required : 4
Day 2 : 3 , 4          Time required : 6
Day 3 : 5              Time required : 4
Day 4 : 6 , 7          Time required : 5
So the maximum time in a day is 6. */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of chapters: ");
        int m = sc.nextInt();
        System.out.println("Enter " + m + " elements:");
        int time[] = new int[m];
        for(int i = 0; i < m; i++) 
        time[i] = sc.nextInt();
        
        System.out.println("Enter number of days: ");
        int n = sc.nextInt();

        System.out.println("Minimum of the maximum books to allocate is: "+ayushGivesNinjatest(n, m, time));
        
        sc.close();
    }
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        long maxi = time[0];
        long sum=0;
        for(int ele: time){
            if(ele>maxi)maxi=ele;
            sum+=ele;
        }

        while(maxi<=sum){
            long mid = maxi+(sum-maxi)/2;
            if(allocate(time, mid)>n)maxi=mid+1;
            else sum = mid-1;
        }
        return maxi;


    }
    static long allocate(int time[], long n){
        long chapStudent = 0;
        int day=1;
        for(int i=0;i<time.length;i++){
            if(chapStudent+time[i]<=n)
            chapStudent+=time[i];
            else{
                day++;
                chapStudent = time[i];
            }
        }
        return day;
    }
}