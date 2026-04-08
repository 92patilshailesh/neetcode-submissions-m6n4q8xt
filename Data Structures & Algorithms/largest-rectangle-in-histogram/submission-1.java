class Solution {
    /*
    We want, for every bar, to know how wide it can stretch while still being the shortest bar in that rectangle.

A monotonic stack helps with this:

We keep a stack of indices where the bar heights are in increasing order.
As long as the next bar is taller or equal, we keep pushing indices.
When we see a shorter bar, it means the bar on top of the stack can’t extend further to the right:
We pop it and treat it as the height of a rectangle.
Its width goes from the new top of the stack + 1 up to the current index − 1.
To make sure every bar eventually gets popped and processed, we run the loop one extra step with a “virtual” bar of height 0 at the end.
Each bar is pushed and popped at most once, so this is both optimal and clean.
    */

    //O(n) both
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                 (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
