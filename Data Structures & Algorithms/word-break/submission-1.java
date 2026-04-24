class Solution {
    //O(n*m*t) n = len of S, m size of dict, t = max size of word in dict and O(n) for space
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >=0 ;i--){
            for(String w : wordDict) {
                if((i+ w.length()) <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
