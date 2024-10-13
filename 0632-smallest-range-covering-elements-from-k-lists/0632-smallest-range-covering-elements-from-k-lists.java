class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        int index = 0;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE, prev=0;


        for(List<Integer> list: nums) {
            minHeap.add(new int[]{list.get(0), 0, index++});
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(0));
        }
        
        int minDiff = max-min;
        int prevMax = max;
        
                        
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currDiff = prevMax - curr[0];
//                        System.out.println(curr[0]+" "+ prevMax+" "+ max +" "+ min +" "+minDiff+" "+currDiff);

            
            if(curr[1] == nums.get(curr[2]).size()-1) {
                if(minDiff>currDiff) {
                    min = curr[0];
                    max = prevMax;
                   
                }
                break;
            } 
            
            if(minDiff>currDiff) {
                min = curr[0];
                max = prevMax;
                 minDiff = currDiff;
            }
            
            
            int newNum = nums.get(curr[2]).get(curr[1]+1);
            prevMax = Math.max(prevMax, newNum);
            minHeap.add(new int[]{newNum, curr[1]+1, curr[2]});
            
        }
        
        
        
        return new int[]{min, max};
    }
    
}