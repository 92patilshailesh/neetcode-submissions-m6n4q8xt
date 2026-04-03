class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null) return false;
        Arrays.sort(nums);
        int i=1;
        int j=0;
        for(i=1; i<nums.length;i++) {
            if(nums[i]==nums[j]){
                return true;
            }
            j++;
        }
        return false;
    }
}