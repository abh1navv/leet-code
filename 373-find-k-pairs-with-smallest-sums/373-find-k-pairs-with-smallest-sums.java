class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
                
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Pair> pairs = new PriorityQueue<>(
            (a,b) -> a.first+a.second-b.first-b.second);
        
        Arrays.stream(nums1).forEach(n -> pairs.offer(new Pair(n, nums2[0], 0)));
        
        while(k-- > 0 && !pairs.isEmpty()) {
            Pair current = pairs.poll();
            ans.add(List.of(current.first, current.second));
            
            if(current.index != nums2.length-1) {
                pairs.offer(new Pair(current.first, nums2[current.index+1], current.index+1));
            }
        }
        
        return ans;
    }
    
    class Pair {
        int first;
        int second;
        int index;
        
        Pair(int first, int second, int index) {
            this.first = first;
            this.second = second;
            this.index = index;
        }
    }
}