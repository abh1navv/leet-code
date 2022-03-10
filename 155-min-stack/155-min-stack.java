class MinStack {
    Node head;
    public MinStack() {
        head = new Node(0, Integer.MAX_VALUE, null);
    }
    
    public void push(int val) {
        head = new Node(val, Math.min(val, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    class Node {
        int min;
        int val;
        Node next;
        Node(int val, int min, Node next) {
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */