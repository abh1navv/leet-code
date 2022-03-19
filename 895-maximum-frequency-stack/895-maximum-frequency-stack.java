class FreqStack {

    TreeSet<Node> pq;
    Map<Integer, Node> map;
    int top;
    
    public FreqStack() {
        pq = new TreeSet<>((a,b) -> {
            if(b.freq - a.freq !=0) return b.freq - a.freq;
            else return b.indexes.get(b.indexes.size()-1) - a.indexes.get(a.indexes.size()-1);
        });
        top = 0;
        map = new HashMap<>();
    }
    
    public void push(int val) {
        Node node = map.get(val);
        
        if(node != null) {
            pq.remove(node);
            node.indexes.add(top);
            node.freq++;
            pq.add(node);
        } else {
            node = new Node(val, top);
            pq.add(node);
        }
        top++;
        map.put(val, node);

    }
    
    public int pop() {
        Node node = pq.first();
        pq.pollFirst();

        node.freq--;
        node.indexes.remove(node.indexes.size()-1);
        if(node.freq == 0) {
            map.remove(node.val);
        } else {
            //pq.pollFirst();
            pq.add(node);
        }
        return node.val;
    }
    
    
}
class Node {
    int val;
    List<Integer> indexes;
    int freq;

    Node(int val, int index) {
        this.val = val;
        this.freq = 1;
        indexes = new ArrayList<>();
        indexes.add(index);
    }

    public String toString() {
        return val+":"+ indexes+":"+freq;
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public boolean equals(Object that) {
        return this.val == ((Node)that).val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */