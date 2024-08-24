class RecentCounter {

    int counter;
    Node head = null;
    Node tail = null;
    public RecentCounter() {
        counter = 0;
    }
    
    public int ping(int t) {
        Node newNode = new Node();
        newNode.val = t;
        
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        while(head!=null && newNode.val - head.val >3000) {
            head = head.next;


            counter--;
        }

        
        counter++;
        
        return counter;
    }
    
    private static class Node {
        int val;
        Node next;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */