class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>( (a , b) -> a < b ? 1 : a > b ? -1 : 0);
        
        for (int num : nums){
            sum += num;
            queue.add((double)num);
        }
        
        double target = sum / 2;
        double current;
        int moves = 0;
        
        while (target > 0){
            current = queue.poll();
            
            current /= 2;
            target -= current;
            queue.add(current);
            ++moves;
        }
        
        return moves;
    }
}