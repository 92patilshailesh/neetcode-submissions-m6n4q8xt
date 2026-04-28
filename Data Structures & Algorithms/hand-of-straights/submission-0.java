class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> count = new HashMap();
        for(int n : hand) {
            count.put(n, 1+ count.getOrDefault(n, 0));
        }

        PriorityQueue<Integer> min = new PriorityQueue<>(count.keySet());

        while(!min.isEmpty()) {
            int first = min.peek();
            for(int i = first; i < first + groupSize; i++){
                if(!count.containsKey(i)) {
                    return false;
                }
                count.put(i, count.get(i)- 1);
                if(count.get(i) == 0) {
                    if(i != min.peek()) {
                        return false;
                    }
                    min.poll();
                }
            }
        }
        return true;
    }
}
