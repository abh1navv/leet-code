class Solution {
    public int[] dailyTemperatures(int[] temps) {
        PriorityQueue<Temp> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        pq.offer(new Temp(temps[0], 0));
        
        int[] ans = new int[temps.length];
        for(int i=1; i<temps.length; i++) {
            while(!pq.isEmpty() && pq.peek().value < temps[i]) {
                Temp curr = pq.poll();
                ans[curr.pos] = i-curr.pos;
            }
            pq.offer(new Temp(temps[i], i));
        }
        
        while(!pq.isEmpty()) {
            Temp curr = pq.poll();
            ans[curr.pos] = 0;
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