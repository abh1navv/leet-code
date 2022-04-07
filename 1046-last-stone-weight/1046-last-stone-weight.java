class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if(stones.length == 1) return stones[0];
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone: stones) {
            pq.offer(stone);
        }
        int first=0, second=0;
        while(pq.size() > 1) {
            second = pq.poll();
            first = pq.poll();
            pq.offer(second-first);
        }
        
        
        return pq.isEmpty() ? second-first: pq.poll();
    }
}