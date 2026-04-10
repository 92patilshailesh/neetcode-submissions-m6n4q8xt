class Solution {
    //O(n), O(1)
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int slow = 0, fast =0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }
    
        int slow2=0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) {
                return slow;
            }
        }
        //you can use hashset, marking it negative number and taking abs(), use seen[] etc
    }
}
