class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> map = new HashMap();
        Map<Character, Integer> window = new HashMap();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int have = 0, need = map.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r =0; r<s.length(); r++){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0)+1);
            if(map.containsKey(s.charAt(r)) && window.get(s.charAt(r)).equals(map.get(s.charAt(r)))) {
                have++;
                
            }
            while (have == need) {
                if ( (r- l+1) < resLen) {
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.getOrDefault(leftChar, 0)-1);
                if(map.containsKey(s.charAt(l)) && window.get(s.charAt(l))< map.get(s.charAt(l))) {
                have--;
                }
            l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
     }
}
