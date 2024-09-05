class StockSpanner {

    LinkedList<Price> stack;
    public StockSpanner() {
         stack=new LinkedList<>();
    }
    
    public int next(int price) {
        Price newPrice = new Price(price, 1);
        while(!stack.isEmpty() && stack.peekLast().val <= price) {
            newPrice.lower += stack.pollLast().lower;
        }
        stack.add(newPrice);
        
        return newPrice.lower;
    }
    
    private static class Price {
        int val;
        int lower;
        
        Price(int val, int lower) {
            this.val= val;
            this.lower = lower;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */