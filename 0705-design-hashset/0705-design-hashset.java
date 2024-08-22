class MyHashSet {
    
    Node arr[];
    int cap = 100;

    public MyHashSet() {
        arr = new Node[cap];
    }
    
    public void add(int key) {
        int hashIndex = key%100;
        if(arr[hashIndex] == null) {
            arr[hashIndex] = new Node(key, null);
        } else if(!containsNode(arr[hashIndex], key)) {
            addToEnd(arr[hashIndex], key);
        }
    }
    
    public void addToEnd(Node head, int key) {
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(key, null);
    }
    
    public void remove(int key) {
        int hashIndex = key%100;
        if(arr[hashIndex] == null) {
            return;
        }
        if(arr[hashIndex].val == key) {
            arr[hashIndex] = arr[hashIndex].next;
            return;
        }
        
        removeNode(arr[hashIndex], key);
    }
    
    public void removeNode(Node head, int key) {
        while(head.next != null && head.next.val != key) {
            head = head.next;
        }         
        head.next = head.next != null ? head.next.next: null;
    }
    
    public boolean contains(int key) {
        int hashIndex = key%100;
        return containsNode(arr[hashIndex], key);
    }
    
    public boolean containsNode(Node head, int key) {
        if(head == null) return false;
        
        while(head != null) {
            if(head.val == key) {
                return true;
            }
            head = head.next;
        }
        
        return false;
    }
    
    public static class Node {
        int val;
        Node next;
        
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */