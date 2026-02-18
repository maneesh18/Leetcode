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
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend)
            return null;
        if (pstart == pend)
            return new TreeNode(preorder[pstart]);
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootIndex = map.get(preorder[pstart]);
        int pe = pstart - istart + rootIndex;
        root.left = build(preorder, pstart + 1, pe, inorder, istart, rootIndex - 1);
        root.right = build(preorder, pe + 1, pend, inorder, rootIndex + 1, iend);
        return root;
    }

}
