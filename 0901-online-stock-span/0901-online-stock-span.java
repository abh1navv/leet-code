class StockSpanner {

    Stack<Price> stack;
    public StockSpanner() {
         stack=new Stack<>();
    }
    
    public int next(int price) {
        Price newPrice = new Price(price, 1);
        while(!stack.isEmpty() && stack.peek().val <= price) {
            newPrice.lower += stack.pop().lower;
        }
        stack.push(newPrice);
        
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