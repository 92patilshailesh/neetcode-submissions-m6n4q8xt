class ListNode{
    int key, val, freq;
    ListNode prev, next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLL {
    private ListNode left, right;
    private int size;

    DLL() {
        this.left = new ListNode(0,0);
        this.right = new ListNode(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }

    public int length() {
        return size;
    }

    public void pushRight(ListNode node) {
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        size++;
    }

    public void pop(ListNode node) {
        ListNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public ListNode popLeft() {
        ListNode node = this.left.next;
        pop(node);
        return node;
    }
}
class LFUCache {
    private int capacity;
    private int lfucount;
    private Map<Integer, ListNode> nodeMap;
    private Map<Integer, DLL> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfucount = 0 ;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) {
            return -1;
        }
        ListNode node = nodeMap.get(key);
        counter(node);
        return node.val;
        
    }
    
    private void counter(ListNode node) {
        int count = node.freq;
        listMap.get(count).pop(node);
        if(count == lfucount && listMap.get(count).length()== 0) {
            lfucount++;
        }
        node.freq++;
        listMap.putIfAbsent(node.freq, new DLL());
        listMap.get(node.freq).pushRight(node);
    }


    public void put(int key, int value) {
        if(capacity==0) {
            return;
        }
        if(nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);
            node.val = value;
            counter(node);
            return;
        }
        
        if(nodeMap.size() == capacity) {
            ListNode toRemove = listMap.get(lfucount).popLeft();
            nodeMap.remove(toRemove.key);
        }

        ListNode node = new ListNode(key, value);
        nodeMap.put(key, node);
        listMap.putIfAbsent(1, new DLL());
        listMap.get(1).pushRight(node);
        lfucount = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */