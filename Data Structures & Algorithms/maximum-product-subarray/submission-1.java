class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = 1, max =1;
        for(int num : nums){
            int tmp = max * num;
            max = Math.max(Math.max(tmp, num * min), num);
            min = Math.min(Math.min(tmp, num * min), num);
            res = Math.max(res, max);
        }
        return res;
    }
}
