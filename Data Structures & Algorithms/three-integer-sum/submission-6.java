class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0 ; i<nums.length ; i++) {
            int a = nums[i];
            if(a > 0) {
                break;
            }
            if(i > 0 && nums[i]==nums[i-1]) continue; // handles duplicates

            int l = i+1, r = nums.length - 1;
            while (l < r) {
                int threeSum = a + nums[l] + nums[r];
                if (threeSum > 0) {
                    r--;
                }
                else if(threeSum < 0) {
                    l++;
                }
                else {
                    result.add(Arrays.asList(a, nums[l], nums[r]));
                    l++;
                    r--;
                    while( l < r && nums[l]==nums[l-1]) {
                        l++;
                    }
                    
                }
            }
        }
        return result;
    }
    
}
