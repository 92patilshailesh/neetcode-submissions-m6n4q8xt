class Solution {
    //O(n) and O(1)
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

    //prefix, suffix approach
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int prefix = 0, suffix = 0;

        for (int i = 0; i < n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - 1 - i] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
