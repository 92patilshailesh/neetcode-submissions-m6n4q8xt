class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        StringBuilder stack = new StringBuilder();
        backtrack(0,0,n, res, stack);

        return res;
        
    }
    private void backtrack(int open, int close, int n, List<String> res, StringBuilder stack) {
        if(open == close && open == n) {
            res.add(stack.toString());
            return;
        }
        if(open < n) {
            stack.append('(');
            backtrack(open+1, close, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if(close < open) {
            stack.append(')');
            backtrack(open, close+1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
