class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};
        //return dequeSolution(nums, k);
        return heapSolution(nums, k);
    }
    //O(n) both
    public int[] dequeSolution(int[] nums, int k) {
        int n=nums.length;
        int[] output = new int[n-k+1];
        Deque<Integer> q = new LinkedList();
        int l=0, r=0;
        while( r < n) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if( l > q.getFirst()){
                q.removeFirst();
            }
            if((r+1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;

    }

    public int[] heapSolution(int[] nums, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int index =0;
        for(int i=0;i< nums.length; i++) {
            heap.offer(new int[] {nums[i], i});
            if (i >= k-1) {
                while(heap.peek()[1] <= i-k) {
                    heap.poll();
                }
                output[index++] = heap.peek()[0];
            }
        }
        return output;
    }
}
