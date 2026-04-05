class Solution {
    //O(n), O(1)
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int result = 0;
        int l = 0 , r = height.length - 1, lmax=height[l], rmax=height[r];

        while(l < r) {
            if(lmax < rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                result += lmax - height[l];
            }
            else {
                r--;
                rmax = Math.max(rmax, height[r]);
                result += rmax - height[r];
            }
        }
        return result;
        //2nd apporach is, populate lefMax array, rightMax array with 2 iterations, 
        //calculate result with Math.min(leftMax[i], rightMax[i]) - height[i]
        
    }
}
