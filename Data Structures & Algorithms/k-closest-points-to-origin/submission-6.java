class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
       for(int[] point : points) {
        int dist = point[0] * point[0] + point[1] * point[1];
        heap.offer(new int[] {dist, point[0], point[1]});
        if(heap.size() > k) {
            heap.poll();
        }
       } 

        int[][] result = new int[k][2];
        for( int i = 0 ; i < k ; i++) {
            int[] point = heap.poll();
            result[i] = new int[]{point[1], point[2]};

        }
        return result;
    }
}
