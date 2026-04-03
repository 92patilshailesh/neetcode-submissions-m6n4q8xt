class Solution {
    public boolean hasDuplicate(int[] nums) {
        return hasDuplicate2(nums);
    }

    public boolean hasDuplicate1(int[] nums) {
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
    public boolean hasDuplicate2(int[] nums) {
        if(nums == null) return false;
        Set<Integer> uniqueElements = new HashSet();
        for(int i=0; i<nums.length;i++) {
            if (uniqueElements.contains(nums[i])) return true;
            uniqueElements.add(nums[i]);
        }
        return false;
    }
}