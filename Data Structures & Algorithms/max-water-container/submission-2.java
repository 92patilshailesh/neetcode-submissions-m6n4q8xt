class Solution {
    //O(n)
    public int maxArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;

        int l = 0, r = heights.length - 1, area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(heights[l], heights[r]) * (r - l));
            if(heights[l] <= heights[r]){
                l++;
            }
            else {
                r--;
            }
        } 
        return area;
    }
}
