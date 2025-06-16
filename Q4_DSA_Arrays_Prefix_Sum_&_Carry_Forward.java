/*Problem Description

You have given a string A having Uppercase English letters.

You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.



Problem Constraints

1 <= length(A) <= 105



Input Format

First and only argument is a string A.



Output Format

Return an long integer denoting the answer.



Example Input

Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"


Example Output

Output 1:

 3
Output 2:

 0


Example Explanation

Explanation 1:



 Subsequence "AG" is 3 times in given string, the pairs are (0, 3), (0, 5) and (4, 5). 
Explanation 2:

 There is no subsequence "AG" in the given string. */
public class Q4_DSA_Arrays_Prefix_Sum_&_Carry_Forward {
    public long solve(String A) {

        long count_of_a=0;
        long count_of_pairs=0;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='A')
                count_of_a++;
            else if(A.charAt(i)=='G')
                count_of_pairs+=count_of_a;
        }


        return count_of_pairs;
    }
}
