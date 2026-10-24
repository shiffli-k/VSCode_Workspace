package com.leetcode.easy;

public class BestTimeToBuyAndSellStock {
    // 121. Best Time to Buy and Sell Stock
    
    public static void main(String[] args) {
        int[] testData = {7,1,5,3,6,4};

        IO.print(maxProfit(testData));
    }

    public static int maxProfit(int[] prices) {

        if(prices == null || prices.length < 1) return 0;

        int butAtPrice = prices[0];
        int maxProfitSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            
            int currentPrice = prices[i];

            butAtPrice = Math.min(butAtPrice, currentPrice);

            maxProfitSoFar = Math.max(maxProfitSoFar, currentPrice - butAtPrice);
            
        }

        return maxProfitSoFar;
    }
}
