class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length== 0) return 0;
        Stack<Integer> stack = new Stack();
        for(String c : tokens){
            switch (c) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int asub = stack.pop();
                    int bsub = stack.pop();
                    stack.push(bsub - asub);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
