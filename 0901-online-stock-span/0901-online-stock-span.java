class StockSpanner {

    int count=-1;
    List<Integer> list=new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int index=count;
        int ans=0;
        while(index>=0 && list.get(index--) <= price) {
            ans++;
        }
        
        list.add(price);
        count++;

        return ans+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */