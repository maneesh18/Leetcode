/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

*/
class Solution {
    private int totallevel;
    private int sumatlevels[] = new int[10000];
    public int maxLevelSum(TreeNode root) {
        int ans =1,maxsum = Integer.MIN_VALUE;
        maxlevelsumhelper(root,0);
        for(int i=0;i<=totallevel;i++){
            int sum = sumatlevels[i];
            if(sum>maxsum){
                maxsum = sum;
                ans = i+1;
            }
        }
        System.gc();
        return ans;
    }

    private void maxlevelsumhelper(TreeNode t,int l){
        if(t == null)
            return;
        sumatlevels[l]+=t.val;
        totallevel = Math.max(totallevel,l);
        maxlevelsumhelper(t.right,l+1);
        maxlevelsumhelper(t.left,l+1);
    }
}
