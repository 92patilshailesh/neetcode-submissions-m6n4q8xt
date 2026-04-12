class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
        
    }
}
