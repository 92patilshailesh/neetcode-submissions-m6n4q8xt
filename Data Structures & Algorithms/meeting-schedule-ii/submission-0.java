/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    //O(nlogn) and O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(Interval interval : intervals) {
            if(!heap.isEmpty() && heap.peek() <= interval.start) {
                heap.poll();
            }
            heap.offer(interval.end);
        }
        return heap.size();
    }
}
