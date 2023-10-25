// Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. 
// Determine the fewest cuts needed for palindrome partitioning of the given string.



//User function Template for Java

class Solution{
    int n;
    List<Integer>[] adj;
    char[] s;
    void expand(int i, int j) {
        while (i >= 0 && j < n && s[i] == s[j]) {
            adj[i].add(j+1);
            i--;
            j++;
        }
    }
    int palindromicPartition(String S) {
        s = S.toCharArray();
        n = s.length;
        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            expand(i, i);
            expand(i, i+1);
        }
        Queue<Integer> q = new LinkedList<>();
        byte[] vis = new byte[n];
        q.add(0);
        vis[0] = 1;
        int d = 0;
        while (!q.isEmpty()) {
            int z = q.size();
            while (z-- > 0) {
                int u = q.remove();
                for (int v : adj[u]) {
                    if (v == n) return d;
                    if (vis[v] == 0) {
                        q.add(v);
                        vis[v] = 1;
                    }
                }
            }
            d++;
        }
        return n-1;
    }
}

