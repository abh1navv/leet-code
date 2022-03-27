class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> seen = new HashMap<>();
        int n=nums1.length;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int curr = -nums1[i]-nums2[j];
                seen.put(curr, seen.getOrDefault(curr, 0)+1);
            }
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int curr = nums3[i]+nums4[j];
                if(seen.containsKey(curr)){
                    count+=seen.get(curr);
                }
            }
        }
        
        return count;
    }
}