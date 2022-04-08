class KthLargest {

    final PriorityQueue<Integer> q;
        final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */