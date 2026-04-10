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
    //recursive. //)O(n)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int group = 0;
        while (cur != null && group < k) {
            cur = cur.next;
            group++;
        }

        if (group == k) {
            cur = reverseKGroup(cur, k);
            while (group-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
    //iterative

    public ListNode reverseKGroup2(ListNode head, int k) {
        
        ListNode dummy  = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while(curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while(curr !=null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
