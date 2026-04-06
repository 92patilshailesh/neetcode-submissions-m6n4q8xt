class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack();
        Map<Character, Character> closeToOpen = new HashMap();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');
    

        char[] charSet = s.toCharArray(); 
        for(char c : charSet) {
            if (closeToOpen.containsKey(c)) {
                if(! stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                }
                else return false;
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
