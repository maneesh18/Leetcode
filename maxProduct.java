/*
Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.
*/

class Solution {
    static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    // First DFS: compute total tree sum
    long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val 
             + getTotalSum(root.left) 
             + getTotalSum(root.right);
    }

    // Second DFS (postorder): compute subtree sums
    long dfs(TreeNode root) {
        if (root == null) return 0;

        // Get sums of left and right subtrees
        long left = dfs(root.left);
        long right = dfs(root.right);

        // Current subtree sum
        long subSum = root.val + left + right;

        // Try splitting above this node
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root); // O(n)
        dfs(root);                    // O(n)
        return (int)(maxProduct % MOD);
    }
}
