class Solution {
    public int maxProfit(int[] prices) {
    //     int l = 0;
    //     int r = 1;
        int maxProfit = 0;
    // while(r < prices.length) {
    //     if(prices[l] < prices[r]) {
    //         int profit = prices[r] - prices[l];
    //         maxProfit = Math.max(maxProfit, profit);
    //     }
    //     else {
    //         l = r;
    //     }
    //     r+=1;
    // }
    // return maxProfit;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
       return maxProfit;
    }
}