class Solution {
    public int characterReplacement(String s, int k) {
        return approach1(s, k);
        //return optimal(s, k)
        
    }

    public int approach1(String s, int k) {
         HashSet<Character> set = new HashSet();
        int res = 0;
        for(char c : s.toCharArray()){
           set.add(c);
        }

        for(char c: set) {
            int count = 0, l = 0;
            for(int r =0 ; r < s.length(); r++) {
                if(s.charAt(r)==c) {
                    count++;
                }

                while ((r-l+1) - count > k) {
                    if(s.charAt(l)==c) {
                        count--;
                    }
                    l++;
                }
                res = Math.max(res, r-l+1);
            }
        }
        return res;
    }

    public int optimal(String s, int k) {
        HashMap<Character, Integer> map = new HashMap();
        int res =0;
        int l = 0, maxf=0;
        for(int r =0 ; r<s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf=Math.max(maxf, map.get(s.charAt(r)));
       
        while((r-l+1)-maxf > k) {
            map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0) - 1);
            l++;
        }
        res = Math.max(res, r - l +1); 
        }
    return res;
    }
}
