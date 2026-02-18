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
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap();
        for(int i = 0; i < inorder.length;i++)
            map.put(inorder[i],i);
        return build(0, inorder.length - 1, inorder, 0, inorder.length - 1, postorder); 
    }
    private TreeNode build(int istart, int iend, int[] inorder,int pstart, int pend, int[] postorder){
        if (istart > iend || pstart > pend)
            return null;
        TreeNode root = new TreeNode(postorder[pend]);
        if(pstart == pend)
            return root;
        int idx = map.get(postorder[pend]);
        int leftSize = idx - istart;
        int rightSize = iend - idx;
        root.left = build(istart, idx - 1, inorder, pstart, pstart + leftSize - 1, postorder);
        root.right = build(idx + 1, iend, inorder, pend - rightSize, pend - 1, postorder);
        return root;
    }
}
