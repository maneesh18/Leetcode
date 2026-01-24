class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
	int jumps = 0, curEnd = 0, curFarthest = 0;
	for (int i = 0; i < n - 1; i++) {
		curFarthest = Math.max(curFarthest, i + nums[i]);
        if(curFarthest >= n - 1)
            return jumps+1;
		if (i == curEnd) {
			jumps++;
			curEnd = curFarthest;
		}
	}
	return jumps;
}
}
