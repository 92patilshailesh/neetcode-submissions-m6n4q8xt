/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    //O(nlogk) and O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list: lists) {
            if(list!= null)
                minheap.offer(list);
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(!minheap.isEmpty()){
            ListNode node = minheap.poll();
            cur.next = node;
            cur = cur.next;

            node = node.next;
            if(node!=null) {
                minheap.offer(node);
            }
        }
        return res.next;
    }
}
