class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        List<String> part = new ArrayList();
        dfs(0,s,part, res);
        return res;
    }

    private void dfs(int i, String s, List<String> part, List<List<String>> res) 
    {
        if(i >= s.length()) {
            res.add(new ArrayList(part));
            return;
        }
        for(int j = i ; j < s.length(); j ++) {
            if(ispalindrom(s, i , j)) {
                part.add(s.substring(i , j+1));
                dfs(j+1, s,part, res);
                part.remove(part.size() - 1);
            }
        }
    }
    private boolean ispalindrom(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
