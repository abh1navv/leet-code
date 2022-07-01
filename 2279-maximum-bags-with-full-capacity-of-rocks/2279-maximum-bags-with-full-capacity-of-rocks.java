class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = preprocess(capacity, rocks);
        
        int ans = 0;
        while(!pq.isEmpty() && pq.peek() <= additionalRocks) {
            ans++;
            additionalRocks-=pq.poll();
        }
        
        return ans;
    }
    
    PriorityQueue<Integer> preprocess(int[] capacity, int[] rocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<capacity.length; i++) {
            //if(capacity[i]-rocks[i]>0) {
                pq.offer(capacity[i]-rocks[i]);
            //}
        }
        
        return pq;
    }
    
}