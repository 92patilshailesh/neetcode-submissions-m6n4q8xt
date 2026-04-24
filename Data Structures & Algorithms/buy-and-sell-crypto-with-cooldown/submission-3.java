class Solution {
    private Map<String, Integer> dp = new HashMap();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
        
    }

    private int dfs(int i, boolean buy, int[] prices){
        if(i >= prices.length) return 0;

        String key = i + "_" + buy;
        if(dp.containsKey(key)) return dp.get(key);

        int cooldown = dfs(i+1, buy, prices);
        if(buy) {
            int bought = dfs(i+1, false, prices) - prices[i];
            dp.put(key, Math.max(bought, cooldown));
        }
        else {
            int sold = dfs(i+2, true, prices) + prices[i];
            dp.put(key, Math.max(sold, cooldown));
        }
        return dp.get(key);
    }
}
