/*
Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
*/

class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int NEG = (int)-1e9;
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j] = NEG;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take = a[i-1]*b[j-1] + Math.max(0, dp[i-1][j-1]);
                dp[i][j] = Math.max(take, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[n][m];
    }
}


