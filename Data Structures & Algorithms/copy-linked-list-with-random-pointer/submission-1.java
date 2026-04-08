/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap();
        copy.put(null, null);
        Node cur = head;
        while(cur != null) {
            if(!copy.containsKey(cur)) {
                copy.put(cur, new Node(0));
            }
            copy.get(cur).val = cur.val;

            if(!copy.containsKey(cur.next)) {
                copy.put(cur.next, new Node(0));
            }
            copy.get(cur).next = copy.get(cur.next);

            if(!copy.containsKey(cur.random)) {
                copy.put(cur.random, new Node(0));
            }
            copy.get(cur).random = copy.get(cur.random);

            cur = cur.next;
        }
        return copy.get(head);
        
    }
}
