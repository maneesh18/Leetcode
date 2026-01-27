class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;
        int start = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                ans = Math.min(ans, i - start + 1);
                // System.out.println(start + " -> " + i);
                sum -= nums[start++];
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
