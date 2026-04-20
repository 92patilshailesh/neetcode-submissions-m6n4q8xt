class Solution {
    private List<String> res = new ArrayList();
    public String[] digitToChar = {
        "","","abc", "def","ghi","jkl", "mno","pqrs", "tuv","wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }
    
    private void backtrack(int i, String cur, String digits) {
        if(cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()) {
            backtrack(i +1, cur +c, digits);
        }
    }
}
