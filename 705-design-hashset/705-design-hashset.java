class MyHashSet {
    boolean[] arr;
    public MyHashSet() {
        arr = new boolean[100001];
    }
    
    public void add(int key) {
        arr[key % 100001] = true;
    }
    
    public void remove(int key) {
        arr[key % 100001] = false;
    }
    
    public boolean contains(int key) {
        return arr[key % 100001];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */