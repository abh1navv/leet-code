class MyStack {

    Queue<Integer> pusher;
    Queue<Integer> popper;
    
    public MyStack() {
        pusher = new LinkedList<>();
        popper = new LinkedList<>();
    }
    
    public void push(int x) {
        popper.offer(x);
    }
    
    public int pop() {
        while(popper.size() > 1) {
            pusher.offer(popper.poll());
        }
        int value = popper.poll();
        Queue<Integer> temp = pusher;
        pusher = popper;
        popper = temp;
        return value;
    }
    
    public int top() {
        while(popper.size() > 1) {
            pusher.offer(popper.poll());
        }
        return popper.peek();
    }
    
    public boolean empty() {
        return pusher.isEmpty() && popper.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */