class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && i<nums.length-2 && nums[i] == nums[i-1]) continue;

            Set<Integer> seen = new HashSet<>();
            
            for(int j=i+1; j< nums.length; j++) {
                int rem = nums[i] + nums[j];
                if(seen.contains(-rem)) {
                    ans.add(List.of(nums[i], nums[j], -rem));
                } else {
                    seen.add(nums[j]);
                }
                
            }
    
        }
        
        return new ArrayList<>(ans);
    }
    
}