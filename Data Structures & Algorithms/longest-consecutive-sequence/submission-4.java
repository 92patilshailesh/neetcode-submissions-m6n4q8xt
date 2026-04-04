class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int result = 1;
        Set<Integer> set = new HashSet();
        for(int num : nums) {
            set.add(num);
        }

        for(Integer num : set) {
            if(!set.contains(num - 1)) {
                int length = 1;
                while(set.contains(num+length)) {
                    length++;
                }
                 result = Math.max(result, length);
            }
        }
        return result;
    }
}
