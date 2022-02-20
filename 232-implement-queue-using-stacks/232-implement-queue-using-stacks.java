class MyQueue {
    
    List<Integer> pusher;
    List<Integer> popper;
    
    public MyQueue() {
        pusher = new ArrayList<>();
        popper = new ArrayList<>();
    }
    
    public void push(int x) {
        pusher.add(x);
    }
    
    public int pop() {
        if(popper.isEmpty()) {
            fillPopper();
        }
        
        return popper.remove(popper.size()-1);
    }
    
    public int peek() {
        if(popper.isEmpty()) {
            fillPopper();
        }
        
        return popper.get(popper.size()-1);
    }
    
    public boolean empty() {
        return popper.isEmpty() && pusher.isEmpty();
    }
    
    private void fillPopper() {
        int s = pusher.size();
        while(s!=0)
        {
            popper.add(pusher.remove(--s));
        }
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */