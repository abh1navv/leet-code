class Solution {
    public int[] dailyTemperatures(int[] temps) {
        PriorityQueue<Temp> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        
        int[] ans = new int[temps.length];
        Temp curr;
        for(int i=0; i<temps.length; i++) {
            while(!pq.isEmpty() && pq.peek().value < temps[i]) {
                curr = pq.poll();
                ans[curr.pos] = i-curr.pos;
            }
            pq.offer(new Temp(temps[i], i));
        }
        
        while(!pq.isEmpty()) {
            ans[pq.poll().pos] = 0;
        }
        
        return ans;
    }
    
    class Temp {
        int value;
        int pos;
        
        Temp(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }
}