class Solution {
    public boolean tastePossible(int[] prices, int k, int taste) {
        int CurrentIndex = 0;
        int count = 1;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (Math.abs(prices[CurrentIndex] - prices[i]) >= taste) {
                count++;
                CurrentIndex = i;
            }
            
        }
        return (count >= k)?true:false;
    }
    public int maximumTastiness(int[] price, int k) {
        int left = 0;
        int maxEle = Arrays.stream(price).max().getAsInt();
        int minEle = Arrays.stream(price).min().getAsInt();
        int right = Math.abs(maxEle - minEle);
        int ans = 0;
        Arrays.sort(price);
        while (left <= right) {
            int taste = left + (right - left) / 2;

            if(tastePossible(price, k, taste)) {
                ans = taste;
                left = taste + 1;
            }else {
                right = taste - 1;
            }
        }
        return ans;
    }
}