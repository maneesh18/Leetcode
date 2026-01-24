class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, k = 0;
        while(i < nums.length){
            if(i + 1 < nums.length && nums[i] == nums[i+1]){
                nums[k++] = nums[i++];
                nums[k++] = nums[i++];
                while(i < nums.length && nums[k-1] == nums[i])
                    i++;
            }
            else
                nums[k++] = nums[i++];
        }
        return k;
    }
}
