class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.sum-b.sum);
        
        for(int i=0; i<nums.length;i++) {
            pq.offer(new Pair(nums[i], i));
        }
        
        int modulo = 1000000007;
        
        int counter = 0, rangeSum=0;
        while(counter<right) {
            counter++;
            
            Pair current = pq.poll();
            if(counter>=left && counter<=right) {
                rangeSum = (rangeSum + current.sum)%modulo;
            }
                        
            if(current.index<nums.length-1) {
                pq.offer(new Pair(current.sum+nums[current.index+1], current.index+1));
            }
        }
        
        return rangeSum;
    }
    
    class Pair {
        int sum;
        int index;
        
        Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}