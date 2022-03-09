class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> pq = new LinkedList<>();

        int[] ans=new int[nums.length-k+1];
                
        for(int i=0; i< nums.length; i++) {
            while(!pq.isEmpty() && pq.peek() < i-k+1) {
                pq.poll();
            }
            
            while(!pq.isEmpty() && nums[i] >= nums[pq.peekLast()]) {
                pq.pollLast();
            }
            
            pq.offer(i);
            
            if(i-k+1 >= 0) {
                ans[i-k+1] = nums[pq.peek()];
            }
        }
        
        return ans;
        
    }
}