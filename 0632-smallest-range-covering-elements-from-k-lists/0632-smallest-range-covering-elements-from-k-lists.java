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
        int[] count = new int[nums.size()];
        
        int start = 0, min = Integer.MAX_VALUE;
        int  startAns=0, endAns = 0;
        index = 0;
        
        
        
        for(int[] arr: sorted) {
            count[arr[2]]++;
            while(isSolution(count)) {
                if(sorted.get(index)[0]-sorted.get(start)[0]<min) {
                    startAns = start;
                    endAns = index;
                    min = sorted.get(index)[0]-sorted.get(start)[0];
                }
                count[sorted.get(start++)[2]]--;
            }
            index++;

        }
        
        return new int[]{sorted.get(startAns)[0], sorted.get(endAns)[0]};
    }
    
    boolean isSolution(int[] arr) {
        for(int n: arr) {
            if(n<=0) return false;
        }
        
        return true;
    }
}