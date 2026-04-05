class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int l =0 , r = 1, profit = 0;
        while(r < prices.length) {
            if(prices[r] > prices[l]){
                profit = Math.max(profit, prices[r]-prices[l]);
            }
            else{
                l = r;
            }
            r++;
        }
        return profit;
        
    }
}
