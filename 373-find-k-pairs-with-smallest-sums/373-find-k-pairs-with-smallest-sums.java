class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
                
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pairs = new PriorityQueue<>(
            (a,b) -> a.get(0)+a.get(1)-b.get(0)-b.get(1));
        
        Arrays.stream(nums1).forEach(n -> pairs.offer(List.of(n, nums2[0], 0)));
        
        while(k-- > 0 && !pairs.isEmpty()) {
            List<Integer> current = pairs.poll();
            ans.add(List.of(current.get(0), current.get(1)));
            
            if(current.get(2) != nums2.length-1) {
                pairs.offer(List.of(current.get(0), nums2[current.get(2)+1], current.get(2)+1));
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