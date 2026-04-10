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

    public ListNode mergeList(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        return divide(lists, 0, lists.length -1);
    }
    private ListNode divide(ListNode[] lists, int l, int r) {
        if(l > r) {
            return null;
        }
        if(l == r) {
            return lists[l];
        }
        int mid = (l+r)/2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid +1, r);
        return conquer(left, right);
    }

    private ListNode conquer(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(l1!= null && l2 != null ){
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!=null) {
            curr.next = l1;
        }
        else {
            curr.next = l2;
        }
        return dummy.next;
    }
}
