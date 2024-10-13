class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        int index = 0;
        for(List<Integer> list: nums) {
            minHeap.add(new int[]{list.get(0), 0, index++});
        }
                

        List<int[]> sorted = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            sorted.add(curr);
            if(curr[1] < nums.get(curr[2]).size()-1) {
                minHeap.add(new int[]{nums.get(curr[2]).get(curr[1]+1), curr[1]+1, curr[2]});
            }
        }
        Map<Integer, Integer> count = new HashMap<>();
        
        int start = 0, min = Integer.MAX_VALUE;
        int  startAns=0, endAns = 0;
        index = 0;
        
        
        
        for(int[] arr: sorted) {
            count.put(arr[2], count.getOrDefault(arr[2], 0)+1);
            while(count.size() == nums.size()) {
                if(sorted.get(index)[0]-sorted.get(start)[0]<min) {
                    startAns = start;
                    endAns = index;
                    min = sorted.get(index)[0]-sorted.get(start)[0];
                }
                int curr = count.get(sorted.get(start++)[2]);
                if(curr == 1) {
                    count.remove(sorted.get(start-1)[2]);
                } else {
                    count.put(sorted.get(start-1)[2], curr-1);
                }
            }
            index++;

        }
        
        return new int[]{sorted.get(startAns)[0], sorted.get(endAns)[0]};
    }
    
}