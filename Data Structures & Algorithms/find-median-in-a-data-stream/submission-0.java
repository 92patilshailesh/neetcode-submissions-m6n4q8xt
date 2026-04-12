class MedianFinder {
    private PriorityQueue<Integer> small ;
    private PriorityQueue<Integer> large ;


    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> b -a);
        large = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        small.offer(num);
        if(small.size() - large.size() > 1 || !large.isEmpty() && small.peek() > large.peek()){
            large.offer(small.poll());
        }
        if(large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
        
    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            return (double) (small.peek() + large.peek()) / 2;
        }
        else if (small.size() > large.size()) {
            return (double) small.peek();
        }
        else {
            return (double) large.peek();
        }
        
    }
}
