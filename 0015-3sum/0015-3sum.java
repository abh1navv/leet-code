class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        
        Set<List<Integer>> ans = new HashSet<>();
        
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j=i+1;
            int k= nums.length-1;
            
            
            while(j<k) {
                //while(j< k && nums[j] == nums[j+1]) j++;
                //while(k >j && nums[k] == nums[k-1]) k--;
                
                //System.out.println(List.of(nums[i], nums[j], nums[k]));
                
                if(nums[j] + nums[k] == -1*nums[i]) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(nums[j] + nums[k] > -1*nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return new ArrayList<>(ans);
    }
    
}