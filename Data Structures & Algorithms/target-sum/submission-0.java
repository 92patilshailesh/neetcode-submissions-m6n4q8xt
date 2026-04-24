class Solution {
    //O(n*m) and O(m)
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap();
        dp.put(0,1);
        for(int num : nums) {
            Map<Integer, Integer> nextdp = new HashMap();
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();

                nextdp.put(total + num, nextdp.getOrDefault(total + num, 0) + count);
                nextdp.put(total - num, nextdp.getOrDefault(total - num, 0) + count);

            }
            dp = nextdp;
        }
        return dp.getOrDefault(target, 0);
    }
}
