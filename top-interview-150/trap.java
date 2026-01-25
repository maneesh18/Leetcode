class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int rightmax[] = new int[n];
        rightmax[n- 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) 
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        int leftmax = height[0];
        int water = 0;
        for(int i = 1;i + 1< n;i++){
            int minHt = Math.min(leftmax,rightmax[i]);
            if(minHt > height[i])
                water += (minHt - height[i]);
            leftmax = Math.max(height[i], leftmax);
        }
        return water;
    }
}
