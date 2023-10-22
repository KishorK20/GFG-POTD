// The problem is to count all the possible paths from top left to bottom right of an MxN matrix with the constraints that from each cell you can either move to right or down.
// Return answer modulo 109+7.
// Input:
// M = 3 and N = 3
// Output: 6
// Explanation:
// Let the given input 3*3 matrix is filled 
// as such:
// A B C
// D E F
// G H I
// The possible paths which exists to reach 'I' from 'A' following above conditions are as follows:ABCFI, ABEHI, ADGHI, ADEFI, ADEHI, ABEFI

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    public int numberOfPaths(int M, int N) {
        final int mod = 1000000007;

        int n = M + N - 2;
        int r = M - 1;
        long ans = 1;

        // Calculate (n choose r) % mod
        for (int i = 1; i <= r; i++) {
            ans = (ans * (n - i + 1)) % mod;
            ans = (ans * modInverse(i, mod)) % mod;
        }

        return (int) ans;
    }

    private long modInverse(long a, int m) {
        return modPow(a, m - 2, m);
    }

    private long modPow(long base, int exp, int mod) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
}
