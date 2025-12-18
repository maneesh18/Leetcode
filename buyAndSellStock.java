/*You are given two integer arrays prices and strategy, where:

prices[i] is the price of a given stock on the ith day.
strategy[i] represents a trading action on the ith day, where:
-1 indicates buying one unit of the stock.
0 indicates holding the stock.
1 indicates selling one unit of the stock.
You are also given an even integer k, and may perform at most one modification to strategy. A modification consists of:

Selecting exactly k consecutive elements in strategy.
Set the first k / 2 elements to 0 (hold).
Set the last k / 2 elements to 1 (sell).
The profit is defined as the sum of strategy[i] * prices[i] across all days.

Return the maximum possible profit you can achieve.
*/


class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long profit = 0L;
        int n = prices.length;
      // to precompute the future profits
        long cache = 0L;
        for(int i = 0;i < n; i++){
            long temp = strategy[i] * prices[i];
            if(i>=k)
                profit += temp;
            else
                cache += temp;
        }
      // max profit without any update
        long max = profit + cache;
        for(int i = 0;i < k; i++)
            profit += ((i*2)/k) * prices[i];
        max = Math.max(profit, max);
        for(int i = k;i < n; i++){
            int start = i - k;
            int mid = i - (k/2);
          // following Sliding window Technique to reduce Computation time.
            profit += (prices[start] * strategy[start]) + prices[i] - prices[mid] - (prices[i] * strategy[i]);
            max = Math.max(profit, max);
        }
        return max;
    }
}
