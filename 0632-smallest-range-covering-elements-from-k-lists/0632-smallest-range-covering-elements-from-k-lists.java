class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        int index = 0;
        for(List<Integer> list: nums) {
            minHeap.add(new int[]{list.get(0), 0, index++});
        }
                
        int start = 0, min = Integer.MAX_VALUE;
        int  startAns=0, endAns = nums.size()-1;
        index = 0;
        
        Map<Integer, Integer> count = new HashMap<>();


        List<int[]> sorted = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            count.put(curr[2], count.getOrDefault(curr[2], 0)+1);
            sorted.add(curr);
            while(count.size() == nums.size()) {
                if(sorted.get(index)[0]-sorted.get(start)[0]<min) {
                    startAns = sorted.get(start)[0];
                    endAns = sorted.get(index)[0];
                    min = sorted.get(index)[0]-sorted.get(start)[0];
                }
                int current = count.get(sorted.get(start++)[2]);
                if(current == 1) {
                    count.remove(sorted.get(start-1)[2]);
                } else {
                    count.put(sorted.get(start-1)[2], current-1);
                }
            }
            index++;
            
            
            if(curr[1] < nums.get(curr[2]).size()-1) {
                minHeap.add(new int[]{nums.get(curr[2]).get(curr[1]+1), curr[1]+1, curr[2]});
            }
        }
        
        
        
        return new int[]{startAns, endAns};
    }
    
}