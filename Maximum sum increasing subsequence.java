//Given an array of n positive integers. Find the sum of the maximum sum subsequence 
//of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.
//Input: 
//N = 5, arr[] = {1, 101, 2, 3, 100} 
//Output: 
//106
//Explanation:
//The maximum sum of a increasing sequence is obtained from {1, 2, 3, 100},


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // Initialize with the element itself
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
	}  
}
