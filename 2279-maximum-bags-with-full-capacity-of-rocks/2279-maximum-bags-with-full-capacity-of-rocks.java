class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<capacity.length; i++) {
            pq.offer(capacity[i]-rocks[i]);
        }        
        int ans = 0;
        while(!pq.isEmpty() && pq.peek() <= additionalRocks) {
            ans++;
            additionalRocks-=pq.poll();
        }
        
        return ans;
    }
    
    
}