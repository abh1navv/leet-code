class SmallestInfiniteSet {

    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
    }
    int count = 1;
    
    public int popSmallest() {
        set.add(count++);
        return set.pollFirst();
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */