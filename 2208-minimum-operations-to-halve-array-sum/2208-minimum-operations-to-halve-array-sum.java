class Solution {
    
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int n: nums) {
            sum+=n;
            pq.offer(new Double(n));
        }
        
        sum/=2.0;
        int count = 0;
        double current;
        while(sum>0) {
            count++;
            current = pq.poll();
            sum-=current/2;
            pq.offer(current/2);
        }
        
        return count;
    }
}