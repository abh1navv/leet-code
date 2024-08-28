class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> b-a);
        
        for(int n:nums) {
            pq.add(n);
        }
        
        for(int i=1; i<k; i++) {
            pq.poll();
        }
        
        return pq.poll();
    }
}