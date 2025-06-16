/*Problem Description

You are given:
An integer array A representing the array of numbers of size N.
A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1], representing the range [L, R].

For each query in B, calculate the sum of elements in A at EVEN indices within the specified range [L, R] and return the results as an array.


Problem Constraints

1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
1 <= Q <= 10^5
0 <= B[i][0], B[i][1] < N
B[i][0] <= B[i][1].


Input Format

First Argument A, is a list of integers representing the array.
Second Argument B, is a 2D list where each sublist B[i]=[L,R] contains two integers L and R, representing the range for the query.


Output Format

Return a list of integers where each integer is the result of the sum of elements at even indices in the range [L, R] for each query.


Example Input

Input 1:
A = [2, 8, 3, 9, 15]
B = [ [1, 4], 
      [0, 2], 
      [2, 3] ]
Input 2:
A = [5, 15, 25, 35, 45]
B = [ [1, 1], 
      [0, 0] ]


Example Output

Output 1:
[18, 5, 3]
Output 2:
[0, 5]


Example Explanation

Explanation 1:
Query 1: [1, 4] -> Sum = A[2] + A[4] = 3 + 15 = 18
Query 2: [0, 2] -> Sum = A[0] + A[2] = 2 + 3 = 5
Query 3: [2, 3] -> Sum = A[2] = 3 

Thus [18, 5, 3] is the Result.
Explanation 2:
Query 1: [1, 1] -> Sum = 0
Query 2: [0, 0] -> Sum = A[0] = 5

Thus [0, 5] is the result. */
public class Q5_DSA_Arrays_Prefix_Sum_&_Carry_Forward {
    public int[] sumOfEvenIndexedElements(int[] A, int[][] B) {

        int[] ans=new int[B.length];

        int[] pref_even=new int[A.length];
        pref_even[0]=A[0];

        for(int i=1;i<A.length;i++)
        {
            if(i%2!=0)
                pref_even[i]=pref_even[i-1];

            else 
                pref_even[i]=pref_even[i-1]+A[i];
        }

        for(int i=0;i<B.length;i++)
        {
            int L=B[i][0];
            int R=B[i][1];

            if(L==0)
                ans[i]=pref_even[R];
            else
                ans[i]=pref_even[R]-pref_even[L-1];
        }

        return ans;

        
    }
}
