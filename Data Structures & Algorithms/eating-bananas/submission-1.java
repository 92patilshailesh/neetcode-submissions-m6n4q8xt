class Solution {
   //O(n∗logm), O(1)
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length==0) return 0;

        int l =1;
        int r = Arrays.stream(piles).max().getAsInt();

        int res = r;
        while(l <=r) {
            int k = (l+r)/2;
            long totalTime = 0;
            for(int p : piles) {
                totalTime+= Math.ceil((double)p/k);
            }
            if(totalTime<=h) {
                res = k;
                r = k-1;
            }
            else {
                l = k+1;
            }
        }
        return res;
    }
}
