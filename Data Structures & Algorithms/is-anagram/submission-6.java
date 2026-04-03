class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
       
        for(char c : s1) {
            if(map1.get(c)==null) map1.put(c, 0);
            map1.put(c, map1.get(c)+1);

        }
        for(char c : s2) {
            if(map2.get(c)==null) map2.put(c, 0);
            map2.put(c, map2.get(c)+1);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(!entry.getValue().equals(map2.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }
}
