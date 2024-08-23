class BrowserHistory {

    Node curr;
    Node home;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage, null, null);
        home = curr;
    }
    
    public void visit(String url) {
        Node newNode = new Node(url, null, curr);
        curr.next = newNode;
        curr = newNode;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && curr != null) {
            curr = curr.prev;
        }
        if(curr == null) {
            curr = home;
        }
        
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && curr.next != null) {
            curr = curr.next;
        }
        
        return curr.url;
    }
    
    private static class Node {
        String url;
        Node next;
        Node prev;
        
        public Node(String url, Node next, Node prev) {
            this.url = url;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */