class Solution {
     //O (n) both
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < heights.length; i++) {
            int h = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] < h) {
                res[stack.pop()]++;
            }
            if(!stack.isEmpty()) {
                res[stack.peek()]++;
            }
            stack.push(i);
        }
        return res;
    }
}