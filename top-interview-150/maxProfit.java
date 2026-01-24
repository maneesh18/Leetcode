class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1)
            return 0;
        int buy = prices[0], max = 0;
        for(int i = 1;i < n;i++){
            max = Math.max(max, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return max;
    }
}
