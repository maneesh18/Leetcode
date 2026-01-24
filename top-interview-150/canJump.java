class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int distToJump = nums.length - 1;
        for(int i = nums.length - 1; i >= 0;i--){
            if(nums[i] + i >= distToJump)
                distToJump = i;
        }
        return distToJump == 0;
    }
}
