class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0;i < n;i++){
            if(i != 0 && nums[i-1] == nums[i])  continue;
            int left = i+1,right = n-1;
            while(left < right){
                int x = nums[left]+nums[right]+nums[i];
                if(x == 0){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[left]);temp.add(nums[right]);temp.add(nums[i]);
                    ans.add(temp);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1])
                        left++;
                    while(left < right && nums[right] == nums[right+1])
                        right--;
                }else if(x > 0)
                    right--;
                else
                left++;
            }
        }
        return ans;
    }
}
