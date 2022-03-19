class Solution {
    
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a , b) -> a < b ? 1 : a > b ? -1 : 0);
        double sum = 0;
        for(int n: nums) {
            sum+=n;
            pq.add((double)n);
        }
        
        sum/=2.0;
        int count = 0;
        double current;
        while(sum>0) {
            count++;
            current = pq.poll();
            sum-=current/2;
            pq.add(current/2);
        }
        
        return count;
    }
}