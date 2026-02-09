/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> nums;
    public TreeNode balanceBST(TreeNode root) {
        nums = new ArrayList<>();
        inorder(root);
        return bst(0,nums.size()-1);
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
    private TreeNode bst(int start, int end){
        if(start > end)
            return null;
        int mid = (start + end)/ 2;
        return new TreeNode(nums.get(mid),bst(start, mid-1),bst(mid+1,end));
    }
}
