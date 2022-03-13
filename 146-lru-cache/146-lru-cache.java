class LRUCache {

    Map<Integer, Node> cache;
    Node head, tail;

    int capacity;
    int currCapacity = 0;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        removeNode(node);
        putAtEnd(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        
        removeNode(cache.get(key));
        putAtEnd(newNode);
        
        cache.put(key, newNode);
        checkCapacity();
    }
    
    private void putAtEnd(Node newNode) {
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        currCapacity++;

    }
    
    private void checkCapacity() {
        if(currCapacity > capacity) {
            cache.remove(head.next.key);
            removeNode(head.next);
        }
    }
    
    private void removeNode(Node node) {    
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            currCapacity--;
        }
    }
    
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        public String toString() {
            return key+"-"+val+"-"+next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */