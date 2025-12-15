/*Chef gave you a string S of size N which contains only lowercase English letters and asked you to find the length of the longest substring of the string which satisfies the following condition:

Each character should appear at most f(8) times. A

Here (8) denotes the index of the character ẞ in the alphabet series. For example f(') =1,f(b)=2 and so on,

Note: A substring of a string is a contiguous subsequence of that string.

Function Declaration

Function Name

longest ValidSubstring-This function finds the length of the longest substring such that each character appears at most a limited number of times based on its alphabetical position.

Parameters

s: A reference to a string containing only lowercase English letters. Represents the input string from which the substring is selected.
Return Value

Returns an integer representing the maximum length of a valid substring where:

Each character & appears at most (p) times

f(B) is the 1-based alphabetical index of the character (e.g., a 1, b2.z26)

Constraints

1≤T≤2500

1 ≤ N ≤ 105, N≤5-105

The string contains only lowercase english letters

Input Format

First-line will contain T-the number of test cases. Then the test cases follow.

Each test case contains two lines of input.

The first line of every test case contains an integer N-the size of the string.

The second line of every test case contains a string S of size N.
Output Format

For each testcase, output in a single line - the answer to the i-th test case.

Sample 1:

Input

2

6

Output

6

3

jyjerm

4

Explanation:

Test Case 1: Every character appears less than its index in the English alphabet so we can consider the entire string.

Test Case 2: We can consider 'b' at most 2 times, therefore, the answer is 3.
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.print(longestValidSubstring(s));
        sc.close();
    }
    static int longestValidSubstring(String s) {
    // write your code here 
    int n =s.length();
    int hash[] = new int[26];
    int l=0, maxi=0,r=0;
    while(r<n){
        char ch = s.charAt(r);
        hash[ch-'a']++;
        
        while(hash[ch-'a']>((ch-'a')+1)){
            char left = s.charAt(l);
            hash[left-'a']--;
            l++;
        }
        if(r-l+1>maxi)maxi=r-l+1;
        r++;
    }
    return maxi;
}

}