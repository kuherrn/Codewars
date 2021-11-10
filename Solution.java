// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/

class Solution {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 0) return profit;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) profit += prices[i + 1] - prices[i];
        }
        return profit;
    }
}