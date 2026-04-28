class Solution {
    //O(n) and O(1) 
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0], curSum=0;
        for(int num: nums){
            if(curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
        
    }

    //dp approach
    public int maxSubArray2(int[] nums) {
        int[] dp = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int maxSum = dp[0];
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
