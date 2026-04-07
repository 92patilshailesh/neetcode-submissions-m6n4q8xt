class Solution {
    //O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length ==0) return new int[]{};
        int res[] = new int[temperatures.length];
        Stack<int[]> stack = new Stack(); //pair of temp and index
        for(int i =0 ; i< temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1]; //update diff of index
            }
            stack.push(new int[]{t, i});        
        }
        return res;
    }
}
