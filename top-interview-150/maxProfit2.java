class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] arr : dp)
            Arrays.fill(arr, - 1);
        return profit(prices, 0, 1);
    }
    private int profit(int[] prices, int i, int canBuy){
        if(i == prices.length)
            return 0;
        if(dp[i][canBuy] != -1)
            return dp[i][canBuy];
        int p = 0;
        if(canBuy == 1)
            p = profit(prices, i+1, 0) - prices[i];
        else
            p = profit(prices, i+1, 1) + prices[i];
        return dp[i][canBuy] = Math.max(p, profit(prices, i+1, canBuy));
    }
}
